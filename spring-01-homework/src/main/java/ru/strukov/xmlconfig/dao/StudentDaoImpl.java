package ru.strukov.xmlconfig.dao;

import ru.strukov.xmlconfig.domain.Student;

/**
 * @author Roman Strukov
 */

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student createStudent(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }
}
