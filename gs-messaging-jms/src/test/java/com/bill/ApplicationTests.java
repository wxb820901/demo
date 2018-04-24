package com.bill;

import com.bill.entity.Email;
import org.apache.activemq.broker.BrokerService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private JmsTemplate jmsTemplate;

    @Autowired
    private ConfigurableApplicationContext context;

    @Before
    public void deleteAllBeforeTests() throws Exception {
        jmsTemplate = context.getBean(JmsTemplate.class);
    }


    @Test
    public void sendSimpleMessage() throws InterruptedException {

        if (context != null) {
            System.out.println(" =======> Sending an email message.");
            jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
        }

        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains("info@example.com")).isTrue();
    }
}
