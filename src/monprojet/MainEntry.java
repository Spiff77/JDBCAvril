package monprojet;

import monprojet.dao.EmployeeDAO;
import monprojet.model.Employee;
import monprojet.utils.ConnectionManager;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;



public class MainEntry {

    public static void main(String[] args) {

        EmployeeDAO eDao = new EmployeeDAO();
        eDao.findAll();
        Employee e = eDao.findById(2587);
        e.setSal(50000000);
        eDao.update(e);
        Employee e2 = eDao.findById(2587);
        ConnectionManager.getInstance().close();
        System.out.println(e2);

    }

    private static void updateDb() {
        try {

            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse("10/10/2010");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:9001/scott", "root", "root");

            PreparedStatement ps = c.prepareStatement("DELETE FROM emp  where empno = ?");
            ps.setInt(1, 8888);

            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void selectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:9001/scott", "root", "root");

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from emp");

            while(rs.next()){
                System.out.println(rs.getString("ename") + ": " + rs.getInt("sal") );
            }

            PreparedStatement st1 = c.prepareStatement("select * from emp where sal < ? AND (JOB = ? OR JOB= ?)");
            st1.setInt(1, 2000);
            st1.setString(2, "SALESMAN");
            st1.setString(3, "MANAGER");
            ResultSet rs1 = st1.executeQuery();

            while(rs1.next()){
               // System.out.println(rs1.getString("ename") + " - " + rs1.getString("job") + ": " + rs1.getInt("sal") );
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}



/**
 *
 * 1 jean jean
 * 2 tom tom
 * 3 bbb ccc<---
 *
 */
