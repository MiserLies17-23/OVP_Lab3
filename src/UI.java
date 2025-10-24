import java.util.Scanner;

/**
 * Класс взаимодействия с пользователем
 */
public class UI {

    /** Поле класса - объект класса Scanner */
    private static Scanner _sc;

    /**
     * Конструктор по умолчанию
     */
    UI() {
       _sc = new Scanner(System.in);
    }

    /**
     * Выводит информационное сообщение в начале работы программы
     */
    private void getInformationMessage() {
        System.out.println("Лабораторная работа №3");
        System.out.println("Бригада 13: Медведев А., Толстоухов В.");
        System.out.println("Вариант 13: Театры\n");
    }

    /**
     * Выводит список возможностей приложения
     */
    private void menu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить театр");
        System.out.println("2. Вывести все театры");
        System.out.println("3. Поиск театра по имени художественного руководителя");
        System.out.println("4. Определить театр с самым большим рейтингом");
        System.out.println("5. Сортировать театры по названию в обратном порядке");
        System.out.println("6. Выбрать театр");
        System.out.println("Для выхода введите пустую строку...");
        System.out.print("Ваше действие: ");
    }

    /**
     * Метод взаимодействия с пользователем
     */
    public void run() {
        getInformationMessage();

            menu();
            String choice = _sc.nextLine();
            while (!choice.isEmpty()) {
                try {
                    switch (choice) {
                        case "1":
                            addNewTheatre();
                            break;
                        case "2":
                            System.out.print(Theatre.showAll());
                            break;
                        case "3":
                            findBySupervisor();
                            break;
                        case "4":
                            determineTheHighestRating();
                            break;
                        case "5":
                            System.out.print(Theatre.sortByNameReverse());
                            break;
                        case "6" :
                            interactionWithTheatre();
                            break;
                        default:
                            System.out.println("Действие не распознано!\n");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка ввода данных: " + e.getMessage());
                }
                menu();
                choice = _sc.nextLine();
            }
            System.out.println("Вы вышли из программы!");

    }

    /**
     * Инициирует добавление нового театра
     */
    private void addNewTheatre() {
        System.out.println("Выберите тип театра: ");
        System.out.println("1 - драматический: ");
        System.out.println("2 - музыкальный: ");
        System.out.print("Ваш выбор: ");
        String input = _sc.nextLine();

        if (input.equals("1")) {
            addDramaTheatreMenu();
        } else if (input.equals("2")){
            addMusicTheatreMenu();
        } else {
            System.out.println("Тип театра указан неверно!\n");
        }
    }

    /**
     * Метод, инициирующий поиск театра по имени художественного руководителя
     */
    private void findBySupervisor() {
        if (!Theatre._array.isEmpty()) {
            System.out.print("Введите имя художественного руководителя: ");
            System.out.println(Theatre.findBySupervisorName(_sc.nextLine()));
        } else {
            System.out.println("Действие невозможно: список пуст!\n");
        }
    }

    /**
     * Метод взаимодействия с театрами
     */
    private void interactionWithTheatre() {
        if (!Theatre._array.isEmpty()) {
            System.out.println(Theatre.showAll());
            System.out.print("Выберите театр: ");
            int index = Integer.parseInt(_sc.nextLine());
            if (1 <= index && index <= Theatre.getSize()) {
                System.out.println("Выберите действие: ");
                System.out.println("1. Посмотреть информацию о театре");
                System.out.println("2. Редактировать данные о театре");
                System.out.println("Для возвращения введите пустую строку...");
                System.out.print("Ваше действие: ");
                String choice = _sc.nextLine();
                if (choice.equals("1")) {
                    System.out.println(Theatre.findByIndex(index - 1));
                } else if (choice.equals("2")) {
                    fieldReplacement(index-1);
                } else {
                    System.out.println("Указан неверный номер театра!\n");
                }
            } else {
                System.out.println("Действие невозможно: список пуст!\n");
            }
        }
    }

    /**
     * Метод, инициирующий поиск театра с самым высоким рейтингом
     */
    private void determineTheHighestRating() {
        if (!Theatre._array.isEmpty()) {
            System.out.println(Theatre.getHighestRating());
        } else {
            System.out.println("Действие невозможно: список пуст!\n");
        }
    }

    /**
     * Метод, инициирующий добавление нового драматического театра
     */
    private void addDramaTheatreMenu() {
        System.out.print("Введите название театра: ");
        String name = _sc.nextLine();
        System.out.print("Введите имя руководителя: ");
        String supervisorName = _sc.nextLine();
        System.out.print("Введите рейтинг: ");
        int rating = Integer.parseInt(_sc.nextLine());
        System.out.print("Введите страну: ");
        String country = _sc.nextLine();
        System.out.print("Введите жанр: ");
        String genre = _sc.nextLine();
        if (Validator.paramsValidate(name, supervisorName, rating)) {
            Theatre.addDramaTheatre(name, supervisorName,  rating, country, genre);
            System.out.println("Драматический театр успешно добавлен!\n");
        } else {
            System.out.println("Драматический театр не может быть добавлен! Ошибки:\n" +
                    Validator.validateMessage(name, supervisorName, rating));
        }
    }

    /**
     * Метод, инициирующий добавление нового музыкального театра
     */
    private void addMusicTheatreMenu() {
        System.out.print("Введите название театра: ");
        String name = _sc.nextLine();
        System.out.print("Введите имя руководителя: ");
        String supervisorName = _sc.nextLine();
        System.out.print("Введите рейтинг: ");
        int rating = Integer.parseInt(_sc.nextLine());
        System.out.print("Введите страну: ");
        String country = _sc.nextLine();
        System.out.print("Введите музыкального директора: ");
        String musicDirector = _sc.nextLine();
        if (Validator.paramsValidate(name, supervisorName, rating)) {
            Theatre.addMusicTheatre(name, supervisorName, rating, country, musicDirector);
            System.out.println("Музыкальный театр успешно добавлен!\n");
        } else {
            System.out.println("Музыкальный театр не может быть добавлен! Ошибки:\n" +
                    Validator.validateMessage(name, supervisorName, rating));
        }
    }

    /**
     * Метод взаимодействия с заменой полей
     * @param index индекс элемента списка
     */
    private void fieldReplacement(int index) {
        System.out.println("Выберите поле для изменения: ");
        System.out.print(Theatre._array.get(index).fieldInformation());
        System.out.print("Ваш выбор: ");
        String choice = _sc.nextLine();
        switch(choice) {
            case "1":
                System.out.print("Введите новое название: ");
                String newName = _sc.nextLine();
                System.out.println(Theatre._array.get(index).getNewName(newName));
                break;
            case "2":
                System.out.print("Введите новое имя: ");
                String newSupervisorName = _sc.nextLine();
                System.out.println(Theatre._array.get(index).getNewSupervisor(newSupervisorName));
                break;
            case "3":
                System.out.print("Введите новый рейтинг: ");
                int newRating = Integer.parseInt(_sc.nextLine());
                System.out.println(Theatre._array.get(index).getNewRating(newRating));
                break;
            case "4":
                System.out.print("Введите новый значение: ");
                String newMeaning1 = _sc.nextLine();
                System.out.println(Theatre._array.get(index).getNewFirstSpecificField(newMeaning1));
                break;
            case "5":
                System.out.print("Введите новый значение: ");
                String newMeaning2 = _sc.nextLine();
                System.out.println(Theatre._array.get(index).getNewSecondSpecificField(newMeaning2));
                break;
        }
    }
}
