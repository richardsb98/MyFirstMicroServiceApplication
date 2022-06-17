package com.tsi.richard.stanleybloom.program;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
@CrossOrigin (origins = "*")     //needed for receiving request via api
@RestController                 // handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home")        // base url
public class MyFirstMicroserviceApplication {


	public MyFirstMicroserviceApplication(){
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmRepository filmRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository) {
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.languageRepository = languageRepository;
		this.categoryRepository = categoryRepository;
	}

	//////////////////////////////////////////////////////////////// Actor Table ////////////////////////////////////////////////////////////////

	int actor_id;
	String first_name;
	String last_name;
	Actor actor = new Actor();

	@Autowired
	private ActorRepository actorRepository;

	@GetMapping("/allactors")
	public Iterable<Actor> getAllActors() {										// Covered by Mockito Test
		return actorRepository.findAll();
	}								// Covered by Mockito Test

	@GetMapping("/actor/{actor_id}")
	public Optional<Actor> getActorByID(@PathVariable("actor_id") Integer actor_id) {						// Covered by Mockito Test
		return actorRepository.findById(actor_id);
	}

	@GetMapping("/actorfirstname")
	public Optional<Actor> getActorByFirstName(@RequestParam String first_name, @RequestParam String last_name, Integer actor_id) {					// Covered by Mockito Test
		return actorRepository.findById(actor_id);
	}

