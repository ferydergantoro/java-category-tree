package dev.fry.service;

import dev.fry.ICategoryTreeTest;
import dev.fry.model.Category;
import dev.fry.model.CategoryLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@SuppressWarnings("all")
class CategoryLevelServiceTest implements ICategoryTreeTest {

    /*
     *   1st level (root level) :
     *      1. Computers & Tablets
     *      2. Networking
     */
    private void buildCategoryLevel1st(List<CategoryLevel> categoryLevels) {
        Assertions.assertEquals(categoryLevels.size(), 2);
        Assertions.assertEquals(categoryLevels.get(0).getName(), "Computers & Tablets");
        Assertions.assertEquals(categoryLevels.get(1).getName(), "Networking");
    }

    /*
     *   2nd level :
     *      1. Computers & Tablets :
     *          1.1. All-in-One PCs
     *          1.2. Desktop PCs
     *          1.3. Laptops
     *          1.4. Servers
     *          1.5. Tablets
     *      2. Networking :
     *          2.1. Firewalls
     *          2.2. Modems
     */
    private void buildCategoryLevel2nd(List<CategoryLevel> categoryLevels) {

        List<CategoryLevel> computerChildrenCategoryLevels = categoryLevels.get(0).getChildren();
        Assertions.assertEquals(computerChildrenCategoryLevels.size(), 5);
        Assertions.assertEquals(computerChildrenCategoryLevels.get(0).getName(), "All-in-One PCs");
        Assertions.assertEquals(computerChildrenCategoryLevels.get(1).getName(), "Desktop PCs");
        Assertions.assertEquals(computerChildrenCategoryLevels.get(2).getName(), "Laptops");
        Assertions.assertEquals(computerChildrenCategoryLevels.get(3).getName(), "Servers");
        Assertions.assertEquals(computerChildrenCategoryLevels.get(4).getName(), "Tablets");

        List<CategoryLevel> networkChildrenCategoryLevels = categoryLevels.get(1).getChildren();
        Assertions.assertEquals(networkChildrenCategoryLevels.size(), 2);
        Assertions.assertEquals(networkChildrenCategoryLevels.get(0).getName(), "Firewalls");
        Assertions.assertEquals(networkChildrenCategoryLevels.get(1).getName(), "Modems");
    }

    /*
     *   3rd level :
     *      1.2. Desktop PCs
     *          1.2.1. Gamming PCs
     *          1.2.2. Business PCs
     *          1.2.3. Workstations
     */
    private void buildCategoryLevel3rd(List<CategoryLevel> categoryLevels) {

        List<CategoryLevel> computerChildrenCategoryLevels = categoryLevels.get(0).getChildren();
        Assertions.assertEquals(computerChildrenCategoryLevels.size(), 5);
        Assertions.assertTrue(computerChildrenCategoryLevels.get(0).getChildren().isEmpty());
        Assertions.assertFalse(computerChildrenCategoryLevels.get(1).getChildren().isEmpty());
        Assertions.assertTrue(computerChildrenCategoryLevels.get(2).getChildren().isEmpty());
        Assertions.assertTrue(computerChildrenCategoryLevels.get(3).getChildren().isEmpty());
        Assertions.assertTrue(computerChildrenCategoryLevels.get(4).getChildren().isEmpty());

        List<CategoryLevel> desktopPCChildrenCategoryLevels = computerChildrenCategoryLevels.get(1).getChildren();
        Assertions.assertEquals(desktopPCChildrenCategoryLevels.size(), 3);
        Assertions.assertEquals(desktopPCChildrenCategoryLevels.get(0).getName(), "Gamming PCs");
        Assertions.assertEquals(desktopPCChildrenCategoryLevels.get(1).getName(), "Business PCs");
        Assertions.assertEquals(desktopPCChildrenCategoryLevels.get(2).getName(), "Workstations");

        List<CategoryLevel> networkChildrenCategoryLevels = categoryLevels.get(1).getChildren();
        Assertions.assertEquals(networkChildrenCategoryLevels.size(), 2);
        Assertions.assertTrue(networkChildrenCategoryLevels.get(0).getChildren().isEmpty());
        Assertions.assertTrue(networkChildrenCategoryLevels.get(1).getChildren().isEmpty());
    }

    private List<CategoryLevel> buildCategoryLevel(List<Category> categories) {
        return CategoryLevelService.buildCategoryLevel(categories);
    }

    private void buildCategoryLevelTestNullOrEmpty(List<CategoryLevel> categoryLevels) {
        Assertions.assertEquals(categoryLevels.size(), 0);
    }

    @Test
    void buildCategoryLevelTest1st() {
        buildCategoryLevel1st(buildCategoryLevel(CATEGORIES_MOCK));
        buildCategoryLevel1st(buildCategoryLevel(UNSORTED_CATEGORIES_MOCK));
    }

    @Test
    void buildCategoryLevelTest2nd() {
        buildCategoryLevel2nd(buildCategoryLevel(CATEGORIES_MOCK));
        buildCategoryLevel2nd(buildCategoryLevel(UNSORTED_CATEGORIES_MOCK));
    }

    @Test
    void buildCategoryLevelTest3rd() {
        buildCategoryLevel3rd(buildCategoryLevel(CATEGORIES_MOCK));
        buildCategoryLevel3rd(buildCategoryLevel(UNSORTED_CATEGORIES_MOCK));
    }

    @Test
    void buildCategoryLevelTestNullOrEmpty() {
        buildCategoryLevelTestNullOrEmpty(buildCategoryLevel(List.of()));
    }

    @Test
    void buildCategoryLevelTestNull() {
        buildCategoryLevelTestNullOrEmpty(buildCategoryLevel(null));
    }

}