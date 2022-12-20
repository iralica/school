package com.example.school;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class SchoolController {


    /*
https://frontbackend.com/tag/Utility
https://www.thymeleaf.org/apidocs/thymeleaf/3.0.0.RELEASE/index.html?org/thymeleaf/expression/Strings.html
https://www.thymeleaf.org/apidocs/thymeleaf/3.0.0.RELEASE/index.html?org/thymeleaf/expression/Maps.html

https://www.baeldung.com/thymeleaf-in-spring-mvc
https://www.baeldung.com/spring-thymeleaf-3-expressions
https://www.baeldung.com/thymeleaf-arrays
https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html#standard-expression-syntax
     */

    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1L, "Max", "Petrov" ,19),
                    new Student(2L, "Dina", "Borisova" ,29),
                    new Student(3L, "Leonid", "Kasatonov" ,23),
                    new Student(4L, "Sergey", "Borodov" ,22),
                    new Student(5L, "Masha", "Poruvaeva" ,39)
            )
    );

    private Teacher teacher = new Teacher(1L, "Maria Ivanovna", true);

    @GetMapping("/students")
    public String getStudents(Model model)
    {
        model.addAttribute("message", "It's a test message");
        model.addAttribute("students", students);
        model.addAttribute("tutor", teacher);
        return "list";
    }
}
