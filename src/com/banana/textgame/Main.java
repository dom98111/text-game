package com.banana.textgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    String[] доступныеЯзыки = {"java", "Kotlin", "JavaScript", "Ada", "Python"};
    Scanner клавиатура = new Scanner(System.in);
    User пользователь = new User();


    public static void main(String[] args) {
        // вызывает метод start()
        new Main().start();
    }

    /*
     * Метод с логикой игры.
     */
    private void start() {
        onStart();
        for (int i = 1; i <= 5; ++i) {
            onNewDay(i);
        }
        onFinish();
    }

    /*
     * Метод вызывается один раз при старте игры
     */
    void onStart() {
        System.out.println("Starting");
        Scanner клавиатура = new Scanner(System.in);
        System.out.println("Сколько тебе лет?");
        int возраст = Integer.parseInt(клавиатура.nextLine());
        System.out.println("Возраст " + возраст);
        String[] варианты =  {"Добрый день, представьтесь пожалуйста", "пупиу-пупиу, ваше имя?", "Как тебя зовут?"};
        int числоот0до2 = (int) (Math.random() * варианты.length);
        System.out.println(варианты[числоот0до2]);
        String имя = клавиатура.nextLine();
        System.out.println("Имя " + имя);
    }

    void onNewDay(int dayNumber) {
        System.out.println("day " + dayNumber);
        String smiles = "";
        for (int i=1; i <= пользователь.mood; i = i + 1) {
            smiles = smiles + "xD";
        }
        System.out.println("Ваше настроение: " + smiles);
        напечатайИзученныеЯзыки();
        System.out.println("компании, в которых работаете: " + пользователь.компании + ".");
        System.out.println("Что будем делать?");
        String action = клавиатура.nextLine();
        switch (action.toLowerCase()) {
            case "уволиться":
                уволитьсясРаботы();
            break;
            case "работа":
                найтиРаботу();
            break;
            case "изучить":
                изучитьЯзык();
            break;
            case "код":
                System.out.println("Введите код: ");
                String код = клавиатура.nextLine();
                код = код.replace(" ","");
                int заработок = код.length();
                пользователь.ОбщийЗаработок = пользователь.ОбщийЗаработок + заработок;
            break;
            case "шаверма":
                System.out.println("Окей, съелки шаверму");
            break;
            case "кости":
                броситьКости();
            break;
            case "пельмешки":
                System.out.println("Вы съели " + скушатьПельмешки() + "шт пельменей");
            break;
            case "ничего":
                System.out.println("Вы потратили время зря");
            break;
            case "скакалка":
                System.out.println("Окей, вы попрыгали на скакалке");
            default: System.out.println("Ошибка ввода");
        }

        System.out.println("Всего заработано " + пользователь.ОбщийЗаработок + "$.");


    }

    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {
        System.out.println("Finish" + "очков набрано: " + набранныеОчки());
    }

    // Действия

    void изучитьЯзык() {
        System.out.println("А Какой язык?");
        String выбранныйЯзык = клавиатура.nextLine();

        for (int i = 0; i < доступныеЯзыки.length; i++) {
            if (доступныеЯзыки[i].equals(выбранныйЯзык) && (пользователь.изученныеЯзыки[i] ==  false)
                    && пользователь.mood > 0
                    && пользователь.dollars >= 20) {
                пользователь.изученныеЯзыки[i] = true;
                пользователь.dollars -= 20;
                пользователь.mood -= 1;
            } else if (пользователь.mood == 0) {
                System.out.println("Вам слишком грустно");
            }
            else if (пользователь.dollars <= 0) {
                System.out.println("Вам слишком грустно");
            }
        }
    }

    void напечатайИзученныеЯзыки() {
        System.out.println("Вы знаете языки?");
        for (int i = 0; i < пользователь.изученныеЯзыки.length; i++) {
            if (пользователь.изученныеЯзыки[i] == true) {
                System.out.println(" - " + доступныеЯзыки[i]);
            }
        }
    }
    int скушатьПельмешки () {
        boolean количествоВведено = false;
        int количествоПельмешек = 0;
        while(количествоВведено == false) {
            System.out.println("Сколько пельмешек вы хотите скушать?");
            String строка = клавиатура.nextLine();
            try {
                количествоПельмешек = Integer.parseInt(строка);
                скушатьПельмешки(количествоПельмешек);
                количествоВведено = true;
            } catch (Exception e) {
                System.out.println("Введите цифры!");
            }
        }
            return количествоПельмешек;

    }
    void скушатьПельмешки (int количествоПельмешек) {
        пользователь.dollars = пользователь.dollars + количествоПельмешек * 5;
        пользователь.mood = пользователь.mood + 2 * количествоПельмешек;

    }

    int набранныеОчки () {
        int очки = пользователь.dollars * 2 + пользователь.mood * 6;
        for (int i = 0; i < пользователь.изученныеЯзыки.length; i++){
           if (пользователь.изученныеЯзыки[i] == true){
               очки = очки + 10;
           }
        }
        return очки;
    }
    void найтиРаботу() {
        System.out.println("В какой компании хотите работать?");
        String компания = клавиатура.nextLine();
        пользователь.компании.add(компания);

    }
    void уволитьсясРаботы() {
        System.out.println("С какой работы вы собираетсь уволиться?");
        String компания = клавиатура.nextLine();
        if (пользователь.компании.contains(компания) == true){
            пользователь.компании.remove(компания);
            System.out.println("Вы успешно уволились с работы!");
        }
        else {
            System.out.println("Вы там не работаете!");
        }
    }

    int броситьКости() {
        int число1 = (int) (Math.random() * 6 + 1);
        int число2 = (int) (Math.random() * 6 + 1);
        System.out.println("вам выпали: " + число1 + число2);
        if (Math.max(число1, число2) % 2 == 0) {
            System.out.println("Ура, вы выйграли!");
            пользователь.dollars = пользователь.dollars + 28;
        } else {
            System.out.println("Вы проиграли!");
            пользователь.dollars = пользователь.dollars - 50;
            }
        return число1;
    }
}
