package com.batucakmak.controller;

import com.batucakmak.dto.DtoStudent;
import com.batucakmak.dto.DtoStudentIU;
import com.batucakmak.entities.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudent dtoStudentIU);


    public List<DtoStudent>getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);

}
