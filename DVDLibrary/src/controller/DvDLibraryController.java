package controller;

import java.util.List;
import java.util.Map;
import java.time.*;
import dao.DvDLibraryDaoException;
import dao.dvdLibraryDao;
import dto.DvD;
import ui.DvdLibraryView;

public class DvDLibraryController {
	//private UserIO io = new UserIOConsoleImpl();
    private DvdLibraryView view;
    private dvdLibraryDao dao;
    public DvDLibraryController(DvdLibraryView view, dvdLibraryDao dao){
    this.dao = dao;
    this.view = view;
}
    public void run() throws DvDLibraryDaoException
{
    boolean keepGoing = true;
    int menuSelection = 0;
    try{
    while (keepGoing)
    { 
menuSelection =  getMenuSelection(); //io.readInt("Please Select from the Menu", 1, 7);

switch (menuSelection) {
    case 1: listDvd();
        break;
    case 2: createDvD();
        break;
    case 3: displayDvd();
        break;
    case 4: removeDvD();
        break;
    case 5: editDvd();
        break;
    case 6: findDvD();
        break;
    case 7: keepGoing = false;
        break;
    default:unknownCommand();
  
}

}
exitMessage();
}
catch (DvDLibraryDaoException e) {
    view.displayErrorMessage(e.getMessage());
}
}

private void exitMessage() {
    view.displayExitBanner();
}
private int getMenuSelection(){
    return view.printMenuAndGetSelection();
}
private void createDvD() throws DvDLibraryDaoException{
    view.displayCreateDVDBanner();
    DvD newDvD = view.getNewDvDInfo();
    dao.addDvD(newDvD.getTitle(), newDvD);
    view.displayCreateSuccessBanner();

}

private void listDvd () throws DvDLibraryDaoException{
    view.displayDisplayAllBanner();
    List<DvD> dvdList = dao.getAllDvD();
    view.displayDvdList(dvdList);
}
private void displayDvd() throws DvDLibraryDaoException{
    view.displayDisplayDvdBanner();
    String title = view.getDvdTitleChoice();
    DvD dvd = dao.getDvD(title);
    view.displayDvd(dvd);
}
private void removeDvD() throws DvDLibraryDaoException{
view.displayRemoveDvdBanner();
String title = view.getDvdTitleChoice();
DvD remoDvD = dao.removeDvD(title);
view.displayRemoveResult(remoDvD);
}
private void editDvd() throws DvDLibraryDaoException {
    view.displayEditDvdBanner();
    String title = view.getDvdTitleChoice();
    DvD dvdToEdit = dao.getDvD(title);
    if (dvdToEdit ==null) {
        view.displayNullDVD();
    } else {
        view.displayDvd(dvdToEdit);
        int editMenuSelection = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            editMenuSelection = view.printEditMenuAndGetSelection();

            switch (editMenuSelection){
                case 1:
                    editReleaseDate(title);
                    break;
                case 2:
                    editMpaaRating(title);
                    break;
                case 3:
                    editDirectorName(title);
                    break;
                case 4:
                    editUserRating(title);
                    break;
                case 5:
                    editStudioName(title);
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
            if (keepGoing == false) {
                break;
        } 
    }
    }
}
/*private int geteditMenuSelection(){
    return view.printEditMenuAndGetSelection();
} */

private void editReleaseDate(String title) throws DvDLibraryDaoException  {
    view.displayEditReleaseDateBanner();
    LocalDate newReleaseDate = view.getReleaseDate();
    dao.changeReleaseDate(title, newReleaseDate);
    view.displayEditDvdBanner();
}
private void editMpaaRating(String title) throws DvDLibraryDaoException {
    //view.displayEditMpaaRatingBanner();
    String newMpaaRating = view.getMpaaRating();
    dao.changeMpaaRating(title, newMpaaRating);
    view.displayEditDvdBanner();
}
private void editDirectorName(String title) throws DvDLibraryDaoException  {
    //view.displayEditDirectorNameBanner();
    String newDirectorName = view.getDirectorName();
    dao.changeDirectorName(title, newDirectorName);
    view.displayEditDvdBanner();
}
private void editUserRating(String title) throws DvDLibraryDaoException  {
    String newUserRating = view.getUserRating();
    dao.changeUserRating(title, newUserRating);
    view.displayEditDvdBanner();
}
private void editStudioName(String title) throws DvDLibraryDaoException  {
    String newStudioName = view.getStudioName();
    dao.changeStudioName(title, newStudioName);
    view.displayEditDvdBanner();
}
/**
 * 
 */
private void findDvD() throws DvDLibraryDaoException  {
    view.displayFindDvdsBanner();
    int findDvdsSelection = 0;
    boolean keepGoing = true;
    while (keepGoing) {
        findDvdsSelection = view.printFindMenuAndGetSelection();
        switch (findDvdsSelection){
            case 1:
                findMoviesLastNYears();
                break;
            case 2:
                findMoviesByMpaaRating();
                break;
            case 3:
                findMoviesByDirector();
                break;
            case 4:
                findMoviesByStudio();
                break;
            case 5:
                keepGoing = false;
                break;
                default:
                    unknownCommand();
            }
            if (keepGoing = false) {
                break;
        }
     }
}
private void findMoviesLastNYears() throws DvDLibraryDaoException {
    view.getNYears();
    Map<String, DvD> filteredDvds = dao.getDvdsLastYears();
    view.displayDvd((DvD) filteredDvds);
}

private void findMoviesByMpaaRating() throws DvDLibraryDaoException {
    String mpaaRating = view.getMpaaRating();
    Map<String, DvD> filteredDvds = dao.getDvdsByMpaaRating(mpaaRating);
    view.displayDvd((DvD) filteredDvds);
}

private void findMoviesByDirector() throws DvDLibraryDaoException {
    String director = view.getDirectorName();
    Map<String, DvD> filteredDvds = dao.getDvdsByDirector(director);
    view.displayDvd((DvD) filteredDvds);
}
private void findMoviesByStudio() throws DvDLibraryDaoException {
    String studio = view.getStudioName();
    Map<String, DvD> filteredDvds = dao.getDvdsByStudio(studio);
    view.displayDvd((DvD) filteredDvds);
}
private void unknownCommand() {
    view.displayUnknownCommandBanner();
}
}