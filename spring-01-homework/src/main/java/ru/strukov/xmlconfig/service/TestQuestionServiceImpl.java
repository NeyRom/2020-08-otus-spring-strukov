package ru.strukov.xmlconfig.service;

import org.springframework.core.io.Resource;
import ru.strukov.xmlconfig.dao.TestQuestionDao;
import ru.strukov.xmlconfig.domain.TestQuestion;

import java.util.List;

/**
 * @author Roman Strukov
 */

public class TestQuestionServiceImpl implements TestQuestionService {
    private final TestQuestionDao testQuestionDao;
    private final String resource;
    private final ConsoleService consoleService;

    public TestQuestionServiceImpl(String resource,
                                   TestQuestionDao testQuestionDao,
                                   ConsoleService consoleService) {
        this.testQuestionDao = testQuestionDao;
        this.resource = resource;
        this.consoleService = consoleService;
    }

    @Override
    public void conductTesting(Resource resource) {
        List<TestQuestion> questions = testQuestionDao.getQuestions(resource);
        int questionsQuantity = questions.size();
        int questionNumber = 1;
        consoleService.printMessage("Total amount of questions " + questionsQuantity);
        for (TestQuestion question : questions) {
            getQuestion(question, questionNumber);
            questionNumber++;
        }
    }

    @Override
    public String getResource() {
        return this.resource;
    }

    public void getQuestion(TestQuestion question, int questionNumber) {
        consoleService.printMessage("Question #" + questionNumber + ": " + question.getQuestion());
        int answerNum = 1;
        for (String answer : question.getAnswers()) {
            consoleService.printMessage(answerNum + ". " + answer);
            answerNum++;
        }
    }

}
