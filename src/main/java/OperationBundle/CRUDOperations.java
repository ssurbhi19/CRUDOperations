package OperationBundle;

import Model.Employee;

import java.sql.*;
public class CRUDOperations
{
    public static void insert(Employee emp,Connection conn) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement("insert into employee(name,city,age,deptName) values(?,?,?,?)");
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getCity());
        preparedStatement.setInt(3,emp.getAge());
        preparedStatement.setString(4,emp.getDeptName());

        int i=preparedStatement.executeUpdate();
        System.out.println(i+" record inserted..");
    }

    public static void delete(int id,Connection conn) throws SQLException
    {
        PreparedStatement stmt=conn.prepareStatement("delete from employee where id=?");
        stmt.setInt(1,id);

        int i=stmt.executeUpdate();
        System.out.println(i+" record deleted..");
    }

    public static void update(int id, Employee emp, Connection conn) throws SQLException
    {

        PreparedStatement preparedStatement=conn.prepareStatement("update employee set name=?,city=?,age=?,deptName=? where id=?");
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getCity());
        preparedStatement.setInt(3,emp.getAge());
        preparedStatement.setString(4,emp.getDeptName());
        preparedStatement.setInt(5,id);
        int i=preparedStatement.executeUpdate();
        System.out.println(i+" record updated..");
    }

    public static void display(Connection conn) throws SQLException
    {
        PreparedStatement stmt=conn.prepareStatement("select * from employee");
        ResultSet rs=stmt.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
        }
    }


}
