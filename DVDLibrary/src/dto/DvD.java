package dto;



public class DvD {
	private String title;
   	private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String userRating;
    private String studio; 

	public DvD (String title){
		this.title = title;
	}
// getters and setters
public String getTitle() {
	return title;
}


public String getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(String dvdTokens) {
	this.releaseDate = dvdTokens;
} 


public String getMpaaRating() {
	return mpaaRating;
}

public void setMpaaRating(String mpaaRating) {
	this.mpaaRating = mpaaRating;
}

public String getDirectorName() {
	return directorName;
}

public void setDirectorName(String directorName) {
	this.directorName = directorName;
}

public String getUserRating() {
	return userRating;
}

public void setUserRating(String userRating) {
	this.userRating = userRating;
}

public String getStudio() {
	return studio;
}

public void setStudio(String studio) {
	this.studio = studio;
}
public DvD put(String title2, DvD dvd) {
	return null;
}



}