package com.bill;

import com.bill.entity.GroupXXX;
import com.bill.entity.Person;
import com.bill.repo.GroupXXXRepository;
import com.bill.repo.PersonRepository;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Server tcpServer() throws SQLException {
		Server server = Server.createTcpServer("-tcpAllowOthers","-tcpPort","9092").start();
		return server;
	}

	@Bean
	public Server webServer() throws SQLException {
		Server server = Server.createWebServer("-webAllowOthers", "-webPort", "8082").start();
		return server;
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, GroupXXXRepository groupXXXRepository) {
		return (args) -> {

			log.info("----------------load groups----------------");
			GroupXXX group1 = groupXXXRepository.save(new GroupXXX("Group1"));
			GroupXXX group2 = groupXXXRepository.save(new GroupXXX("Group2"));

			log.info("----------------fetch groups---------------");
			for (GroupXXX group : groupXXXRepository.findAll()) {
				log.info(group.toString());
			}
			log.info("");

			log.info("----------------load persons---------------");
			Person bill = personRepository.save(new Person("wang", "bill", group1, null, null));
			Person bill2 = personRepository.save(new Person("wang2", "bill2", group2, bill, null));
			Person bill3 = personRepository.save(new Person("wang3", "bill3", null, bill, null));

			log.info("----------------fetch persons---------------");
			for (Person person : personRepository.findAll()) {
				log.info(person.toString());
			}
			log.info("");

		};
	}


}
