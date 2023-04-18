package dev.fry;

import dev.fry.model.Category;

import java.util.List;

@SuppressWarnings("all")
public interface ICategoryTreeTest {

    static List<Category> CATEGORIES_MOCK = List.of(
        new Category(1, "Computers & Tablets",  0, 0),
        new Category(2, "All-in-One PCs",  1, 0),
        new Category(3, "Desktop PCs", 1, 1),
        new Category(4, "Laptops", 1, 2),
        new Category(5, "Servers", 1, 3),
        new Category(7, "Tablets", 1, 5),
        new Category(8, "Gamming PCs", 3, 0),
        new Category(9, "Business PCs", 3, 1),
        new Category(10, "Workstations", 3, 2),
        new Category(11, "Networking", 0, 1),
        new Category(12, "Firewalls", 11, 0),
        new Category(13, "Modems", 11, 1)
    );

    static List<Category> UNSORTED_CATEGORIES_MOCK = List.of(
            new Category(2, "All-in-One PCs",  1, 0),
            new Category(4, "Laptops", 1, 2),
            new Category(7, "Tablets", 1, 5),
            new Category(9, "Business PCs", 3, 1),
            new Category(11, "Networking", 0, 1),
            new Category(13, "Modems", 11, 1),
            new Category(1, "Computers & Tablets",  0, 0),
            new Category(3, "Desktop PCs", 1, 1),
            new Category(5, "Servers", 1, 3),
            new Category(8, "Gamming PCs", 3, 0),
            new Category(10, "Workstations", 3, 2),
            new Category(12, "Firewalls", 11, 0)
    );

    static String EXPECTED_RESULT = (
        "+ Computers & Tablets\n" +
        "  + All-in-One PCs\n" +
        "  + Desktop PCs\n" +
        "    + Gamming PCs\n" +
        "    + Business PCs\n" +
        "    + Workstations\n" +
        "  + Laptops\n" +
        "  + Servers\n" +
        "  + Tablets\n" +
        "+ Networking\n" +
        "  + Firewalls\n" +
        "  + Modems"
    );
}
