package dev.fry.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper=false)
public class CategoryLevel extends Category {

    private List<CategoryLevel> children;

    public CategoryLevel(Category category) {
        super(category.getId(), category.getName(), category.getParentId(), category.getSequence());

        children = new ArrayList<>();
    }
}
