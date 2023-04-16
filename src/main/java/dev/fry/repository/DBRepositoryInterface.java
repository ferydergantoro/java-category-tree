package dev.fry.repository;

import dev.fry.model.Category;

import java.util.List;

@SuppressWarnings("all")
public interface DBRepositoryInterface {
    static String CATEGORY_TABLE = "category_fery";

    void initTable();

    void initData();

    long countData();

    List<Category> fetchCategories();
}
