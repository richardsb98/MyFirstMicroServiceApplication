package com.tsi.richard.stanleybloom.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@SpringBootApplication
@CrossOrigin (origins = "*")     //needed for receiving request via api
@RestController                 // handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home")        // base url
public class MyFirstMicroserviceApplication {

	String first_name;
	String last_name;
	int actor_id;
	Actor addActor = new Actor();


	public MyFirstMicroserviceApplication() {
	}

	@Autowired
	private ActorRepository actorRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}


	@GetMapping("/All_Actors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/actor{actor_id}")
	public @ResponseBody Optional<Actor> getActorID (@PathVariable("actor_id") int actorID) {
		return actorRepository.findById(actorID);
	}




	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping("/{id}")
//	public Actor actorID(@PathVariable int actor_id)  {
//		return Actor.findByID(id);
//	}
//
//
//	@GetMapping("/actor/{actor_id}")
//	public Optional<Actor> getactorID(@PathVariable("actor_id") {
//		Iterable<Actor> Actor = actorRepository.findByPostalCode(actor_id);
//		return Actor;
//	}
//}
//


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/addActor")
	public @ResponseBody String addActor(@RequestParam String first_name, @RequestParam String last_name) {
		System.out.println(first_name + " " + last_name);
		actorRepository.save(addActor);
		String SuccessfulAddActor = "saved";
		return SuccessfulAddActor;
	}

	@PutMapping("/addNewActor")
	public @ResponseBody String addNewActor(@RequestParam String first_name, @RequestParam String last_name) {
		return "Added new Actor";
	}


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

