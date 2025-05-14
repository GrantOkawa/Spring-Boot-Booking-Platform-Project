package ca.sheridancollege.okawa.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUser {
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String phone;
	private LocalDate entryDate;
	private String guide;
	private String trip;
	public static final String[] GUIDE = {
			"Anthony A", 
			"Dara A", 
			"Jack A", 
			"Josh A", 
			"Rafi A", 
			"Adam B",
			};
	public static final String[] TRIP = {
			"Lake Agnes Trail", 
			"The Big Beehive", 
			"Niagara Whirlpool Loop", 
			"Track and Tower Trail", 
			"Panorama Ridge", 
			"Joffre Lakes", 
			"Brewer Buttress", 
			"East Ridge" , 
			"Stawamus Chief First, Second, and Third Peak",
			"Stawamus Chief via Shannon Falls", 
			"Wild Algonqin"
			};
}
