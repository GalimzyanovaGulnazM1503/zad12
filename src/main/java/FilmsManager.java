public class FilmsManager {
    private final int filmVisibleCount;
    private String[] films = new String[0];

    public FilmsManager() {
        this.filmVisibleCount = 5;
    }

    public FilmsManager(int filmVisibleCount) {
        this.filmVisibleCount = filmVisibleCount;
    }

    public void add(String film) {
        String[] newFilms = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            newFilms[i] = films[i];
        }
        newFilms[films.length] = film;
        films = newFilms;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        String[] invertFilms = new String[filmVisibleCount];
        int len = films.length - 1;
        for (int i = 0; i < filmVisibleCount; i++) {
            invertFilms[i] = films[len - i];
        }
        return invertFilms;
    }
}
