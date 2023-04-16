package dev.fry.service;

import dev.fry.ICategoryTreeTest;
import dev.fry.repository.DBRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class LabelCategoryServiceTest implements ICategoryTreeTest {

    /*
     *   print category tree with data mock (dummy)
     */
    @Test
    void printCategoryTreeDataMockTest() {
        Assertions.assertEquals(LabelCategoryService.getLabelCategoryTree(CATEGORIES_MOCK), EXPECTED_RESULT);
    }

    /*
     *   print category tree with data table (database)
     */
    @Test
    void printCategoryTreeFromDatabaseTest() {

        DBRepository dbRepository = new DBRepository();

        try {
            dbRepository.initTableData();

            Assertions.assertEquals(
                    LabelCategoryService.getLabelCategoryTree(dbRepository.fetchCategories()), EXPECTED_RESULT
            );
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { dbRepository.closeConnection(); }
    }
}