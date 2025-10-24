/**
 * Класс Драматический театр
 */
public class DramaTheatre extends Theatre {

    /** Страна расположения театра */
    private String _country;

    /** Основной жанр театра */
    private String _genre;

    /**
     * Конструктор с параметрами
     * @param name название театра
     * @param supervisorName имя худрука
     * @param rating рейтинг театра
     * @param country страна расположения театра
     * @param genre основной жанр
     */
    DramaTheatre(String name, String supervisorName, int rating, String country, String genre) {
        super(name, supervisorName, rating);
        this._country = country;
        this._genre = genre;
    }

    @Override
    public String getNewFirstSpecificField(String newCountry) {
        this._country = newCountry;
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
        message += "Страна: " + this._country + "\n";
        message += "Жанр: " + this._genre + "\n";
        return message;
    }

    @Override
    public String fieldInformation() {
        String message = super.fieldInformation();
        message += "4. Страна: " + this._country + "\n";
        message += "5. Жанр: " + this._genre + "\n";
        return message;
    }
}
