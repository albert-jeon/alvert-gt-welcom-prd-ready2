package com.gt.welcom.prd.alvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import com.gt.welcom.prd.alvert.service.AllianceService;
@Configuration
@SpringBootApplication
public class AlvertGtWelcomPrdReady2Application implements CommandLineRunner {

	@Autowired
	private AllianceService allianceService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AlvertGtWelcomPrdReady2Application.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(this.allianceService.findStoreByStoreName());
	}
}
