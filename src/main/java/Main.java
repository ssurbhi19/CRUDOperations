import OperationBundle.CRUDOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main
{

    static public Connection conn = null;
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/databasecrud";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Model.Employee emp=  new Model.Employee();

        int choice;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Press : \n 1:Insert \n 2:Delete \n 3:Update \n 4:Display ");
            String option = reader.readLine();

            choice=Integer.parseInt(option);


            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter name, city, age, deptName");
                    String empInfo = reader.readLine();
                    String[] splited = empInfo.split("\\s+");
                    emp.setName(splited[0]);
                    emp.setCity(splited[1]);
                    emp.setAge(Integer.parseInt(splited[2]));
                    emp.setDeptName(splited[3]);

                    CRUDOperations.insert(emp,conn);
                }
                        break;
                case 2:
                    {
                        System.out.println("Enter id to be deleted");
                        String id=reader.readLine();

                        CRUDOperations.delete(Integer.parseInt(id),conn);
                    }
                        break;
                case 3:
                {
                    System.out.println("Enter id whose record is to be updated");
                    String id1 = reader.readLine();
                    int id= Integer.parseInt(id1);
                    System.out.println("Enter new details.(name, city, age, deptName)");
                    String empInfo = reader.readLine();

                    String[] splited = empInfo.split("\\s+");
                    emp.setName(splited[0]);
                    emp.setCity(splited[1]);
                    emp.setAge(Integer.parseInt(splited[2]));
                    emp.setDeptName(splited[3]);

                    CRUDOperations.update(id,emp,conn);
                }
                break;
                case 4:
                {
                    CRUDOperations.display(conn);
                }
                break;
                default: System.out.println("Wrong option selected");
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}