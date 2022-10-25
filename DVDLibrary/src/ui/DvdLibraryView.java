package ui;
import java.time.*;
import java.util.*;
import dto.DvD;

public class DvdLibraryView {
    private UserIO io; 
    public DvdLibraryView(UserIO io){
        this.io = io;
    }
    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List DVD Titles");
        io.print("2. Create New DVD Entry");
        io.print("3. View DVD");
        io.print("4. Remove DVD");
        io.print("5. Edit DVD");
        io.print("6. Find DvD");
        io.print("7. Exit");

        return io.readInt("Please Select from the Menu", 1, 7);
    }
 public DvD getNewDvDInfo (){
    String title = io.readString("Please enter the DVD Title");
    //LocalDate releaseDate = io.readDate("Please enter the DVD Release Date");
    String releaseDate = io.readString("Please enter the DVD Release Date");
    String mpaaRating = io.readString("Please enter the MPAA Rating");
    String directorName = io.readString("Please enter the Director's Name");
    String userRating = io.readString("Please enter your Rating of the DVD");
    String studio = io.readString("Please enter the DVD Studio");

    DvD currentDvD = new DvD(title);
    currentDvD.setReleaseDate(releaseDate);
    currentDvD.setMpaaRating(mpaaRating);
    currentDvD.setDirectorName(directorName);
    currentDvD.setUserRating(userRating);
    currentDvD.setStudio(studio);
    return currentDvD;
 }
 public void displayCreateDVDBanner(){
    io.print("=== Create DVD Entry ===");
     }

    public void displayCreateSuccessBanner() {
        io.readString ("DVD entry successfully created. Please hit enter to continue.");
    }   
   
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD ===");
    }

    public void displayDvdList(List <DvD> dvdList) {
               String dvdHeadings = String.format("%25s | %12s | %4s | %17s | %7s | %25s", 
               "Title",
                "Release Date",
                "MPAA",
                "Director Name",
                "Rating",
                "Studio");
        io.print(dvdHeadings);
        io.print("-----------------------------------------------------------------------------------");
        for (DvD currentDvd: dvdList) {
            String dvdInfo = String.format("%25s | %12s | %4s | %17s | %7s | %25s", 
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDirectorName(),
                    currentDvd.getUserRating(),
                    currentDvd.getStudio());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");

        }
        public void displayDvdListBanner() {
            io.print("=== Display all DVDs ===");
        }
        public void displayDisplayDvdBanner() {
            io.print("=== Display Current DVD ===");
        }
        public String getDvdTitleChoice() {
            return io.readString("Please enter the DVD title.");
        }
        public void displayDvd (DvD dvd) {
            if (dvd != null) {
                io.print("=== "+ dvd.getTitle()+" Summary ===");
                io.print("Title: " + dvd.getTitle());
                io.print("Release date: " + dvd.getReleaseDate());
                io.print("MPAA rating: " + dvd.getMpaaRating());
                io.print("Director's name: " + dvd.getDirectorName());
                io.print("User rating: " + dvd.getUserRating());
                io.print("Studio: "+ dvd.getStudio());
            } else {
                io.print("No such DVD");
            }
            io.readString("Please hit enter to continue.");
        }
        
        public void displayRemoveDvdBanner() {
            io.print("=== Remove Dvd ===");
        }
    
        public void displayRemoveResult(DvD dvdRecord) {
           if (dvdRecord !=null){
            io.print("DVD successfully removed.");
             } else {
                io.print("No such DVD.");
             }
             io.readString("Please hit enter to continue.");
        }
    
        public void displayExitBanner() {
            io.print("Good bye!");
        }
        
        public void displayUnknownCommandBanner() {
            io.print("Unknown command!");
        }
        
        public void displayEditDvdBanner() {
            io.print("=== Edit DVD ===");
            
        }
        public int printEditMenuAndGetSelection() {
            io.print("Which field do you want to change?");
            io.print("Edit DVD menu");
            io.print("1. Release date");
            io.print("2. MPAA rating");
            io.print("3. Director's name");
            io.print("4. User rating");
            io.print("5. Studio name");
            io.print("6. Exit edit menu");
            return io.readInt("Please select from the above choices.", 1,6);
        }
        
        public void displayEditReleaseDateBanner() {
            io.print("=== Edit DVD Release Date ===");
        }
        
        public void displayNullDVD() {
            io.print("No such DVD.");
            io.readString("Please hit enter to continue.");
        }
        public void displayEditDvdSuccess(DvD dvdToEdit) {
            io.print("DVD edited Successfully");
        }
        public void displayFindDvdsBanner() {
        }
        public int printFindMenuAndGetSelection() {
            io.print("Find DVD menu");
            io.print("1. Find all movies released in the last N years");
            io.print("2. Find all movies by MPAA rating");
            io.print("3. Find all movies by director");
            io.print("4. Find all movies by Studio");
            io.print("5. Exit find DVD menu");
            return io.readInt("Please select from the above choices.", 1,5);
        }
        public LocalDate getReleaseDate() {
            return io.readDate("Please enter the new DVD release date.");
        }
        public String getMpaaRating() {
            return io.readString("Please enter the new DVD MPAA rating.");
        }
        
        public String getDirectorName() {
            return io.readString("Please enter the new director's name.");
        }
        
        public String getUserRating() {
            return io.readString("Please enter the new user rating.");
        }
        
        public String getStudioName() {
            return io.readString("Please enter the studio name.");
        }
       public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
       }
    public int getNYears() {
        return 0;
    }
    
}    
