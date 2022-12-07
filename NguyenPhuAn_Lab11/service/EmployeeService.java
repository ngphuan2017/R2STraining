package service;

import config.JdbcConnection;
import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private Connection connection = JdbcConnection.getConnection();

    public EmployeeService() throws SQLException {
    }

    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT MaNV, Ten, Luong FROM nhanvien";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Employee emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public void setEmployee(String empCode, String name, int salary) throws SQLException {
        this.connection.setAutoCommit(false);
        String query = "INSERT INTO nhanvien (MaNV, Ten, Luong) VALUES (?,?,?)";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            pStatement.setString(1, empCode);
            pStatement.setString(2, name);
            pStatement.setInt(3, salary);
            pStatement.executeUpdate();
            this.connection.commit();
            this.connection.setAutoCommit(true);
        } catch (Exception var10) {
            System.err.println(var10.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

    }

    public List<Employee> getEmployee() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT MaNV, Ten, Luong FROM nhanvien WHERE Luong < 10000";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Employee emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public int getSumSalary() throws SQLException {
        int sum = 0;
        new ArrayList();
        String query = "SELECT MaNV, Ten, Luong FROM nhanvien";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);

            for(ResultSet resultSet = pStatement.executeQuery(); resultSet.next(); sum += resultSet.getInt(3)) {
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return sum;
    }

    public List<Employee> getEmployee747() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT n.MaNV, n.Ten, n.Luong FROM nhanvien n JOIN chungnhan c ON n.MaNV=c.MaNV WHERE c.MaMB=747";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Employee emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Employee> getEmployeeBoeing() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT n.MaNV, n.Ten, n.Luong FROM nhanvien n JOIN chungnhan c ON n.MaNV=c.MaNV JOIN maybay m ON c.MaMB=m.MaMB WHERE m.Loai LIKE 'Boeing%'";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Employee emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }
}
