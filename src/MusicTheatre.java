/**
 * Класс Музыкальный театр
 */
public class MusicTheatre extends Theatre{

    /** Страна расположения театра */
    private String _repertoire;

    /** Музыкальный директор */
    private String _musicDirector;

    /**
     * Конструктор по умолчанию
     */
    MusicTheatre() {
        super();
        this._repertoire = "Не задано";
        this._musicDirector = "Не задано";
    }

    /**
     * Конструктор с параметрами
     * @param name название театра
     * @param supervisorName имя худрука
     * @param rating рейтинг
     * @param repertoire направление репертуара театра
     * @param musicDirector имя музыкального директора
     */
    MusicTheatre(String name, String supervisorName, int rating, String repertoire, String musicDirector) {
        super(name, supervisorName, rating);
        this._repertoire = repertoire;
        this._musicDirector = musicDirector;
    }

    @Override
    public String getNewFirstSpecificField(String newSpecificField1) {
        this._repertoire = newSpecificField1;
        return print();
    }

    @Override
    public String getNewSecondSpecificField(String newMusicDirector) {
        this._musicDirector = newMusicDirector;
        return print();
    }

    @Override
    public String print() {
        String message = super.print();
        message += "Репертуар: " + this._repertoire + "\n";
        message += "Музыкальный директор: " + this._musicDirector + "\n";
        return message;
    }

    @Override
    public String fieldInformation() {
        String message = super.fieldInformation();
        message += "4. Репертуар: " + this._repertoire;
        message += "5. Музыкальный директор: " + this._musicDirector;
        return message;
    }
}
