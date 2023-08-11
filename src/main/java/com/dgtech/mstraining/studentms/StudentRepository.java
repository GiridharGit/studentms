package com.dgtech.mstraining.studentms;

import com.dgtech.mstraining.studentms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByFullname(String fullname);
}