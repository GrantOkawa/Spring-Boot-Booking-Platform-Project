package ca.sheridancollege.okawa.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.okawa.beans.Adventure;
import ca.sheridancollege.okawa.beans.Destination;
import ca.sheridancollege.okawa.beans.Guide;
import ca.sheridancollege.okawa.beans.Trip;
import ca.sheridancollege.okawa.beans.RegisteredUser;
import ca.sheridancollege.okawa.database.DatabaseAccess;

@Controller
public class HomeController {
	@Autowired
	@Lazy
	private DatabaseAccess db;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("trips", null); 
		return "home";
	}
	
	@GetMapping("/searchTrips")
	public String searchTrips(
	        @RequestParam(required = false) String location,
	        @RequestParam(required = false) String adventureType,
	        @RequestParam(required = false) Integer difficulty,
	        Model model) {
		
		List<Trip> filteredTrips = db.getSearchedTrip(location, adventureType,difficulty); 
	    model.addAttribute("trips", filteredTrips);
	    return "home";
	}
	
    @GetMapping("/destinations")
    public String destinations(Model model) {
        List<Destination> destinations = db.getAllDestinations();
        model.addAttribute("destinations", destinations);
        return "destinations";
    }
	
	@GetMapping("/destination-alberta-hikes")
	public String destinationAlbertaHikes(Model model){
		List<Trip> trips = db.getTripsByTypeAndLocation("Day Hike Tour", "Alberta");
		model.addAttribute("trips", trips);
		return "destination-alberta-hikes";
	}
	
	@GetMapping("/destination-ontario-hikes")
	public String destinationOntarioHikes(Model model){
		List<Trip> trips = db.getTripsByTypeAndLocation("Day Hike Tour", "Ontario"); 

        model.addAttribute("trips", trips);
		return "destination-ontario-hikes";
	}
	
	@GetMapping("/destination-british-columbia-hikes")
	public String destinationBritishColumbiaHikes(Model model){
		List<Trip> trips = db.getTripsByTypeAndLocation("Day Hike Tour", "British Columbia"); 

        model.addAttribute("trips", trips);
		return "destination-british-columbia-hikes";
	}
	
	@GetMapping("/destination-alberta-rock-climbing")
	public String destinationAlbertaRockClimbing(Model model){
		List<Trip> trips = db.getTripsByTypeAndLocation("Guided Rock Climbing", "Alberta"); 

        model.addAttribute("trips", trips);
		return "destination-alberta-rock-climbing";
	}
	
	@GetMapping("/destination-ontario-backcountry-camping")
	public String destinationOntarioBackcountryCamping(Model model){
		List<Trip> trips = db.getTripsByTypeAndLocation("Guided Backcountry Trip", "Ontario"); 

        model.addAttribute("trips", trips);
		return "destination-ontario-backcountry-camping";
	}
	
	@GetMapping("/destination-british-columbia-rock-climbing")
	public String destinationBritishColumbiaRockClimbing(Model model){
		List<Trip> trips = db.getTripsByTypeAndLocation("Guided Rock Climbing", "British Columbia"); 

        model.addAttribute("trips", trips);
		return "destination-british-columbia-rock-climbing";
	}
	
    @GetMapping("/adventures")
    public String adventures(Model model) {
        List<Adventure> adventures = db.getAllAdventures();

        model.addAttribute("adventures", adventures);
        return "adventures";
    }
	
    @GetMapping("/adventures-rock-climbing")
    public String adventuresRockClimbing(Model model) {
        List<Trip> trips = db.getTripsByType("Guided Rock Climbing"); 
        model.addAttribute("trips", trips);
        return "adventures-rock-climbing";
    }
	
	@GetMapping("/adventures-hiking")
	public String adventuresHiking(Model model){
        List<Trip> trips = db.getTripsByType("Day Hike Tour"); 

        model.addAttribute("trips", trips);
		return "adventures-hiking";
	}
	
	@GetMapping("/adventures-backcountry-camping")
	public String adventuresBackcountryCamping(Model model){
        List<Trip> trips = db.getTripsByType("Guided Backcountry Trip"); 
   
        model.addAttribute("trips", trips);
		return "adventures-backcountry-camping";
	}

	@GetMapping("/guides")
	public String getGuidesPage(Model model) {
	    model.addAttribute("guides", db.getAllGuides());
	    return "guides";
	}

	@GetMapping("/guides/{id}")
	public String getGuideDetails(@PathVariable Long id, Model model) {
	    Guide guide = db.getGuideById(id);
	    if (guide != null) {
	        model.addAttribute("guide", guide);
	        return "guide-details";
	    } else {
	        return "redirect:/guides";
	    }
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new RegisteredUser()); 
		model.addAttribute("tripList", db.getUserTripList()); 
		return "secure/registration";
	}
	
	//Insert user that registered for a trip
    @PostMapping("/insertUserTrip")
    public String insertUser(Model model, @ModelAttribute RegisteredUser user, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entryDate) {
        //Set the entry date of the User
        user.setEntryDate(entryDate);

        List<RegisteredUser> existingUserTrip = db.getUserTripById(user.getId());
        if (existingUserTrip.isEmpty()) {
            db.insertUserTrip(user);
        } else {
            db.updateUserTripById(user);
            System.out.println("Updated user trip with Id: " + user.getId() + " into the database");
        }

        model.addAttribute("user", new RegisteredUser()); 
        model.addAttribute("tripList", db.getUserTripList()); 
        return "redirect:/registration";
    }
	
    @GetMapping("/updateUserTripById/{id}")
    public String updateUserTripById(Model model, @PathVariable int id) {
    	RegisteredUser user = db.getUserTripById(id).get(0);
    	db.updateUserTripById(user);
    	
    	model.addAttribute("user", user);
    	model.addAttribute("tripList", db.getUserTripList());
    	return "secure/registration";
    }
    
    @GetMapping("/deleteUserTripById/{id}")
    public String deleteUserTripById(Model model, @PathVariable int id) {
    	db.deleteUserTripList(id);
    	
    	model.addAttribute("user", new RegisteredUser());
    	model.addAttribute("tripList", db.getUserTripList());
    	return "secure/registration";
    }
    
    //Implementation for assignment 3
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping("/signup")
    public String signUp() {
    	return "sign-up";
    }
    
    @GetMapping("/permission-denied")
    public String permissionDenied() {
    	return "error/permission-denied";
   	}
    
    @GetMapping("/secure")
    public String secureRegistration() {
    	return "secure/registration";
    }
    
    @PostMapping("/signup")
    public String postSignup(
    		@RequestParam String username,
    		@RequestParam String password) {
    	db.addUser(username, password);
    	Long userId = db.findUserAccount(username).getUserId();
    	db.addRole(userId, Long.valueOf(1)); //roleId 1 is for ROLE_USER
    	return "redirect:/login";
    }
    
    //Admin
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("trip", new Trip());
		model.addAttribute("allTrips", db.getAllTrips()); 
		return "admin/admin";
	}
	
	//Admin
    @GetMapping("/updateTripById/{id}")
    public String updateTripById(Model model, @PathVariable int id) {
    	Trip trip = db.getTripById(id).get(0);
    	db.updateTripById(trip);
    	
    	model.addAttribute("trip", trip);
    	model.addAttribute("allTrips", db.getAllTrips());
    	return "admin/admin";
    }
    
    //Admin
    @GetMapping("/deleteTripById/{id}")
    public String deleteTripById(Model model, @PathVariable int id) {
    	db.deleteTrip(id);
    	
    	model.addAttribute("trip", new Trip());
    	model.addAttribute("allTrips", db.getAllTrips());
    	return "admin/admin";
    }
    
    //Admin Insert Updated Trip Details
	@PostMapping("/insertTrip")
    public String insertTrip(Model model, @ModelAttribute Trip trip) {
        List<Trip> existingTrip = db.getTripById(trip.getId());
        if (existingTrip.isEmpty()) {
            db.insertTrip(trip);
        } else {
            db.updateTripById(trip);
            System.out.println("Updated trip with Id: " + trip.getId() + " into the database");
        }

        model.addAttribute("trip", new Trip()); 
        model.addAttribute("allTrips", db.getAllTrips()); 
        return "redirect:/admin";
    }
}