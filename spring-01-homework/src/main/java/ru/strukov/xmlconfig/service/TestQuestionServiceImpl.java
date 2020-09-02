package ru.strukov.xmlconfig.service;

import org.springframework.core.io.Resource;
import ru.strukov.xmlconfig.dao.TestQuestionDao;
import ru.strukov.xmlconfig.domain.Student;
import ru.strukov.xmlconfig.domain.TestQuestion;

import java.util.List;

/**
 * @author Roman Strukov
 */

public class TestQuestionServiceImpl implements TestQuestionService {
    private final TestQuestionDao testQuestionDao;
    private Student student;
    private final String resource;
    private final StudentService studentService;
    private final ConsoleService consoleService;

    public TestQuestionServiceImpl(String resource,
                                   TestQuestionDao testQuestionDao,
                                   StudentService studentService,
                                   ConsoleService consoleService) {
        this.testQuestionDao = testQuestionDao;
        this.resource = resource;
        this.studentService = studentService;
        this.consoleService = consoleService;
    }

    @Override
    public void conductTesting(Resource resource) {
        List<TestQuestion> questions = testQuestionDao.getQuestions(resource);
        int questionsQuantity = questions.size();
        int questionNumber = 1;
        int rightAnswers = 0;
        consoleService.printMessage("Total amount of questions " + questionsQuantity);
        for (TestQuestion question : questions) {
            rightAnswers += processQuestion(question, questionNumber);
            questionNumber++;
        }
        printTestResult(rightAnswers, questionsQuantity);
    }

    @Override
    public void setStudent() {
        student = studentService.setName();
    }

    @Override
    public String getResource() {
        return this.resource;
    }

    public int processQuestion(TestQuestion question, int questionNumber) {
        consoleService.printMessage("Question #" + questionNumber + ": " + question.getQuestion());
        int answerNum = 1;
        int rightAnswer = 1;
        for (String answer : question.getAnswers()) {
            System.out.println(answerNum + ". " + answer);
            if (answer.equals(question.getRightAnswer())) {
                rightAnswer = answerNum;
            }
            answerNum++;
        }
        int givenAnswer = consoleService.getInt();
        return givenAnswer == rightAnswer ? 1 : 0;
    }

    public void printTestResult(int rightAnswers, int questionsQuantity) {
        consoleService.printMessage("Test results " + studentService.getFullName(student) + ":");
        consoleService.printMessage("Right answers " + rightAnswers + " from " +
                questionsQuantity + " questions");
        consoleService.printMessage(rightAnswers > questionsQuantity / 2 ? "Test passed" : "Test not passed");
    }
}
