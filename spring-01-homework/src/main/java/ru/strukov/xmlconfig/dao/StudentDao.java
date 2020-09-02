package ru.strukov.xmlconfig.dao;

import ru.strukov.xmlconfig.domain.Student;

/**
 * @author Roman Strukov
 */

public interface StudentDao {
    Student createStudent(String firstName, String lastName);
}
