package com.example.HiberTest;

import com.example.HiberTest.DAO.daoRepository;
import com.example.HiberTest.Entities.text;
import com.example.HiberTest.Entities.textTable;
import com.example.HiberTest.SessionConfig.sessionFactoryConfig;
import com.example.HiberTest.Statistics.characterStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class HiberTestApplication implements CommandLineRunner {

	//Logger logger = LoggerFactory.getLogger(HiberTestApplication.class);

	@Autowired
	daoRepository dao;

	@Autowired
	characterStats stat;

	public static void main(String[] args) {
		SpringApplication.run(HiberTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{

		stat.getTextForStatistics();
		stat.getStatistics();
		//stat.printStat();
		//stat.
		stat.getSorted();
		//stat.printStat();
		stat.printStatisticsToFile();
		listToString(dao.findAll());
	}


	private static void listToString(List<textTable> lst){


		lst.stream().forEach(System.out::println);
	}


}
