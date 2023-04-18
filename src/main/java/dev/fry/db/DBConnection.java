package dev.fry.db;

import java.sql.*;

@SuppressWarnings("all")
public class DBConnection {

    static final String URL = "jdbc:hsqldb:hsql://localhost/";
    static final String DB = URL + ";ifexists=true";
    static final String USER = "SA";
    static final String PWD = "";

    private static DBConnection dbConnection;

    private Connection conn;

    private DBConnection() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() {
        return (dbConnection == null) ? dbConnection = new DBConnection() : dbConnection;
    }

    public Connection getConnection() throws SQLException {
        return conn = DriverManager.getConnection(DB, USER, PWD);
    }

    private DatabaseMetaData getDBMetaData() throws SQLException {
        return getConnection().getMetaData();
    }

    public void closeConnection() throws SQLException {
        if (conn != null) conn.close();
    }

    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    /*private PreparedStatement getPrepareStatment(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }*/

    public ResultSet getResultSetByQuery(String query) throws SQLException {
        return getStatement().executeQuery(query);
    }

    public int executeUpdateQuery(String query) throws SQLException {
        return getStatement().executeUpdate(query);
    }

    /*public void insertQuery(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.execute();
    }*/

    /*public int updateQuery(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeUpdate();
    }*/
}
