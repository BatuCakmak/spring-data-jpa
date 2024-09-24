package com.batucakmak.repository;

import com.batucakmak.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    // HQL : sınıfın ismi ve değişken isimleri kullanılarak sorgu yazılır
    // SQL : tablo ismi ve tablo içerisindeki kolon isimleri ile sorgu yazılır
    // nativeQuery= false ise HQL nativeQuery= true ise SQL
    @Query(value = "from Student",nativeQuery =false )
    List<Student> findAllStudents();

    @Query(value = "from Student  s WHERE s.id = :studentId")
    Optional findStudentById(Integer studentId);
}
