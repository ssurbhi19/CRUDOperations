package Operations;

import Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperations
{
    public static int insert(Employee emp,Connection conn) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement("insert into employee(name,city,age,deptName) values(?,?,?,?)");
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getCity());
        preparedStatement.setInt(3,emp.getAge());
        preparedStatement.setString(4,emp.getDeptName());

        int i=preparedStatement.executeUpdate();
        if(i>0)
            return i;
        else
            return -1;
    }

    public static int delete(int id,Connection conn) throws SQLException
    {
        PreparedStatement stmt=conn.prepareStatement("delete from employee where id=?");
        stmt.setInt(1,id);

        int i=stmt.executeUpdate();
        if(i>0)
        return i;
            else return -1;
    }

    public static int update(int id, Employee emp, Connection conn) throws SQLException
    {

        PreparedStatement preparedStatement=conn.prepareStatement("update employee set name=?,city=?,age=?,deptName=? where id=?");
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getCity());
        preparedStatement.setInt(3,emp.getAge());
        preparedStatement.setString(4,emp.getDeptName());
        preparedStatement.setInt(5,id);
        int i=preparedStatement.executeUpdate();
        if(i>0)
            return i;
        else
            return -1;
    }

    public static List<Employee> display(Connection conn) throws SQLException
    {

        PreparedStatement stmt=conn.prepareStatement("select * from employee");
        ResultSet rs=stmt.executeQuery();
        String result;
        List<Employee> list=new ArrayList<>();
        while(rs.next())
        {
            Employee emp = new Employee();
            emp.setId(rs.getInt(1));
            emp.setName(rs.getString(2));
            emp.setCity(rs.getString(3));
            emp.setAge(rs.getInt(4));
            emp.setDeptName(rs.getString(5));
            list.add(emp);
        }

       return list;
    }


}
