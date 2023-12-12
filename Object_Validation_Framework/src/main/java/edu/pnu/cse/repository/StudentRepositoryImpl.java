package edu.pnu.cse.repository;

import java.util.HashMap;

public class StudentRepositoryImpl implements StudentRepository{

    private final Map<String, Student> students = new HashMap<>();



    public Student save(@Valid Student student) {

        return students.put(student.getId(), student);

    }

}

