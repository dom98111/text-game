package com.banana.textgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
     * Главный метод.
     */
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



    /* ГЛОБАЛЬНЫЕ ПЕРЕМЕННЫЕ */
    String[] доступныеЯзыки = {"java", "Kotlin", "JavaScript", "Ada", "Python"};
    boolean[] изученныеЯзыки = {true, false, true, false, false};
    Scanner клавиатура = new Scanner(System.in);
    int dollars = 0;


    int ОбщийЗаработок = 0;
    int mood = 3;
    ArrayList<String> компании = new ArrayList<>();
     /* Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня
     */
    void onNewDay(int dayNumber) {
        System.out.println("day " + dayNumber);
        String smiles = "";
        for (int i=1; i <= mood; i = i + 1) {
            smiles = smiles + "xD";
        }
        System.out.println("Ваше настроение: " + smiles);
        напечатайИзученныеЯзыки();
        System.out.println("компании, в которых работаете: " + компании + ".");
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
                ОбщийЗаработок = ОбщийЗаработок + заработок;
            break;
            case "шаверма":
                System.out.println("Окей, съелки шаверму");
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

        System.out.println("Всего заработано " + ОбщийЗаработок + "$.");


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
            if (доступныеЯзыки[i].equals(выбранныйЯзык) && (изученныеЯзыки[i] ==  false)
                    && mood > 0
                    && dollars >= 20) {
                изученныеЯзыки[i] = true;
                dollars -= 20;
                mood -= 1;
            } else if (mood == 0) {
                System.out.println("Вам слишком грустно");
            }
            else if (dollars <= 0) {
                System.out.println("Вам слишком грустно");
            }
        }
    }

    void напечатайИзученныеЯзыки() {
        System.out.println("Вы знаете языки?");
        for (int i = 0; i < изученныеЯзыки.length; i++) {
            if (изученныеЯзыки[i] == true) {
                System.out.println(" - " + доступныеЯзыки[i]);
            }
        }
    }
    int скушатьПельмешки () {
        System.out.println("Сколько пельмешек вы хотите скушать?");
        int количествоПельмешек = клавиатура.nextInt();
        скушатьПельмешки(количествоПельмешек);
        return количествоПельмешек;
    }
    void скушатьПельмешки (int количествоПельмешек) {
        dollars = dollars + количествоПельмешек * 5;
        mood = mood + 2 * количествоПельмешек;

    }

    int набранныеОчки () {
        int очки = dollars * 2 + mood * 6;
        for (int i = 0; i < изученныеЯзыки.length; i++){
           if (изученныеЯзыки[i] == true){
               очки = очки + 10;
           }
        }
        return очки;
    }
    void найтиРаботу() {
        System.out.println("В какой компании хотите работать?");
        String компания = клавиатура.nextLine();
        компании.add(компания);

    }
    void уволитьсясРаботы() {
        System.out.println("С какой работы вы собираетсь уволиться?");
        String компания = клавиатура.nextLine();
        if (компании.contains(компания) == true){
            компании.remove(компания);
            System.out.println("Вы успешно уволились с работы!");
        }
        else {
            System.out.println("Вы там не работаете!");
        }
    }
}
