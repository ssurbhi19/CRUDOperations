import Model.Employee;
import Operations.CRUDOperations;

import java.sql.*;
import java.util.*;
import java.io.*;
public class Main
{

    public static Connection conn = null;
    public static void main(String args[]) throws IOException, SQLException
    {
        FileReader fileReader=new FileReader("C:\\Users\\SurbhiVerma\\JDBC\\src\\main\\resources\\app.properties");
        Properties p=new Properties();
        p.load(fileReader);

        String JDBC_DRIVER = p.getProperty("JDBC_DRIVER");
        String DB_URL = p.getProperty("DB_URL");
        String USER = p.getProperty("USER");
        String PASS = p.getProperty("PASS");

        System.out.println(JDBC_DRIVER);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Model.Employee emp = new Model.Employee();
        System.out.println("Enter 'y' for continuing..");
        String ans=reader.readLine();
        do {
        int choice;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Press : \n 1:Insert \n 2:Delete \n 3:Update \n 4:Display ");
            String option = reader.readLine();

            choice = Integer.parseInt(option);


            switch (choice) {
                case 1: {
                    System.out.println("Enter name, city, age, deptName");
                    String empInfo = reader.readLine();
                    String[] splited = empInfo.split("\\s+");
                    emp.setName(splited[0]);
                    emp.setCity(splited[1]);
                    emp.setAge(Integer.parseInt(splited[2]));
                    emp.setDeptName(splited[3]);

                    System.out.println(CRUDOperations.insert(emp, conn));
                }
                break;
                case 2: {
                    System.out.println("Enter id to be deleted");
                    String id = reader.readLine();

                    System.out.println(CRUDOperations.delete(Integer.parseInt(id), conn));
                }
                break;
                case 3: {
                    System.out.println("Enter id whose record is to be updated");
                    String id1 = reader.readLine();
                    int id = Integer.parseInt(id1);
                    System.out.println("Enter new details.(name, city, age, deptName)");
                    String empInfo = reader.readLine();

                    String[] splited = empInfo.split("\\s+");
                    emp.setName(splited[0]);
                    emp.setCity(splited[1]);
                    emp.setAge(Integer.parseInt(splited[2]));
                    emp.setDeptName(splited[3]);

                    System.out.println(CRUDOperations.update(id, emp, conn));
                }
                break;
                case 4: {
                    List<Employee> list = CRUDOperations.display(conn);
                    System.out.println(list);
                }
                break;
                default:
                    System.out.println("Wrong option selected");
            }

        } catch (Exception se) {
            se.printStackTrace();
        }
        conn.close();
    }while(ans.equals("y"));
    }
}