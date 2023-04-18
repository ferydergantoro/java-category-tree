package dev.fry.db;

import dev.fry.repository.DBRepositoryInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("all")
class DBConnectionTest {

    /*
     *   Database connection instance :
     *      URL         = "jdbc:hsqldb:hsql://localhost/"   (DEFAULT HOST : LOCALHOST , DEFAULT PORT : 9001)
     *      DB Alias    = ""                                (PUBLIC SCHEMA)
     *      USER        = "SA"                              (DEFULT USER : SA)
     *      PWD         = ""                                (DEFULT PASSWORD : EMPTY)
     */
    @Test
    void databaseConnectionTest() {

        DBConnection dbConnection = DBConnection.getInstance();

        try {
            ResultSet rs = dbConnection.getResultSetByQuery("SELECT * FROM information_schema.tables LIMIT 1");

            Assertions.assertTrue(rs.next());
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally {
            try { dbConnection.closeConnection(); }
            catch (SQLException e) { System.err.println(e.getMessage()); }
        }
    }

    /*
     *   Check Table is existing : CATEGORY_TABLE = "category_fery"
     */
    @Test
    void tableExistingTest() {

        try { Assertions.assertTrue(DBUtils.isTableExisting(DBRepositoryInterface.CATEGORY_TABLE)); }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally {
            try { DBConnection.getInstance().closeConnection(); }
            catch (SQLException e) { System.err.println(e.getMessage()); }
        }
    }
}