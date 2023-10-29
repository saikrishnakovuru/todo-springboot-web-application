package com.web.app.todo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    @Size(min = 1, message = "Description should not be left empty")
    private String description;
    @NotNull(message = "Date must be entred")
    private LocalDate targetDate;
    private boolean done;
}
