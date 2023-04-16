package dev.fry.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings("all")
@Data
@AllArgsConstructor
public class Category {

    private long id;
    private String name;
    private long parentId;
    private long sequence;
}
