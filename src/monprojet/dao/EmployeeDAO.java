package monprojet.dao;

import monprojet.model.Employee;
import monprojet.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements DAO<Integer, Employee> {


    @Override
    public ArrayList<Employee> findAll() {
        ArrayList<Employee> emps = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        Connection c = null;
        try {


            c = ConnectionManager.getInstance().getConnection();
            st = c.createStatement();
            rs = st.executeQuery("select * from emp");

            while (rs.next()) {
                emps.add(new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        new Date(rs.getDate(5).getTime()),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(st);
            ConnectionManager.getInstance().closeResultSet(rs);
        }
        return emps;
    }

    @Override
    public Employee findById(Integer id) {
        Employee emp = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection c = null;
        try {
            c = ConnectionManager.getInstance().getConnection();

            st = c.prepareStatement("select * from emp where empno = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            rs.next();

            emp = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    new Date(rs.getDate(5).getTime()),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8)
            );

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(st);
            ConnectionManager.getInstance().closeResultSet(rs);
        }
        return emp;
    }

    @Override
    public void insert(Employee emp) {
        PreparedStatement ps = null;
        Connection c = null;
        try {

            c = ConnectionManager.getInstance().getConnection();

            ps = c.prepareStatement("INSERT INTO EMP VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEname());
            ps.setString(3, emp.getJob());
            ps.setInt(4, emp.getMgr());
            ps.setDate(5, new java.sql.Date(emp.getHireDate().getTime()));
            ps.setInt(6, emp.getSal());
            ps.setInt(7, emp.getCom());
            ps.setInt(8, emp.getDeptno());

            ps.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }
    }

    @Override
    public void update(Employee emp) {
        PreparedStatement ps = null;
        Connection c = null;
        try {

            c = ConnectionManager.getInstance().getConnection();
            ps = c.prepareStatement("UPDATE EMP SET " +
                    "ename = ?," +
                    "job = ?," +
                    "mgr = ?," +
                    "hiredate = ?," +
                    "sal = ?," +
                    "comm = ?," +
                    "deptno = ?" +
                    " where empno = ?");

            ps.setString(1, emp.getEname());
            ps.setString(2, emp.getJob());
            ps.setInt(3, emp.getMgr());
            ps.setDate(4, new java.sql.Date(emp.getHireDate().getTime()));
            ps.setInt(5, emp.getSal());
            ps.setInt(6, emp.getCom());
            ps.setInt(7, emp.getDeptno());
            ps.setInt(8, emp.getEmpno());

            ps.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        Connection c = null;

        try {
            c = ConnectionManager.getInstance().getConnection();
            ps = c.prepareStatement("DELETE FROM emp  where empno = ?");
            ps.setInt(1, id);

            ps.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }
    }

    @Override
    public void delete(Employee emp) {
        PreparedStatement ps = null;
        Connection c = null;
        try {
            c = ConnectionManager.getInstance().getConnection();
            ps = c.prepareStatement("DELETE FROM emp  where empno = ?");
            ps.setInt(1, emp.getEmpno());

            ps.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeStatement(ps);
        }
    }
}
