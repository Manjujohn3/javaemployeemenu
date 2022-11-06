import java.sql.*;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {


        int choice;

        while (true) {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.view");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("insert employee selected");

                    System.out.println("enter the empcode:");
                    int empcode = scanner.nextInt();
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    System.out.println("enter the designtion:");
                    String designation = scanner.next();
                    System.out.println("enter the salary:");
                    int salary = scanner.nextInt();
                    System.out.println("enter the companyname:");
                    String companyname = scanner.next();
                    System.out.println("enter the phone:");
                    String phone = scanner.next();
                    System.out.println("enter the email");
                    String email = scanner.next();
                    System.out.println("enter the password");
                    String password = scanner.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                        String sql = "INSERT INTO `employees`(`empcode`, `empname`, `designation`, `salary`, `companyname`, `phone`, `emailid`, `password`) VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1, empcode);
                        stmt.setString(2, name);
                        stmt.setString(3, designation);
                        stmt.setInt(4, salary);
                        stmt.setString(5, companyname);
                        stmt.setString(6, phone);
                        stmt.setString(7, email);
                        stmt.setString(8, password);

                        stmt.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    System.out.println("view employee selected");

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                        String sql = "SELECT `empcode`, `empname`, `designation`, `salary`, `companyname`, `phone`, `emailid`, `password` FROM `employees`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getEmpcode = rs.getString("empcode");
                            String getName = rs.getString("empname");
                            String getDesignation = rs.getString("designation");
                            String getSalary = rs.getString("salary");
                            String getCompanyname = rs.getString("companyname");
                            String getPhone = rs.getString("phone");
                            String getEmail= rs.getString("emailid");
                            String getPassword = rs.getString("password");
                            System.out.println("empcode="+getEmpcode);
                            System.out.println("empname="+getName);
                            System.out.println("designation="+getDesignation);
                            System.out.println("salary="+getSalary);
                            System.out.println("companyname="+getCompanyname);
                            System.out.println("phone="+getPhone);
                            System.out.println("emailid="+getEmail);
                            System.out.println("password="+getPassword+"\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("search search selected");
                    System.out.println("Enter the empcode : ");
                    empcode = scanner.nextInt();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                        String sql = "SELECT `empcode`, `empname`, `designation`, `salary`, `companyname`, `phone`, `emailid`, `password` FROM `employees` WHERE`empcode`="+String.valueOf(empcode);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getEmpcode = rs.getString("empcode");
                            String getName = rs.getString("empname");
                            String getDesignation = rs.getString("designation");
                            String getSalary = rs.getString("salary");
                            String getCompanyname = rs.getString("companyname");
                            String getPhone = rs.getString("phone");
                            String getEmail= rs.getString("emailid");
                            String getPassword = rs.getString("password");
                            System.out.println("empcode="+getEmpcode);
                            System.out.println("empname="+getName);
                            System.out.println("designation="+getDesignation);
                            System.out.println("salary="+getSalary);
                            System.out.println("companyname="+getCompanyname);
                            System.out.println("phone="+getPhone);
                            System.out.println("emailid="+getEmail);
                            System.out.println("password="+getPassword+"\n");
                        }
                    }
                    catch (Exception e ){
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.println("delete employee selected");
                    System.out.println("Enter the empcode : ");
                    String empco = scanner.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                        String sql = "DELETE FROM `employees` WHERE `empcode`= " +empco;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("data deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;

                case 5:
                    System.out.println("update employee selected");
                    System.out.println("Enter the empcode to be updating");
                    empcode = scanner.nextInt();
                    System.out.println("enter the name to be updated:");
                    name = scanner.next();
                    System.out.println("enter the designtion to be updated:");
                    designation = scanner.next();
                    System.out.println("enter the salary to be updated:");
                    salary = scanner.nextInt();
                    System.out.println("enter the companyname to be updated:");
                    companyname = scanner.next();
                    System.out.println("enter the phone to be updated:");
                    phone = scanner.next();
                    System.out.println("enter the email to be updated:");
                    email = scanner.next();
                    System.out.println("enter the password to be updated:");
                    password = scanner.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                        String sql = "UPDATE `employees` SET `empcode`='"+String.valueOf(empcode)+"',`empname`='"+name+"',`designation`='"+designation+"',`salary`='"+String.valueOf(salary)+"',`companyname`='"+companyname+"',`phone`='"+phone+"',`emailid`='"+email+"',`password`='"+password+"' WHERE `empcode`="+String.valueOf(empcode);
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;
            }
        }
    }
}



