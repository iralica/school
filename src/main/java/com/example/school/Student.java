package com.example.school;

import jakarta.validation.constraints.*;

public class Student {
    /*
    @NotNull
    @NotEmpty - коллекция или строка не могут быть пустыми
    @NotBlank - не пустая строка
    @Min @Max - ограничения для числовых типов
    @Pattern - регулярное выражение для строк
    @Email - шаблон для email адреса
     */

    // идентификатор был не null и больше 0
    @NotNull(message = "Id should be used")
    @Min(value = 1, message = "Should be greater than 0")
    private Long id;
    // имя ыбло не пустое
    @NotBlank(message = "First name should be used")
    private String first;
    // фамилия была не пустая
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = ".*[Mm][Aa][Xx].*", message = "Name should contain max")
    private String last;
    // возраст был не null и больше 17
    @NotNull(message = "Age should be used")
    @Min(value = 18, message = "Should be greater than 18")
    @Max(value = 120, message = "Should be less than 120")
    private Integer age;


    public Student(Long id, String first, String last, Integer age) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
