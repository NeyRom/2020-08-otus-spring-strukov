package ru.strukov.xmlconfig.service;

import ru.strukov.xmlconfig.domain.Student;

/**
 * @author Roman Strukov
 */

public interface StudentService {
    Student setName();
    String getFullName(Student student);
}
