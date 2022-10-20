package controller;

import dao.dvdLibraryDao;
import ui.DvdLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class DvDLibraryController {
	private DvdLibraryView view;
	private dvdLibraryDao dao;
	private UserIO io = new UserIOConsoleImpl(){

	public DvDLibraryController(DvdLibraryView view, dvdLibraryDao dao) {
        //Initialize view and dao
		 this.dao = dao;
	     this.view = view;
	}
	 public void run() {
	        boolean keepGoing = true;
	        int menuSelection = 0;
	        try {
	            while (keepGoing) {
	            	io.print("Main Menu");
	                io.print("1. Add DVD Title");
	                io.print("2. Remove a DVD");
	                io.print("3. Edit a DVD");
	                io.print("4. List all DVDS");
	                io.print("5. Display DVD Info");
	                io.print("6. Search for DVDs");
	                io.print("7. Exit");
	                menuSelection = io.readInt("Please Select from Menu", 1, 7);

	                switch (menuSelection) {
	                        case 1:
	                        	io.print("1. Add DVD Title");
	                            break;
	                        case 2:
	                        	io.print("2. Remove a DVD");
	                            break;
	                        case 3:
	                        	io.print("3. Edit a DVD");
	                            break;
	                        case 4:
	                        	io.print("4. List all DVDS");
	                        	break;
	                        case 5:
	                        	io.print("5. Display DVD Info");
	                            break;
	                        case 6:
	                        	io.print("6. Search for DVDs");
	                            break;
	                        case 7:
	                            keepGoing = false;
	                            break;
	                        default:
	                            io.print("UKNOWN COMMAND");
	               }
	            }
	            	
	        	            
	           
	         
	    

	
		
	}