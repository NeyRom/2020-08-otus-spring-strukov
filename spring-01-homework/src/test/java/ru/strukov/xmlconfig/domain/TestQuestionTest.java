package ru.strukov.xmlconfig.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Roman Strukov
 */

@DisplayName("TestQuestion Class")
class TestQuestionTest {

    @DisplayName("Correct setup fields")
    @Test
    void shouldHaveCorrectConstructor() {
        TestQuestion question = new TestQuestion();
        question.setQuestion("Some interesting question");
        question.setRightAnswer("True");

        assertEquals("Some interesting question", question.getQuestion());
        assertEquals("True", question.getRightAnswer());
    }
}