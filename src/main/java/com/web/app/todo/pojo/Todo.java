package com.web.app.todo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
    @Id
    private int id;
    private String userName;
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
