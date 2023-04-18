package dev.fry.service;

import dev.fry.model.Category;
import dev.fry.model.CategoryLevel;
import dev.fry.util.StringUtils;

import java.util.List;

import static dev.fry.constant.CharConstants.LF;
import static dev.fry.constant.CharConstants.SP;

@SuppressWarnings("all")
public class LabelCategoryService {

    public static String getLabelCategoryTree(List<Category> categories) {

        List<CategoryLevel> categoryLevels = CategoryLevelService.buildCategoryLevel(categories);

        StringBuilder label = new StringBuilder();

        for (CategoryLevel categoryLevel : categoryLevels) label.append(getLabelName(categoryLevel, 0));

        return StringUtils.removeNewLineAtEndOfString(label.toString());
    }

    private static String getLabelName(CategoryLevel categoryLevel, int level) {

        StringBuilder label = new StringBuilder("+" + SP + categoryLevel.getName() + LF);

        for (CategoryLevel clChild : categoryLevel.getChildren())
            label.append( String.valueOf(SP).repeat(2) /* String.valueOf(TAB) */ .repeat(Math.max(1, level+1)) )
                    .append(getLabelName(clChild, level+1));

        return label.toString();
    }
}
