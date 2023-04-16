package dev.fry;

import dev.fry.repository.DBRepository;
import dev.fry.service.LabelCategoryService;

import java.sql.SQLException;

@SuppressWarnings("all")
public class CategoryTreeApp {

    public static void main(String[] args) {

        DBRepository dbRepository = new DBRepository();

        try {
            dbRepository.initTableData();

            System.out.println(LabelCategoryService.getLabelCategoryTree(dbRepository.fetchCategories()));
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { dbRepository.closeConnection(); }
    }
}
