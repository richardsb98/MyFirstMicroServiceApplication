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
	private @Qualifier("actor") ActorRepository actorRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(@Qualifier("actor") ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}


	@GetMapping("/All_Actors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@PostMapping("/addActor")
	public @ResponseBody String addNewActor(@RequestParam String first_name, @RequestParam String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		System.out.println(first_name + " " + last_name);
		actorRepository.save(addActor);
		String SuccessfulAddActor = "saved";
		return SuccessfulAddActor;
	}



	//	@Autowired
//	private @Qualifier("film") FilmRepository filmRepository;


	//	public MyFirstMicroserviceApplication (@Qualifier("film") FilmRepository filmRepository){
//		this.filmRepository = filmRepository;
//	}

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
