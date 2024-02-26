package ksi.Lab8_WebAppCats.seeder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ksi.Lab8_WebAppCats.models.Cat;
import ksi.Lab8_WebAppCats.repositories.CatRepository;

@Configuration 
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(CatRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Cat("Felix", "Mieszaniec")));
			log.info("Preloading " + repository.save(new Cat("Filemon", "Maine Coon")));
		};
	}
}
