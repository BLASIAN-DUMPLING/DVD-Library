package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
import dto.DvD;

public class DvdLibraryDaoImpl implements dvdLibraryDao {
public static final String DVD_FILE = "dvd.txt";
public static final String DELIMITER = "::";
    private Map<String, DvD> dvd = new HashMap<>();

        @Override
        public DvD addDvD(String title, DvD dvd) throws DvDLibraryDaoException {
loadLibrary();
DvD newDvD = dvd.put(title, dvd);
writeLibrary();
return newDvD; 
        //DvD prevDvD = dvd.put(title, dvd);
         //  return prevDvD; 
        }

        @Override
        public List<DvD> getAllDvD() throws DvDLibraryDaoException
        {
          loadLibrary();
         return new ArrayList<DvD>(dvd.values());
        }

        @Override
        public DvD getDvD(String title) throws DvDLibraryDaoException {
          loadLibrary();
            return dvd.get(title);
        }

        @Override
        public DvD removeDvD(String title) throws DvDLibraryDaoException {
          loadLibrary();
          DvD removeDvD = dvd.remove (title);
          return removeDvD;
        }

      

      @Override
      public DvD changeMpaaRating(String title, String mpaaRating) throws DvDLibraryDaoException {
          loadLibrary();
          DvD currentDvD = dvd.get(title);
          currentDvD.setMpaaRating(mpaaRating);
          writeLibrary();
          return currentDvD;
      }
  
      @Override
      public DvD changeDirectorName(String title, String directorName) throws DvDLibraryDaoException {
          loadLibrary();
          DvD currentDvD = dvd.get(title);
          currentDvD.setDirectorName(directorName);
          writeLibrary();
          return currentDvD;
      }
  
      @Override
      public DvD changeUserRating(String title, String userRating)throws DvDLibraryDaoException {
          loadLibrary();
          DvD currentDvD = dvd.get(title);
          currentDvD.setUserRating(userRating);
          writeLibrary();
          return currentDvD;
      }
      
      @Override
      public DvD changeStudioName(String title, String studioName) throws DvDLibraryDaoException {
          loadLibrary();
          DvD currentDvD = dvd.get(title);
          currentDvD.setStudio(studioName);
          writeLibrary();
          return currentDvD;
      }

      //file persistence 
      //marshalling and unmarshalling 
private DvD unmarshallDvD(String dvdAsText){
String [] dvdTokens = dvdAsText.split (DELIMITER);
String title = dvdTokens[0];
DvD dvdFromFile = new DvD(title);
dvdFromFile.setReleaseDate(dvdTokens[1]);
dvdFromFile.setMpaaRating(dvdTokens[2]);
dvdFromFile.setDirectorName(dvdTokens[3]);
dvdFromFile.setUserRating(dvdTokens[4]);
dvdFromFile.setStudio(dvdTokens[5]);
return dvdFromFile;
}

private void loadLibrary() throws DvDLibraryDaoException {
Scanner scanner; 
try {
  scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
}catch (FileNotFoundException e) {
  throw new DvDLibraryDaoException("Could not load data into memory.");
}
String currentLine;
DvD currentDvD;
while (scanner.hasNextLine()) {
  currentLine = scanner.nextLine();
  currentDvD = unmarshallDvD(currentLine);
  dvd.put(currentDvD.getTitle(), currentDvD);
}
scanner.close();
}
private String marshallDvD(DvD aDvD) {
String dvdAsText = aDvD.getTitle() + DELIMITER;
dvdAsText += aDvD.getReleaseDate() + DELIMITER;
dvdAsText += aDvD.getMpaaRating() + DELIMITER;
dvdAsText += aDvD.getDirectorName() + DELIMITER;
dvdAsText += aDvD.getUserRating() + DELIMITER;
dvdAsText += aDvD.getStudio();
return dvdAsText;
}
private void writeLibrary() throws DvDLibraryDaoException {
  PrintWriter out;
  try {
    out = new PrintWriter(new FileWriter(DVD_FILE));
  } catch (IOException e) {
    throw new DvDLibraryDaoException("Could not save DVD data.", e);
  }
  String dvdAsText;
  List<DvD> dvdList = this.getAllDvD();
  for (DvD currentDvD : dvdList) {
    dvdAsText = marshallDvD(currentDvD);
    out.println(dvdAsText);
    out.flush();
  } out.close();
}




@Override
public DvD changeReleaseDate(String title, LocalDate newReleaseDate) throws DvDLibraryDaoException {
  loadLibrary();
  DvD dvdToEdit = dvd.get(title);
  dvdToEdit.setReleaseDate(newReleaseDate);
  writeLibrary();
  return dvdToEdit;
}

@Override
public Map<String, DvD> getDvdsLastYears() {
 
  return null;
}

@Override
public Map<String, DvD> getDvdsByMpaaRating(String mpaaRating) {
  
  return null;
}

@Override
public Map<String, DvD> getDvdsByDirector(String director) {
  
  return null;
}

@Override
public Map<String, DvD> getDvdsByStudio(String studio) {
 
  return null;
}
}