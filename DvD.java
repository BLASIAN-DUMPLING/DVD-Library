package dto;

import java.time.LocalDate;

public class DvD {

	//DVD properties
	 private String title;
	    private LocalDate releaseDate;
	    private String mpaaRating;
	    private String directorName;
	    private String userRating;
	    private String studio;
	   
	    //constructor
	    public DvD(String title) {
	    	this.title = title;
	    }
	    
	    //getter and setters
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public LocalDate getReleaseDate() {
			return releaseDate;
		}
		
		public void setReleaseDate(LocalDate releaseDate) {
			this.releaseDate = releaseDate;
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
		
}