	@PostMapping("/addactor")
	public String addActor(@RequestParam String first_name, @RequestParam String last_name, @RequestParam Integer actor_id) {						// Covered by Mockito Test
		System.out.println(first_name + " " + last_name);
		Actor newActor = new Actor(first_name, last_name, actor_id);
		actorRepository.save(newActor);
		return "New Actor Saved";
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


	@DeleteMapping("/actor/{actor_id}")																			// Covered by Mockito Test
	public String deleteActor(@PathVariable("actor_id") Integer actor_id) {
		actorRepository.deleteById(actor_id);
		return "Actor Deleted";

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

	@GetMapping("/allfilms")																						// Covered by Mockito Test
	public Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}


	@GetMapping("/film/{film_id}")
	public Optional<Film> getFilmByID (@PathVariable("film_id") Integer filmID) {									// Covered by Mockito Test
		return filmRepository.findById(filmID);
	}

	@GetMapping("/film")
	public Optional<Film> findFilmByID (@RequestParam Integer film_id){												// Covered by Mockito Test
		return filmRepository.findById(film_id);
	}

	@PostMapping("/addfilm")
	public String addFilm (@RequestParam int film_id, @RequestParam String title, @RequestParam int length, @RequestParam int release_year, @RequestParam String rating, @RequestParam int language_id) {
		System.out.println("The film titled " + title +" was saved");
		Film newFilm = new Film(film_id, title, length, release_year, rating, language_id);
		filmRepository.save(newFilm);
		return "New Film Saved";
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
	public String deleteFilmByID (@PathVariable("film_id") Integer film_id) {											// Covered by Mockito Test
		filmRepository.deleteById(film_id);
		return "Film Deleted";
	}



	//////////////////////////////////////////////////////////////// Language Table ////////////////////////////////////////////////////////////////


	@Autowired
	private LanguageRepository languageRepository;

	Language language = new Language();

	@GetMapping("/alllanguages")
	public Iterable<Language> AllLanguages () {
		return languageRepository.findAll();
	}									// Covered by Mockito Test

	@GetMapping("/language/{language_id}")
	public Optional<Language> getLanguageByID (@PathVariable("language_id") Integer language_id) {						// Covered by Mockito Test
		return languageRepository.findById(language_id);
	}

	@PostMapping("/addlanguage")
	public String addLanguage (@RequestParam Integer language_id, @RequestParam String name) {
		System.out.println("New language called " + name + " was added");
		Language language = new Language(language_id, name);
		languageRepository.save(language);
		return "New language Saved";
	}

	@PutMapping("/updatelanguage")
	public ResponseEntity<Language> updateLanguage(@RequestParam Integer language_id, String name) throws ResourceNotFoundException {
		Language language = languageRepository.findById(language_id).orElseThrow(() -> new ResourceNotFoundException("Language not found for this ID"));
		language.setLanguage_id(language_id);
		language.setName(name);
		languageRepository.save(language);
		System.out.println("Updated Language Information: " + language_id + " " + name);
		return ResponseEntity.ok(language);
	}

	@DeleteMapping("/deletelanguage/{language_id}")																		// Covered by Mockito Test
	public String deleteLanguageByID (@PathVariable("language_id") Integer language_id) {
		languageRepository.deleteById(language_id);
		return "Language Deleted";
	}




	//////////////////////////////////////////////////////////////// Category Table ////////////////////////////////////////////////////////////////


	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/allcategories")																						// Covered by Mockito Test
	public Iterable<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@GetMapping("category/{category_id}")																				// Covered by Mockito Test
	public Optional<Category> getCategoryByID(@PathVariable("category_id") Integer category_id) {
		return categoryRepository.findById(category_id);
	}

	@PostMapping("/addcategory")
	public String addCategory (@RequestParam Integer category_id, @RequestParam String name) {
		Category newCategory = new Category(category_id, name);
		System.out.println("New Category Called " + name + " Was Added To The Database");
		categoryRepository.save(newCategory);
		return "New Category Saved";
	}

	@PutMapping("/updatecategory")
	public ResponseEntity<Category> updateCategory (@RequestParam Integer category_id, String name) throws ResourceNotFoundException {
		Category updateCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("No Category Found With That ID"));
		updateCategory.setCategory_id(category_id);
		updateCategory.setName(name);
		categoryRepository.save(updateCategory);
		System.out.println("Updated Category Information: " + category_id + " " + name);
		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/deletecategory/{category_id}")																		// Covered by Mockito Test
	public String deleteCategory(@PathVariable("category_id") Integer category_id, String name) {
		categoryRepository.deleteById(category_id);
		return "Category Deleted";
	}



	//////////////////////////////////////////////////////////////// Film_Actor Table ////////////////////////////////////////////////////////////////

	@GetMapping("/films/{film_id}/actors")
	public ResponseEntity<Optional<Actor>> getAllActorsByFilmID(@PathVariable(value = "film_id") Integer film_id) {
		if (!filmRepository.existsById(film_id)) {
			throw new ResourceNotFoundException("Not found Film with id = " + film_id);
		}
		Optional<Actor> actor = actorRepository.findById(film_id);
		return new ResponseEntity<>(actor, HttpStatus.OK);

	}


	@GetMapping("/actors/{actor_id}/films")
	public ResponseEntity<Optional<Film>> getAllFilmsByActorID(@PathVariable(value = "actor_id") Integer actor_id) {
		if (!actorRepository.existsById(actor_id)) {
			throw new ResourceNotFoundException("Not found Actor  with id = " + actor_id);
		}
		Optional<Film> films = filmRepository.findById(actor_id);
		return new ResponseEntity<>(films, HttpStatus.OK);
	}


	//////////////////////////////////////////////////////////////// Film_Categories Table ////////////////////////////////////////////////////////////////

	@GetMapping("/films/{film_id}/categories")
	public ResponseEntity<Optional<Category>> getAllCategoriesByFilmID(@PathVariable(value = "film_id") Integer film_id) {
		if (!filmRepository.existsById(film_id)) {
			throw new ResourceNotFoundException("Not found Film with id = " + film_id);
		}
		Optional<Category> categories = categoryRepository.findById(film_id);
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/categories/{category_id}/films")
	public ResponseEntity<Optional<Film>> getAllFilmsByCategoryID(@PathVariable(value = "category_id") Integer category_id) {
		if (!categoryRepository.existsById(category_id)) {
			throw new ResourceNotFoundException("Not found Category  with id = " + category_id);
		}
		Optional<Film> films = filmRepository.findById(category_id);
		return new ResponseEntity<>(films, HttpStatus.OK);
	}










}