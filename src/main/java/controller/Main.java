package controller;

import model.Movie;
import repository.*;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, Exception {
        Provider provider;
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();
        MovieMenu movieMenu = null;
        while (movieMenu != MovieMenu.G) {
            readMenu();
            try {
                String userInput = scanner.next();  // Read the user's input
                movieMenu = MovieMenu.valueOf(userInput.toUpperCase());

                switch (movieMenu) {
                    case A:
                        provider = new XMLprovider();
                        provider.readFile(movies);
                        break;
                    case B:
                        provider = new JSONprovider();
                        provider.readFile(movies);
                        break;
                    case C:
                        MenuOptions.genreSearch(movies);
                        break;
                    case D:
                        MenuOptions.actorSearch(movies);
                        break;
                    case E:
                        MenuOptions.dateSearch(movies);
                        break;
                    case F:
                        MenuOptions.moviesPrint(movies);
                        break;
                    case G:
                        System.out.println("Exiting the application...");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("An invalid value was entered from the menu");
                continue;
            }
        }
        scanner.close();
    }

    public static void readMenu() {
        System.out.println("Movie Menu:");
        System.out.println("A-Load XML file");
        System.out.println("B-Load JSON file");
        System.out.println("C-Search for a movie by genre");
        System.out.println("D-Search for a movie by actor name");
        System.out.println("E-Search for a movie by date");
        System.out.println("F-Save movies from memory");
        System.out.println("G-Exit");
        System.out.println("Enter a letter from the menu");
    }
}
