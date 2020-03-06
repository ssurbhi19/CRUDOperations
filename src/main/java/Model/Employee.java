package Model;

public class Employee
{
    private int id;
    private String name;
    private String city;
    private int age;
    private String deptName;

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public int getAge()
    {
        return this.age;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCity()
    {
        return this.city;
    }
    public String getDeptName()
    {
        return this.deptName;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

