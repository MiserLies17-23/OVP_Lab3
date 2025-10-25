/**
 * Класс Драматический театр
 */
public class DramaTheatre extends Theatre {

    /** Основной жанр театра */
    private String _genre;

    /** Главный драматург театра */
    private String _playwright;

    /**
     * Конструктор по умолчанию
     */
    DramaTheatre() {
        super();
        this._genre = "Не задано";
        this._playwright = "Не задано";
    }

    /**
     * Конструктор с параметрами
     * @param name название театра
     * @param supervisorName имя худрука
     * @param rating рейтинг театра
     * @param playwright драматург театра
     * @param genre основной жанр
     */
    DramaTheatre(String name, String supervisorName, int rating,String genre, String playwright) {
        super(name, supervisorName, rating);
        this._genre = genre;
        this._playwright = playwright;
    }

    @Override
    public String getNewFirstSpecificField(String newPlaywright) {
        this._playwright = newPlaywright;
        return print();
    }

    @Override
    public String getNewSecondSpecificField(String newGenre) {
        this._genre = newGenre;
        return print();
    }

    @Override
    public String print() {
        String message = super.print();
        message += "Жанр: " + this._genre + "\n";
        message += "Драматург: " + this._playwright + "\n";
        return message;
    }

    @Override
    public String fieldInformation() {
        String message = super.fieldInformation();
        message += "4. Жанр: " + this._genre + "\n";
        message += "5. Драматург: " + this._playwright + "\n";
        return message;
    }
}
