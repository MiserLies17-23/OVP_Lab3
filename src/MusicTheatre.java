public class MusicTheatre extends Theatre{

    /** Страна расположения театра */
    private String _country;

    /** Музыкальный директор */
    private String _musicDirector;

    MusicTheatre(String name, String supervisorName, int rating, String country, String musicDirector) {
        super(name, supervisorName, rating);
        this._country = country;
        this._musicDirector = musicDirector;
    }

    @Override
    public String getNewFirstSpecificField(String newSpecificField1) {
        this._country = newSpecificField1;
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
        message += "Страна: " + this._country + "\n";
        message += "Музыкальный директор: " + this._musicDirector + "\n";
        return message;
    }

    @Override
    public String fieldInformation() {
        String message = super.fieldInformation();
        message += "4. Страна: " + this._country;
        message += "5. Музыкальный директор: " + this._musicDirector;
        return message;
    }
}
