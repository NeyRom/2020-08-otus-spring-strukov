package ru.strukov.xmlconfig.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.Resource;
import ru.strukov.xmlconfig.domain.TestQuestion;
import ru.strukov.xmlconfig.service.ConsoleService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Roman Strukov
 */

public class TestQuestionDaoImpl implements TestQuestionDao {
    private final ConsoleService consoleService;

    public TestQuestionDaoImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public List<TestQuestion> getQuestions(Resource resource) {
        List<TestQuestion> questions = new ArrayList<>();
        try {
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
            questions = new CsvToBeanBuilder<TestQuestion>(reader)
                    .withType(TestQuestion.class)
                    .build()
                    .parse();
        } catch (IllegalStateException ise) {
            consoleService.printMessage("Incorrect CSV format");
            ise.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(questions);
        return questions;
    }
}
