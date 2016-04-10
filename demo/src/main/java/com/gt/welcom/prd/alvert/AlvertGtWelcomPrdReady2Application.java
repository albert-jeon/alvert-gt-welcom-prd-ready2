package com.gt.welcom.prd.alvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.gt.welcom.prd.alvert.common.Constant;
import com.gt.welcom.prd.alvert.service.AllianceService;
import com.gt.welcom.prd.alvert.service.ItemsService;
import com.gt.welcom.prd.alvert.service.StoresService;
@Configuration
@SpringBootApplication
public class AlvertGtWelcomPrdReady2Application implements CommandLineRunner {

	@Autowired
	private AllianceService allianceService;
	
	@Autowired
	private StoresService storesService;
	
	@Autowired
	private ItemsService itemsService;
	
	public static void main(String[] args) throws Exception {
		Constant.getInstance();
		SpringApplication.run(AlvertGtWelcomPrdReady2Application.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		//this.allianceService.addAlliance();
		this.storesService.addStores();
		//this.itemsService.addItems();
	}
}
