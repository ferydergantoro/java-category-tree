package dev.fry.service;

import dev.fry.model.Category;
import dev.fry.model.CategoryLevel;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class CategoryLevelService {

    public static List<CategoryLevel> buildCategoryLevel(List<Category> categories) {
        return buildCategoryLevel(
                categories,
                CollectionUtils.isNotEmpty(categories) ? (
                        categories.stream().map(Category::getParentId).distinct().sorted().toList().get(0)
                ) : 0
        );
    }

    private static List<CategoryLevel> buildCategoryLevel(List<Category> categories, long parentId) {

        List<CategoryLevel> categoryLevels = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(categories)) categories.stream()
                .filter(c -> parentId == c.getParentId())
                .sorted(Comparator.comparing(Category::getSequence))
                .map(CategoryLevel::new)
                .collect(Collectors.toList());

        for (CategoryLevel cl : categoryLevels) cl.setChildren(buildCategoryLevel(categories, cl.getId()));

        return categoryLevels;
    }
}
