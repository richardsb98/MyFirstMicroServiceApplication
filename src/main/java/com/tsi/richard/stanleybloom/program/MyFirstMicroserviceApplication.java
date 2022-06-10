package com.tsi.richard.stanleybloom.program;

import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
@CrossOrigin (origins = "*")     //needed for receiving request via api
@RestController                 // handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home")        // base url
public class MyFirstMicroserviceApplication {

	String first_name;
	String last_name;
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
	@ResponseBody
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/actor/{actor_id}")
	@ResponseBody
	public Optional<Actor> getActorID(@PathVariable("actor_id") int actorID) {
		return actorRepository.findById(actorID);
	}

//	public ActorsName(){
//		return
//	}
//
//	@GetMapping("/actor/{firstname}/{lastname}")
//	@ResponseBody
//	public List<Actor> getActorName (@PathVariable("first_name") String firstname, @PathVariable("last_name") String lastname) {
//		return NameRepository.findByLastName(firstname);


//	@GetMapping("/actor")
//	public Iterable<Actor> isActorAvailable(@RequestBody Actor actor) {
//		return NameRepository.
//
//	}

//	@GetMapping("/actor_firstname")
//	public Iterable<Actor> getActorFirstName(@RequestParam String first_name) {
//		return NameRepository.findByLastName(first_name);
//
//	}


//	@GetMapping("/actor")
//	public Actor isActorAvailable(@RequestBody Actor actor) {
//		return actorRepository.findByFirstName(actor.first_name, actor.last_name)
//	}
//
//


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/addActor")
	@ResponseBody
	public String addActor(@RequestParam String first_name, @RequestParam String last_name) {
		System.out.println(first_name + " " + last_name);
		Actor newActor = new Actor(first_name, last_name);
		actorRepository.save(newActor);
		return "Actor Added";
	}

	@PutMapping("/addNewActor")
	@ResponseBody
	public String addNewActor(@RequestParam String first_name, @RequestParam String last_name) {
		return "Added new Actor";
	}


	@DeleteMapping("/actor/{actor_id}")
	public String deleteActor(@PathVariable("actor_id") int actor_id) {
		actorRepository.deleteById(actor_id);
		return "Actor Successfully Deleted";

	}


//	@DeleteMapping(value = "/posts/{id}")
//	public ResponseEntity<Long> deletePost(@PathVariable Long id) {
//
//		var isRemoved = postService.delete(id);
//
//		if (!isRemoved) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<>(id, HttpStatus.OK);
//	}


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



	//////////////////////////////////////////////////////////////// Film Table ////////////////////////////////////////////////////////////////



	int length;
	Year release_year;
	Enum rating;

	private FilmRepository filmRepository;

	public MyFirstMicroserviceApplication(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}



}