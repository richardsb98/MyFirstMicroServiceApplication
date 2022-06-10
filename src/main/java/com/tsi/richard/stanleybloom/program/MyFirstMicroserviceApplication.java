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
	public MyFirstMicroserviceApplication() {
	}
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmRepository filmRepository, LanguageRepository languageRepository) {
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.languageRepository = languageRepository;
	}

	//////////////////////////////////////////////////////////////// Actor Table ////////////////////////////////////////////////////////////////

	int actor_id;
	String first_name;
	String last_name;
	Actor addActor = new Actor();

	@Autowired
	private ActorRepository actorRepository;

	@GetMapping("/allactors")
	@ResponseBody
	public Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/actor/{actor_id}")
	public Optional<Actor> getActorID(@PathVariable("actor_id") Integer actorID) {
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
	public String deleteActor(@PathVariable("actor_id") Integer actor_id) {
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
	public Optional<Film> getFilmByID (@PathVariable("film_id") Integer filmID) {
		return filmRepository.findById(filmID);
	}

	@GetMapping("/film")
	public Optional<Film> findFilmByID (@RequestParam Integer film_id){
		return filmRepository.findById(film_id);
	}

	@PostMapping("/addfilm")
	public String addFilm (@RequestParam int film_id, @RequestParam String title, @RequestParam int length, @RequestParam int release_year, @RequestParam String rating, @RequestParam int language_id) {
		System.out.println("The film titled " + title +" was saved");
		Film newFilm = new Film(film_id, title, length, release_year, rating, language_id);
		filmRepository.save(newFilm);
		return "saved";
	}

	@PutMapping("/addnewfilm")
	public String addNewFilm (@RequestParam int film_id, @RequestParam String title, @RequestParam int length, @RequestParam int release_year, @RequestParam String rating, @RequestParam int language_id) {
		System.out.println("The new film titled " + title +" was saved");
		Film newFilm = new Film(film_id, title, length, release_year, rating, language_id);
		filmRepository.save(newFilm);
		return "New film saved";
	}

	@DeleteMapping("/film/{film_id}")
	public String deleteFilmByID (@PathVariable("film_id") Integer film_id) {
		filmRepository.deleteById(film_id);
		return "film deleted";
	}




	//////////////////////////////////////////////////////////////// Language Table ////////////////////////////////////////////////////////////////


	@Autowired
	private LanguageRepository languageRepository;

	Language language = new Language();

	@GetMapping("/alllanguages")
	@ResponseBody
	public Iterable<Language> AllLanguages () {
		return languageRepository.findAll();
	}












}