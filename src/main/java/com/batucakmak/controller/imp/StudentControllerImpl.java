package com.batucakmak.controller.imp;

import com.batucakmak.controller.IStudentController;
import com.batucakmak.dto.DtoStudent;
import com.batucakmak.dto.DtoStudentIU;
import com.batucakmak.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;



    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudent dtoStudentIU){
        return studentService.saveStudent(dtoStudentIU);
    }

    @Override
    @GetMapping(path = "/list")
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
        }

    @Override
    @GetMapping(path = "/list/{id}")
    public DtoStudent getStudentById(@PathVariable(name = "id")Integer id) {
        return studentService.getStudentById(id);

    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudent(id);

    }

    @Override
    @PutMapping(path = "/update/{id}")
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id,dtoStudentIU);
    }


}





