package com.tsi.richard.stanleybloom.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;

@EntityScan(basePackages = "com.tsi.richard.stanleybloom.program")


@SpringBootApplication
@CrossOrigin (origins = "*")     //needed for receiving request via api
@RestController                 // handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")        // base url
public class MyFirstMicroserviceApplication {

	@Autowired
	private @Qualifier("actor") ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication (@Qualifier("actor") ActorRepository actorRepository){
		this.actorRepository =actorRepository;
	}

	@GetMapping("All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

}
