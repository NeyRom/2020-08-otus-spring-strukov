package ru.strukov.xmlconfig.service;

import ru.strukov.xmlconfig.dao.StudentDao;
import ru.strukov.xmlconfig.domain.Student;

/**
 * @author Roman Strukov
 */

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
    private final ConsoleService consoleService;

    public StudentServiceImpl(StudentDao studentDao,
                              ConsoleService consoleService) {
        this.studentDao = studentDao;
        this.consoleService = consoleService;
    }

    @Override
    public Student setName() {
        String firstName = consoleService.getStringWithMessage("Please insert first name:");
        String lastName = consoleService.getStringWithMessage("Please insert last name:");
        return studentDao.createStudent(firstName, lastName);
    }

    @Override
    public String getFullName(Student student) {
        return student.getFirstName() + " " + student.getLastName();
    }
}
