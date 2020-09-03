package ru.strukov.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.strukov.xmlconfig.service.TestQuestionService;

/**
 * @author Roman Strukov
 */

public class XmlConfigApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("/spring-context.xml");
        TestQuestionService service = context.getBean(TestQuestionService.class);
        service.conductTesting(context.getResource(service.getResource()));
    }
}
