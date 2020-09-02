package ru.strukov.xmlconfig.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.strukov.xmlconfig.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Roman Strukov
 */

@DisplayName("Класс StudentDaoImpl")
class StudentDaoImplTest {
    private StudentDao studentDao;

    @BeforeEach
    void setUp() {
        studentDao = new StudentDaoImpl();
    }

    @DisplayName("Корректно создает объект класса Student")
    @Test
    void createStudent() {
        Student student = studentDao.createStudent("Roman", "Strukov");
        assertEquals("Roman", student.getFirstName());
        assertEquals("Strukov", student.getLastName());
    }
}