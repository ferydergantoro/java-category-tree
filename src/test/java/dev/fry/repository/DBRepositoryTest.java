package dev.fry.repository;

import dev.fry.ICategoryTreeTest;
import dev.fry.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

class DBRepositoryTest implements ICategoryTreeTest {

    /*
     *  Load data categories from database
     */
    @Test
    void fetchCategoriesTest() {

        DBRepository dbRepository = new DBRepository();

        try {
            dbRepository.initTableData();

            Assertions.assertFalse(dbRepository.fetchCategories().isEmpty());
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { dbRepository.closeConnection(); }
    }

    /*
     *  Count data categories from database
     */
    @Test
    void countCategoriesTest() {

        DBRepository dbRepository = new DBRepository();

        try {
            dbRepository.initTableData();

            Assertions.assertEquals(dbRepository.fetchCategories().size(), dbRepository.countData());
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { dbRepository.closeConnection(); }
    }

    /*
     *  Check if data categories from database like mock data (dummy)
     */
    @Test
    void categoriesLikeDataMockTest() {

        DBRepository dbRepository = new DBRepository();

        try {
            dbRepository.initTableData();

            List<Category> categories = dbRepository.fetchCategories();
            categories.sort(Comparator.comparing(Category::getId));

            Assertions.assertEquals(categories, CATEGORIES_MOCK);
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        finally { dbRepository.closeConnection(); }
    }
}