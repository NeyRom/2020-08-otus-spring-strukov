package ru.strukov.xmlconfig.service;

import org.springframework.core.io.Resource;

/**
 * @author Roman Strukov
 */

public interface TestQuestionService {
    void conductTesting(Resource resource);
    void setStudent();
    String getResource();
}
