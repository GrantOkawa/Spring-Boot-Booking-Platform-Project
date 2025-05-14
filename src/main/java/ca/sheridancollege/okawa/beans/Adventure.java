package ca.sheridancollege.okawa.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adventure {
	private int id;
	private String title;
	private String imageUrl;
	private String linkUrl;
	private int tripCount;
}
