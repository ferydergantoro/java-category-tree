package dev.fry.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("all")
public class DBUtils {

    public static boolean isTableExisting(String tableName) throws SQLException {

        DBConnection dbConnection = DBConnection.getInstance();

        PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(
                "SELECT * FROM information_schema.tables WHERE table_name = ? LIMIT 1"
        );

        preparedStatement.setString(1, tableName.toUpperCase());

        ResultSet resultSet = preparedStatement.executeQuery();

        String tableNameDB = resultSet.next() ? resultSet.getString("table_name") : null;

        dbConnection.closeConnection();

        return tableNameDB != null && tableName.equalsIgnoreCase(tableNameDB);
    }
}
