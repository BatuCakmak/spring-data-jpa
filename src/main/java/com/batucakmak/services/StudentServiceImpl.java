package com.batucakmak.services;

import com.batucakmak.dto.DtoStudent;
import com.batucakmak.dto.DtoStudentIU;
import com.batucakmak.entities.Student;
import com.batucakmak.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudent dtoStudent) {
        DtoStudent response=new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudent,student);
        Student dbStudent =studentRepository.save(student);
        BeanUtils.copyProperties(dtoStudent,response);
        return response;

    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();
        for (Student student:studentList){
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if (optional.isPresent()) {
            Student dbStudent=optional.get();

            BeanUtils.copyProperties(dbStudent,dto);
        }
        return dto;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional=studentRepository.findById(id);

       if(optional.isPresent()){
        studentRepository.delete(optional.get());
       }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {

        DtoStudent dto = new DtoStudent();

        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent()){
            Student dbStudent = optional.get();

            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);

            BeanUtils.copyProperties(updatedStudent,dto);
            return dto;

        }
        return  null;


    }
}



