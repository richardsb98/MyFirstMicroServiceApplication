package com.tsi.richard.stanleybloom.program;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@SpringBootApplication
@CrossOrigin (origins = "*")     //needed for receiving request via api
@RestController                 // handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home")        // base url
public class MyFirstMicroserviceApplication {

	public MyFirstMicroserviceApplication(){
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmRepository filmRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository, Film_CategoryRepository film_categoryRepository) {
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
	Actor actor = new Actor();

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

	@PutMapping("/updateactor")
	public ResponseEntity<Actor> updateActor(@RequestParam Integer actor_id, String first_name, String last_name) throws ResourceNotFoundException {
		Actor actor = actorRepository.findById(actor_id).orElseThrow(()-> new ResourceNotFoundException("Actor not found for this ID"));
		actor.setFirst_name(first_name);
		actor.setLast_name(last_name);
		actorRepository.save(actor);
		System.out.println("Updated Actor Information: " + actor_id + first_name + last_name);
		return ResponseEntity.ok(actor);
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

	@PutMapping("/updatefilm")
	public ResponseEntity<Film> updateFilm (@RequestParam String title, int length, int release_year, String rating, int language_id) throws ResourceNotFoundException {
		Film film = filmRepository.findById(film_id).orElseThrow(() -> new ResourceNotFoundException("Film not found for this ID"));
		film.setTitle(title);
		film.setLength(length);
		film.setRelease_year(release_year);
		film.setRating(rating);
		film.setLanguage_id(language_id);
		filmRepository.save(film);
		System.out.println("Updated Film Information: " + title + length + release_year + rating + language_id);
		return ResponseEntity.ok(film);
	}

	@DeleteMapping("/deletefilm/{film_id}")
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

	@GetMapping("/language/{language_id}")
	public Optional<Language> getLanguageByID (@PathVariable("language_id") Integer language_id) {
		return languageRepository.findById(language_id);
	}

	@PostMapping("/addlanguage")
	public String addLanguage (@RequestParam Integer language_id, @RequestParam String name) {
		System.out.println("New language called " + name + " was added");
		Language language = new Language(language_id, name);
		languageRepository.save(language);
		return "language saved";
	}

	@PutMapping("/updatelanguage")
	public ResponseEntity<Language> updateLanguage(@RequestParam Integer language_id, String name) throws ResourceNotFoundException {
		Language language = languageRepository.findById(language_id).orElseThrow(() -> new ResourceNotFoundException("Language not found for this ID"));
		language.setLanguage_id(language_id);
		language.setName(name);
		languageRepository.save(language);
		System.out.println("Updated Language Information: " + language_id + name);
		return ResponseEntity.ok(language);
	}

	@DeleteMapping("/deletelanguage/{language_id}")
	public String deleteLanguageByID (@PathVariable("language_id") Integer language_id) {
		languageRepository.deleteById(language_id);
		return "Actor Deleted";
	}












}