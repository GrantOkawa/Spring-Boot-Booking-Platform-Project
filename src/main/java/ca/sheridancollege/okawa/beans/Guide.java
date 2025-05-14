package ca.sheridancollege.okawa.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String imageUrl;
    private String bio;
    private String specialty;
    private int yearsExperience;
    private String favoriteTrail;
    
    public String getFullName() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
    
    public String getImagePath() {
        return "/images/guides/" + imageUrl;
    }
}
