package com.batucakmak.services;

import com.batucakmak.dto.DtoStudent;
import com.batucakmak.dto.DtoStudentIU;
import com.batucakmak.entities.Student;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudent dtoStudentIU);
    public List<DtoStudent>getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
