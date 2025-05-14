package ca.sheridancollege.okawa.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;


import ca.sheridancollege.okawa.beans.Adventure;
import ca.sheridancollege.okawa.beans.Destination;
import ca.sheridancollege.okawa.beans.Guide;
import ca.sheridancollege.okawa.beans.Trip;
import ca.sheridancollege.okawa.beans.User;
import ca.sheridancollege.okawa.beans.RegisteredUser;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder; //Assignment 3
	
	public void insertUserTrip(RegisteredUser user) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(); 
		
		String query = "INSERT INTO app_user(fName, lName, email, phone, entryDate, guide, trip) VALUES(:fName, :lName, :email, :phone, :entryDate, :guide, :trip)";
		namedParameters.addValue("fName", user.getFName());
		namedParameters.addValue("lName", user.getLName());
		namedParameters.addValue("email", user.getEmail());
		namedParameters.addValue("phone", user.getPhone());
		namedParameters.addValue("entryDate", user.getEntryDate());
		namedParameters.addValue("guide", user.getGuide());
		namedParameters.addValue("trip", user.getTrip());
		
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0) {System.out.println("Inserted user trip into the database");};
	}
	
	public void updateUserTripById(RegisteredUser user) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "UPDATE app_user SET fName = :fName, lName = :lName, email = :email, phone = :phone, entryDate = :entryDate, guide = :guide, trip = :trip WHERE id = :id";
		namedParameters.addValue("id", user.getId());
		namedParameters.addValue("fName", user.getFName());
		namedParameters.addValue("lName", user.getLName());
		namedParameters.addValue("email", user.getEmail());
		namedParameters.addValue("phone", user.getPhone());
		namedParameters.addValue("entryDate", user.getEntryDate());
		namedParameters.addValue("guide", user.getGuide());
		namedParameters.addValue("trip", user.getTrip());
		
		jdbc.update(query, namedParameters);
	}
	
	public void deleteUserTripList(int id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "DELETE FROM app_user WHERE id = :id";
		namedParameters.addValue("id", id);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0) {System.out.println("Deleted user trip with ID: "+ id +" from the database");};
	}
	
	public List<RegisteredUser> getUserTripList(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM app_user";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<RegisteredUser>(RegisteredUser.class));
	}
	
	public List<RegisteredUser> getUserTripById(int id){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM app_user WHERE id = :id";
		namedParameters.addValue("id", id);
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<RegisteredUser>(RegisteredUser.class));
	}
	
	public List<Trip> getAllTrips() {
	    String query = "SELECT * FROM trips";
	    List<Trip> trips = jdbc.query(query, new BeanPropertyRowMapper<>(Trip.class));

	    return trips;
	}
	
    public List<Trip> getSearchedTrip(String location, String adventureType, Integer difficulty) {
    	
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM trips WHERE 1=1"); //base query that's always true
 
        if (location != null && !location.isEmpty()) {
            queryBuilder.append(" AND location = :location");
            namedParameters.addValue("location", location);
        }
        if (adventureType != null && !adventureType.isEmpty()) {
            queryBuilder.append(" AND tripType = :adventureType"); 
            namedParameters.addValue("adventureType", adventureType);
        }
        if (difficulty != null) {
            queryBuilder.append(" AND difficulty = :difficulty");
            namedParameters.addValue("difficulty", difficulty);
        }

        String query = queryBuilder.toString();

        List<Trip> trips = jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Trip.class));
        return trips;
    }
    
    public List<Trip> getTripsByTypeAndLocation(String tripType, String location) {
        String query = "SELECT * FROM trips WHERE tripType = :tripType AND location = :location";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("tripType", tripType);
        namedParameters.addValue("location", location);
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Trip.class));
    }
    
    public List<Trip> getTripsByType(String tripType) {
        String query = "SELECT * FROM trips WHERE tripType = :tripType";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("tripType", tripType);
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Trip.class));
    }
    
    public List<Guide> getAllGuides() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM guides";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Guide>(Guide.class));
    }

    public Guide getGuideById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM guides WHERE id = :id";
        namedParameters.addValue("id", id);
        
        List<Guide> guides = jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Guide>(Guide.class));
        return guides.isEmpty() ? null : guides.get(0);
    }
    
    public List<Destination> getAllDestinations() {
        String query = "SELECT * FROM destinations";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Destination.class));
    }
    
    public List<Adventure> getAllAdventures() {
        String query = "SELECT * FROM adventures";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Adventure.class));
    }
    
    //Implementations for assignment 3
    // Method to find a user account by email
    public User findUserAccount(String email) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM sec_user where email = :email";
        namedParameters.addValue("email", email);
        
        try {
            return jdbc.queryForObject(query, namedParameters, new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }
    
    // Method to get User Roles for a specific User id
    public List<String> getRolesById(Long userId) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT sec_role.roleName " +
                       "FROM user_role, sec_role " +
                       "WHERE user_role.roleId = sec_role.roleId " +
                       "AND userId = :userId";
        namedParameters.addValue("userId", userId);
        
        return jdbc.queryForList(query, namedParameters, String.class);
    }
    
    //Add user
    public void addUser(String email, String password) {
    	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    	String query = "INSERT INTO sec_user "
    	+ "(email, encryptedPassword, enabled) "
    	+ "VALUES (:email, :encryptedPassword, 1)";
    	namedParameters.addValue("email", email);
    	namedParameters.addValue("encryptedPassword",
    	passwordEncoder.encode(password));
    	jdbc.update(query, namedParameters);
    	}
    
    //Add role
    public void addRole(Long userId, Long roleId) {
    	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    	String query = "INSERT INTO user_role (userId, roleId) "
    	+ "VALUES (:userId, :roleId)";
    	namedParameters.addValue("userId", userId);
    	namedParameters.addValue("roleId", roleId);
    	jdbc.update(query, namedParameters);
    	}
    
    //Admin
    //Update trip
	public void updateTripById(Trip trip) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "UPDATE trips SET id = :id, imageUrl = :imageUrl, durationAndPrice = :durationAndPrice, title = :title, location = :location, area = :area, tripType = :tripType, difficulty = :difficulty, highlights = :highlights WHERE id = :id";
		namedParameters.addValue("id", trip.getId());
		namedParameters.addValue("imageUrl", trip.getImageUrl());
		namedParameters.addValue("durationAndPrice", trip.getDurationAndPrice());
		namedParameters.addValue("title", trip.getTitle());
		namedParameters.addValue("location", trip.getLocation());
		namedParameters.addValue("area", trip.getArea());
		namedParameters.addValue("tripType", trip.getTripType());
		namedParameters.addValue("difficulty", trip.getDifficulty());
		namedParameters.addValue("highlights", trip.getHighlights());
		
		jdbc.update(query, namedParameters);
	}
	
	//Admin
	//Get trip by id
	public List<Trip> getTripById(int id){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM trips WHERE id = :id";
		namedParameters.addValue("id", id);
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Trip>(Trip.class)); 
	}
	
	//Admin
	//Delete Trip
	public void deleteTrip(int id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "DELETE FROM Trips WHERE id = :id";
		namedParameters.addValue("id", id);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0) {System.out.println("Deleted trip with ID: "+ id +" from the database");};
	}
	
	public void insertTrip(Trip trip) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource(); 
		
		String query = "INSERT INTO trips (imageUrl, durationAndPrice, title, location, area, tripType, difficulty, highlights) "
                + "VALUES (:imageUrl, :durationAndPrice, :title, :location, :area, :tripType, :difficulty, :highlights)";		
		namedParameters.addValue("imageUrl", trip.getImageUrl());
		namedParameters.addValue("durationAndPrice", trip.getDurationAndPrice());
		namedParameters.addValue("title", trip.getTitle());
		namedParameters.addValue("location", trip.getLocation());
		namedParameters.addValue("area", trip.getArea());
		namedParameters.addValue("tripType", trip.getTripType());
		namedParameters.addValue("difficulty", trip.getDifficulty());
		namedParameters.addValue("highlights", trip.getHighlights());
		
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0) {System.out.println("Inserted new trip into the database");};
	}
}
