package com.example.school;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
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
        String status = null;

        model.addAttribute("message", "It's a test message");
        model.addAttribute("students", students);
        model.addAttribute("tutor", teacher);
        model.addAttribute("status", status);
        return "list";
    }
    @GetMapping("/add")
    public String addNewStudent(Student student)
    {
        return "add-student";
    }

    @PostMapping("/students")
    public String createStudent(
            @Valid @ModelAttribute Student student,
            BindingResult result, // нужна чтобы проверить соответствует ли Student правилам валидации
            Model model
    )
    {
        if(result.hasErrors())
            return "add-student";

        students.add(student);
        return "redirect:/students";
    }

    @PostMapping("/teachers")
    public String updateTeacher(
            @Valid @ModelAttribute Teacher teacher,
            BindingResult result, // нужна чтобы проверить соответствует ли Student правилам валидации
            Model model
    )
    {
        // что если в result есть ошибки то нужно возвратить обратно
        if(result.hasErrors())
            return "change-teacher";
        // если ошибок нет, поменять текущего teacher
        this.teacher = teacher;
        // и сделать redirect в /students
        return "redirect:/students";
    }

}
