package repository;

import model.Actor;
import model.Movie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuOptions {

    public static void genreSearch(List<Movie> movies) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter movie type:");
        String genre = scanner.next();
        for (Movie e : movies) {
            if (e.getGenre().compareTo(genre) == 0)
                System.out.println(e.getTitle());
        }
    }

    public static void actorSearch(List<Movie> movies) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the name of the actor");
        String name = scanner.next();
        for (Movie e : movies) {
            for (Actor a : e.getListOfActors()) {
                if (a.getLastName().compareTo(name) == 0)
                    System.out.println(e.getTitle());
            }
        }
    }

    public static void dateSearch(List<Movie> movies) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a date range from (DD.MM.YYYY):");
        String dateFromString = scanner.next();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateFrom = format.parse(dateFromString);

        System.out.println("Enter a date range to (DD.MM.YYYY");
        String dateToString = scanner.next();
        Date dateTo = format.parse(dateToString);

        for (Movie e : movies) {
            if (e.getDateOfProduction().before(dateTo) && e.getDateOfProduction().after(dateFrom))
                System.out.println(e.getTitle());
        }
    }

    public static void moviesPrint(List<Movie> movies) {
        for (Movie e : movies) {
            System.out.println("MOVIE: "+e.getTitle()+".\n"+"DIRECTOR: "+e.getDirector()+".\n"+"DATE: "+e.getDateOfProduction()+".\n"+"GENRE: "+e.getGenre()+".\n"+"ACTORS: "+e.getListOfActors());
        }
    }

}
