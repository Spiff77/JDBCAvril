package monprojet.utils;

import java.sql.*;

public class ConnectionManager {

    private static ConnectionManager instance;
    private Connection connection;

    private ConnectionManager(){
        try {
            System.out.println("Connexion DB");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:9001/scott", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void close(){
        try{
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.connection = null;
            ConnectionManager.instance = null;
        }
    }

    public  void closeStatement(Statement statement){
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public  void closeResultSet(ResultSet resultSet){
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
