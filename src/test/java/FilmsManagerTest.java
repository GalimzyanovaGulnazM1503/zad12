import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class FilmsManagerTest {

    private FilmsManager manager;

    @BeforeEach
    void setUp() {
        manager = new FilmsManager();
    }

    // Тесты для конструкторов
    @Test
    void constructor_Default_ShouldSetVisibleCountTo5() {
        FilmsManager defaultManager = new FilmsManager();
        String[] films = defaultManager.findAll();
        assertNotNull(films);
        assertEquals(0, films.length);
    }

    @Test
    void constructor_WithCustomVisibleCount_ShouldSetCorrectCount() {
        FilmsManager customManager = new FilmsManager(3);

        // Добавляем фильмы
        customManager.add("Film 1");
        customManager.add("Film 2");
        customManager.add("Film 3");
        customManager.add("Film 4");
        customManager.add("Film 5");

        String[] lastFilms = customManager.findLast();
        assertEquals(3, lastFilms.length);
    }

    // Тесты для метода add()
    @Test
    void add_OneFilm_ShouldAddToFilmsArray() {
        manager.add("Film 1");

        String[] films = manager.findAll();
        assertEquals(1, films.length);
        assertEquals("Film 1", films[0]);
    }

    @Test
    void add_MultipleFilms_ShouldAddAllFilms() {
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] films = manager.findAll();
        assertEquals(3, films.length);
        assertEquals("Film 1", films[0]);
        assertEquals("Film 2", films[1]);
        assertEquals("Film 3", films[2]);
    }

    @Test
    void add_EmptyFilm_ShouldAddEmptyString() {
        manager.add("");

        String[] films = manager.findAll();
        assertEquals(1, films.length);
        assertEquals("", films[0]);
    }

    // Тесты для метода findAll()
    @Test
    void findAll_WhenNoFilms_ShouldReturnEmptyArray() {
        String[] films = manager.findAll();

        assertNotNull(films);
        assertEquals(0, films.length);
    }

    @Test
    void findAll_WithFilms_ShouldReturnAllFilmsInOrder() {
        manager.add("First Film");
        manager.add("Second Film");
        manager.add("Third Film");

        String[] films = manager.findAll();

        assertEquals(3, films.length);
        assertEquals("First Film", films[0]);
        assertEquals("Second Film", films[1]);
        assertEquals("Third Film", films[2]);
    }

    @Test
    void findLast_WhenExactlyVisibleCount_ShouldReturnAllFilmsInReverseOrder() {
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        String[] lastFilms = manager.findLast();

        assertEquals(5, lastFilms.length);
        assertEquals("Film 5", lastFilms[0]);
        assertEquals("Film 4", lastFilms[1]);
        assertEquals("Film 3", lastFilms[2]);
        assertEquals("Film 2", lastFilms[3]);
        assertEquals("Film 1", lastFilms[4]);
    }

    @Test
    void findLast_WhenMoreThanVisibleCount_ShouldReturnLastVisibleCountFilmsInReverseOrder() {
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");

        String[] lastFilms = manager.findLast();

        assertEquals(5, lastFilms.length);
        assertEquals("Film 7", lastFilms[0]);
        assertEquals("Film 6", lastFilms[1]);
        assertEquals("Film 5", lastFilms[2]);
        assertEquals("Film 4", lastFilms[3]);
        assertEquals("Film 3", lastFilms[4]);
    }

    @Test
    void findLast_WithCustomVisibleCount_WhenMoreThanVisible_ShouldReturnLastVisible() {
        FilmsManager customManager = new FilmsManager(2);
        customManager.add("Film A");
        customManager.add("Film B");
        customManager.add("Film C");
        customManager.add("Film D");

        String[] lastFilms = customManager.findLast();

        assertEquals(2, lastFilms.length);
        assertEquals("Film D", lastFilms[0]);
        assertEquals("Film C", lastFilms[1]);
    }

    @Test
    void findLast_WithCustomVisibleCount_WhenExactlyVisible_ShouldReturnAll() {
        FilmsManager customManager = new FilmsManager(4);
        customManager.add("Film A");
        customManager.add("Film B");
        customManager.add("Film C");
        customManager.add("Film D");

        String[] lastFilms = customManager.findLast();

        assertEquals(4, lastFilms.length);
        assertEquals("Film D", lastFilms[0]);
        assertEquals("Film C", lastFilms[1]);
        assertEquals("Film B", lastFilms[2]);
        assertEquals("Film A", lastFilms[3]);
    }
}