package repository;

public enum MovieMenu {
    Z("Continue"),
    A("load XML file"),
    B("load JSON file"),
    C("Search for a movie by genre"),
    D("search for movie by actor name"),
    E("search for a movie by date"),
    F("save movies from memory"),
    G("exit");

    private String meaning;


    MovieMenu(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

}