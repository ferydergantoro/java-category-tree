package dev.fry.repository;

import dev.fry.db.DBConnection;
import dev.fry.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class DBRepository implements DBRepositoryInterface {

    DBConnection dbConnection;

    public DBRepository() {
        dbConnection = DBConnection.getInstance();
    }

    public void closeConnection() {
        try { dbConnection.closeConnection(); }
        catch (SQLException e) { System.err.println(e.getMessage()); }
    }

    public void initTableData() throws SQLException {

        initTable();

        initData();
    }

    @Override
    public void initTable() {

        try {

            if (!dbConnection.isTableExisting(CATEGORY_TABLE))

                dbConnection.executeUpdateQuery(
                    "CREATE TABLE " + CATEGORY_TABLE + " (\n" +
                    "  id BIGINT NOT NULL IDENTITY,\n" +
                    "  name VARCHAR(255) NOT NULL,\n" +
                    "  parent_id BIGINT NOT NULL,\n" +
                    "  sequence BIGINT NOT NULL,\n" +
                    "  PRIMARY KEY ( id ),\n" +
                    "  UNIQUE ( parent_id , sequence )\n" +
                    ")\n"
                );

        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { closeConnection(); }
    }

    @Override
    public void initData() {

        if (countData() == 0L) try {

            dbConnection.executeUpdateQuery(
                "INSERT INTO " + CATEGORY_TABLE + " (id, name, parent_id, sequence) VALUES \n" +
                " (1, 'Computers & Tablets', 0, 0), \n" +
                " (2, 'All-in-One PCs', 1, 0), \n" +
                " (3, 'Desktop PCs', 1, 1), \n" +
                " (4, 'Laptops', 1, 2), \n" +
                " (5, 'Servers', 1, 3), \n" +
                " (7, 'Tablets', 1, 5), \n" +
                " (8, 'Gamming PCs', 3, 0), \n" +
                " (9, 'Business PCs', 3, 1), \n" +
                " (10, 'Workstations', 3, 2), \n" +
                " (11, 'Networking', 0, 1), \n" +
                " (12, 'Firewalls', 11, 0), \n" +
                " (13, 'Modems', 11, 1)"
            );

        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { closeConnection(); }
    }

    @Override
    public long countData() {

        try {

            ResultSet rs = dbConnection.getResultSetByQuery("SELECT COUNT(id) AS count_id FROM " + CATEGORY_TABLE);

            return rs.next() ? rs.getLong("count_id") : 0L;

        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { closeConnection(); }
    }

    @Override
    public List<Category> fetchCategories() {

        try {

            ResultSet rs = dbConnection.getResultSetByQuery(
                    "SELECT * FROM " + CATEGORY_TABLE + " ORDER BY parent_id, sequence"
            );

            List<Category> categories = new ArrayList<>();

            while (rs.next()) categories.add(new Category(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getLong("parent_id"),
                rs.getLong("sequence")
            ));

            return categories;

        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { closeConnection(); }
    }
}
