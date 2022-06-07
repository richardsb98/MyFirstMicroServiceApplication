package com.tsi.richard.stanleybloom.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;



@SpringBootApplication
@CrossOrigin (origins = "*")     //needed for receiving request via api
@RestController                 // handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")        // base url
public class MyFirstMicroserviceApplication {

	public String addActor;
	@Autowired
	private ActorRepository actorRepository;

//	@Autowired
//	private @Qualifier("film") FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication (ActorRepository actorRepository){
		this.actorRepository =actorRepository;
	}
//	public MyFirstMicroserviceApplication (@Qualifier("film") FilmRepository filmRepository){
//		this.filmRepository = filmRepository;
//	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

//	@PostMapping("/Add_Actors")
//	public @ResponseBody String Add_Actor(@RequestParam String actor_name){
//
//	}

//	@GetMapping("/All_Films")
//	public @ResponseBody
//	Iterable<Film>getAllFilms(){
//		return filmRepository.findAll();
//	}
//
}
