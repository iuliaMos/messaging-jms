package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class MessagingJmsApplication {

	private static final Logger log = LoggerFactory.getLogger(MessagingJmsApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MessagingJmsApplication.class, args);

		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);

		log.info("Sending an email message..");
		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello!"));
	}

}
