package com.web.app.todo.pojo;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Todo {
    private int id;
    private String userName;
    @Size(min = 1, message = "Description should not be left empty")
    private String description;
    @NotNull(message = "Date must be entred")
    private LocalDate targetDate;
    private boolean done;
}
