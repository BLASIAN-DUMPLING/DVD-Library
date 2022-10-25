package dvdLibrary;

import controller.DvDLibraryController;
import dao.DvDLibraryDaoException;
import dao.DvdLibraryDaoImpl;
import dao.dvdLibraryDao;
import ui.DvdLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class App {
	public static void main (String[] args) throws DvDLibraryDaoException{
		UserIO myIo = new UserIOConsoleImpl();
		DvdLibraryView myView = new DvdLibraryView(myIo);
		dvdLibraryDao myDao = new DvdLibraryDaoImpl();
		DvDLibraryController controller = new DvDLibraryController(myView, myDao);
		controller.run(); 
	}
}