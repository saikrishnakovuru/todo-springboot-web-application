package com.web.app.todo;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Todo {
    @Id
    private int id;
    private String userName;
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
