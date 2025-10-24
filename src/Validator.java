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
    public static boolean paramsValidate(String name, String supervisorName, int rating) {
        return nameValidate(name) && supervisorNameValidate(supervisorName) && ratingValidate(rating);
    }

    /**
     * Метод проверки имени художественного руководителя
     * @param supervisorName имя худрука
     * @return значение соответствия имени
     */
    public static boolean supervisorNameValidate(String supervisorName) {
        String nameRegex = "[А-ЯЁ][а-яё]+(\\s[А-ЯЁ][а-яё]+)*";
        return supervisorName.matches(nameRegex);
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

    /**
     * Метод вывода сообщения о результатах валидации
     * @param name название
     * @param supervisorName имя худрука
     * @param rating рейтинг
     * @return булево значение соответствия параметров допустимым значениям
     */
    public static String validateMessage(String name, String supervisorName, int rating) {
        String message = "";
        if (!paramsValidate(name, supervisorName, rating)) {
            if (!nameValidate(name))
                message += "Неверное название театра!\n";
            if (!supervisorNameValidate(supervisorName))
                message += "Неверное имя художественного руководителя!\n";
            if (!ratingValidate(rating))
                message += "Рейтинг не может быть меньше 0 и больше 100!\n";
        } else {
            message = "Все значения верны!";
        }
        return message;
    }
}
