package edu.icet.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoItem {
    private int userID;
    private String todoTitle;
    private String todoDescription;
    private String todoType;
    private String todoDate;
}
