import java.util.ArrayList;

/**
 * Абстрактный класс Театр
 */
public abstract class Theatre {

    /** Имя художественного руководителя */
    protected String _name;

    /** Название театра */
    protected String _supervisorName;

    /** Рейтинг театра */
    protected int _rating;

    /** Список театров */
    protected static ArrayList<Theatre> _array = new ArrayList<>();

    // Заполнение списка тестовыми значениями
    static {
        _array.add(new DramaTheatre("Большой театр", "Иванов", 95, "Россия", "Трагедия"));
        _array.add(new DramaTheatre("МХТ", "Петров",  92, "Россия", "Драма"));
        _array.add(new MusicTheatre("Метрополитен-опера", "Сидоров", 98, "Россия", "Джеймс Ливайн"));
        _array.add(new MusicTheatre("Ла Скала", "Иванов", 96, "Франция", "Риккардо Шайи"));
    }

    //Theatre() {};

    /**
     * Конструктор с параметрами
     *
     * @param supervisorName имя художественного руководителя
     * @param name название театра
     */
    Theatre(String name, String supervisorName, int rating) {
        //this();
        this._name = name;
        this._supervisorName = supervisorName;
        this._rating = rating;
    }

    /**
     * Метод возвращает рейтинг театра
     * @return рейтинг театра
     */
    public int getRating() {
        return this._rating;
    }

    /**
     * Метод вывода информации о полях театра
     * @return сообщение о полях
     */
    public String fieldInformation() {
        String message = "1. Название: " + this._name + "\n";
        message += "2. Художественный руководитель: " + this._supervisorName + "\n";
        message += "3. Рейтинг: " + this._rating + "\n";
        return message;
    }

    /**
     * Метод возвращает полную информацию о театре
     * @return строка с информацией о театре
     */
    public String print() {
        String message = "";
        message += "Название: " + this._name + "\n";
        message += "Руководитель: " + this._supervisorName + "\n";
        message += "Рейтинг: " + this._rating + "\n";
        return message;
    }

    /**
     * Метод замены художественного руководителя
     * @param newSupervisorName фамилия нового художественного руководителя
     */
    public String getNewSupervisor(String newSupervisorName) {
        this._supervisorName = newSupervisorName;
        return print();
    }

    /**
     * Метод замены названия театра
     * @param newName новое название театра
     * @return информация о театре после замены имени
     */
    public String getNewName(String newName) {
        this._name = newName;
        return print();
    }

    /**
     * Метод замены рейтинга театра
     * @param newRating новый рейтинг
     * @return информация о театре после замены рейтинга
     */
    public String getNewRating(int newRating) {
        this._rating = newRating;
        return print();
    }

    /**
     * Метод замены первого уникального поля у класса-наследника
     * @param newSpecificField1 новое значение
     * @return информация о театре после замены поля
     */
    abstract public String getNewFirstSpecificField(String newSpecificField1);

    /**
     * Метод замены второго уникального поля у класса-наследника
     * @param newSpecificField2 новое значение
     * @return информация о театре после замены поля
     */
    abstract public String getNewSecondSpecificField(String newSpecificField2);

    /**
     * Метод возвращает размер списка с театрами
     * @return размер списка
     */
    public static int getSize() {
        return _array.size();
    }

    /**
     * Метод сортировки по именам в обратном порядке
     * @return информация о списке после сортировки
     */
    public static String sortByNameReverse() {
        if (!_array.isEmpty()) {
            ArrayList<Theatre> reverseSortArray = new ArrayList<>(_array);
            reverseSortArray.sort((t1, t2) -> t2._name.compareToIgnoreCase(t1._name));
            String message = "Список отсортирован по именам в обратном порядке:\n";
            for (int i = 0; i < reverseSortArray.size(); i++)
                message += (i + 1) + ". " + reverseSortArray.get(i).print() + "\n";
            return message;
        } else {
            return "Действие невозможно: список пуст!";
        }
    }

    /**
     * Метод добавляет новый драматический театр в список театров
     * @param supervisorName имя художественного руководителя
     * @param name название театра
     * @param country страна расположения театра
     * @param genre основной жанр
     * @param rating рейтинг театра
     */
    public static void addDramaTheatre(String name, String supervisorName, int rating, String country, String genre) {
        _array.add(new DramaTheatre(name, supervisorName, rating, country, genre));
    }

    /**
     * Метод добавляет новый музыкальный театр в список театров
     * @param supervisorName имя художественного театра
     * @param name название театра
     * @param country страна расположения театра
     * @param musicDirector музыкальный директор
     * @param rating рейтинг театра
     */
    public static void addMusicTheatre(String name, String supervisorName, int rating, String country, String musicDirector) {
        _array.add(new MusicTheatre(name, supervisorName,rating, country, musicDirector));
    }

    /**
     * Метод удаляет театр из списка
     * @param index индекс театра
     */
    public static void removeByIndex(int index) {
        _array.remove(index);
    }

    /**
     * Метод возвращает все театры в списке
     * @return строка с информацией обо всех театрах
     */
    public static String showAll() {
        String message = "";
        if (!_array.isEmpty()) {
            for (int i = 0; i < _array.size(); i++)
                message += (i+1) + ". " + _array.get(i).print() + "\n";
        } else {
            message = "Список пуст!\n";
        }
        return message;
    }

    /**
     * Метод поиска театра по имени художественного руководителя
     * @param supervisorName имя художественного руководителя
     * @return строка с информацией о театре
     */
    public static String findBySupervisorName(String supervisorName) {
        for (Theatre theatre : _array) {
            if (theatre._supervisorName.equals(supervisorName)) {
                return theatre.print();
            }
        }
        return "Театр не найден!\n";

    }

    /**
     * Метод поиска театра с самым большим рейтингом
     * @return строка с информацией о театре с самым большим рейтингом
     */
    public static String getHighestRating() {
        int maximumRating = _array.get(0).getRating();
        String supervisorName = _array.get(0)._supervisorName ;
        for (Theatre theatre : _array) {
            if (maximumRating < theatre.getRating()) {
                maximumRating = theatre.getRating();
                supervisorName = theatre._supervisorName;
            }
        }
        return findBySupervisorName(supervisorName);
    }

    /**
     * Метод поиска театра по индексу
     * @param index индекс театра
     * @return информация о театре
     */
    public static String findByIndex(int index) {
        return _array.get(index).print();
    }
}
