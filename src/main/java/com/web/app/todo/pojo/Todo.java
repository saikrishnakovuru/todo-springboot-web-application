package com.web.app.todo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1, message = "Should not be left empty")
    private String description;
    @NotNull(message = "Date must be entred")
    private LocalDate targetDate;
    private boolean done;
}
