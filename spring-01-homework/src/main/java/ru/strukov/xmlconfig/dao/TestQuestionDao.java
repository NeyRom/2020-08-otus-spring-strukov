package ru.strukov.xmlconfig.dao;

import org.springframework.core.io.Resource;
import ru.strukov.xmlconfig.domain.TestQuestion;

import java.util.List;

/**
 * @author Roman Strukov
 */

public interface TestQuestionDao {
    List<TestQuestion> getQuestions(Resource resource);
}
