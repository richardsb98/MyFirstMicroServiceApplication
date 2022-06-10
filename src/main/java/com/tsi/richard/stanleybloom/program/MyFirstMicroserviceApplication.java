package com.tsi.richard.stanleybloom.program;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Optional;
import java.lang.Short;


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


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmRepository filmRepository) {
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
	}

	@Autowired
	private ActorRepository actorRepository;

	@GetMapping("/allactors")
	@ResponseBody
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/actor/{actor_id}")
	public Optional<Actor> getActorID(@PathVariable("actor_id") int actorID) {
		return actorRepository.findById(actorID);
	}

	@GetMapping("/actor")
	public Optional<Actor> getActorByID(@RequestParam Integer actor_id) {
		return actorRepository.findById(actor_id);
	}

	@GetMapping("/actorfirstname")
	public Optional<Actor> getActorByFirstName(@RequestParam String first_name, Integer actor_id) {
		return actorRepository.findById(actor_id);
	}

	@PostMapping("/addactor")
	public String addActor(@RequestParam String first_name, @RequestParam String last_name) {
		System.out.println(first_name + " " + last_name);
		Actor newActor = new Actor(first_name, last_name);
		actorRepository.save(newActor);
		return "Actor Added using POST";
	}

	@PutMapping("/addnewactor")
	public String addNewActor(@RequestParam String first_name, @RequestParam String last_name) {
		System.out.println(first_name + " " + last_name);
		Actor newActor = new Actor(first_name, last_name);
		actorRepository.save(newActor);
		return "Added new Actor, using PUT";
	}


	@DeleteMapping("/actor/{actor_id}")
	public String deleteActor(@PathVariable("actor_id") int actor_id) {
		actorRepository.deleteById(actor_id);
		return "Actor Successfully Deleted";

	}





	//////////////////////////////////////////////////////////////// Film Table ////////////////////////////////////////////////////////////////


	int film_id;
	String title;
	int length;
	int release_year;
	String rating;
	int language_id;
	Film film = new Film();
    @Autowired
	private FilmRepository filmRepository;

	@GetMapping("/allfilms")
	@ResponseBody
	public Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}


	@GetMapping("/film/{film_id}")
	public Optional<Film> GetFilmByID (@PathVariable("film_id") int filmID) {
		return filmRepository.findById(filmID);
	}


}