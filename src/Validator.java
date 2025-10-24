/**
 * Класс валидации
 */
public abstract class Validator {

    /**
     * Метод проверки всех параметров
     * @param name название
     * @param supervisorName имя худрука
     * @param rating рейтинг
     * @return булево значение соответствия параметров допустимым значениям
     */
    public static boolean paramsValidate(String name, String supervisorName, int rating, String firstSpecificField, String secondSpecificField) {
        return nameValidate(name) && personNameValidate(supervisorName) && ratingValidate(rating)
                && stringFieldValidate(firstSpecificField) && personNameValidate(secondSpecificField);
    }

    /**
     * Метод проверки имени деятеля
     * @param personName имя деятеля
     * @return значение соответствия имени
     */
    public static boolean personNameValidate(String personName) {
        String nameRegex = "[А-ЯЁ][а-яё]+(\\s[А-ЯЁ][а-яё]+)*";
        return personName.matches(nameRegex);
    }

    /**
     * Метод проверки рейтинга
     * @param rating рейтинг
     * @return булево значение соответствия рейтинга
     */
    public static boolean ratingValidate(int rating) {
        return 0 <= rating && rating <= 100;
    }

    /**
     * Метод проверки названия театра
     * @param name название
     * @return булево значение соответствия названия шаблону
     */
    public static boolean nameValidate(String name) {
        String nameRegex = "[А-ЯЁ][а-яА-ЯёЁ]+(\\s[А-ЯЁ][а-яА-Яё]+)*";
        return name.matches(nameRegex);
    }

    public static boolean stringFieldValidate(String stringField) {
        String regex = "[А-Яа-яёЁ]*[а-яё]+";
        return stringField.matches(regex);
    }

    /**
     * Метод вывода сообщения о результатах валидации
     * @param name название
     * @param supervisorName имя худрука
     * @param rating рейтинг
     * @return булево значение соответствия параметров допустимым значениям
     */
    public static String validateMessage(String name, String supervisorName, int rating, String firstSpecificField, String secondSpecificField) {
        String message = "";
        if (!paramsValidate(name, supervisorName, rating, firstSpecificField, secondSpecificField)) {
            if (!nameValidate(name))
                message += "Поле 1: Неверное название театра!\n";
            if (!personNameValidate(supervisorName))
                message += "Поле 2: Неверное имя художественного руководителя!\n";
            if (!ratingValidate(rating))
                message += "Поле 3: Рейтинг не может быть меньше 0 и больше 100!\n";
            if (!stringFieldValidate(firstSpecificField))
                message += "Поле 4: Введённое значение содержит недопустимые символы!\n";
            if (!personNameValidate(secondSpecificField))
                message += "Поле 5: Недопустимое значение для имени!";
        } else {
            message = "Все значения верны!";
        }
        return message;
    }
}
