package ca.sheridancollege.okawa.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
	private int id;
    private String imageUrl;
    private String durationAndPrice;
    private String title;
    private String location;
    private String area;
    private String tripType;
    private int difficulty;
    private String highlights;
}