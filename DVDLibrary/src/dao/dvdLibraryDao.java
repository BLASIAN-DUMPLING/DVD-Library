package dao;

import dto.DvD;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.*;

public interface dvdLibraryDao {

    DvD addDvD (String title, DvD dvd) throws DvDLibraryDaoException;
    List<DvD> getAllDvD() throws DvDLibraryDaoException;
    DvD getDvD(String title) throws DvDLibraryDaoException;
    DvD removeDvD (String title) throws DvDLibraryDaoException;
    DvD changeReleaseDate(String title, LocalDate newReleaseDate) throws DvDLibraryDaoException;
    DvD changeMpaaRating(String title, String newMpaaRating) throws DvDLibraryDaoException;
    DvD changeDirectorName(String title, String newDirectorName) throws DvDLibraryDaoException;
    DvD changeUserRating(String title, String newUserRating) throws DvDLibraryDaoException;
    DvD changeStudioName(String title, String newStudioName) throws DvDLibraryDaoException;
    Map<String, DvD> getDvdsLastYears();
    Map<String, DvD> getDvdsByMpaaRating(String mpaaRating);
    Map<String, DvD> getDvdsByDirector(String director);
    Map<String, DvD> getDvdsByStudio(String studio);
    DvD changeReleaseDate(String title, String newReleaseDate) throws DvDLibraryDaoException;
}