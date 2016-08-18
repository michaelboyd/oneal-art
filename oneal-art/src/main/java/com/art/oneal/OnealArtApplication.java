package com.art.oneal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.art.oneal.domain.Artist;
import com.art.oneal.domain.ArtistRepository;

@SpringBootApplication
public class OnealArtApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OnealArtApplication.class);
	
	@Autowired
	ArtistRepository artistRepo;	
	
	public static void main(String[] args) {
		SpringApplication.run(OnealArtApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadSampleData() {
		return (args) -> {

			log.info("loading sample data");
			
			artistRepo.deleteAll();
			
			Artist one = new Artist("Pablo Picasso");
			Artist two = new Artist("Michael Boyd");
			
			artistRepo.save(one);
			artistRepo.save(two);
			
			log.info("finished loading sample data");
			
			log.info("Artists found with findAll():");
			log.info("-------------------------------");
			for (Artist artist : artistRepo.findAll()) {
				log.info(artist.toString());
			}
			log.info("-------------------------------");			
			
		};
		
	}	
}
