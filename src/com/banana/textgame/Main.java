package com.banana.textgame;

public class Main {

    /*
     * Главный метод.
     */
    public static void main(String[] args) {
        // вызывает метод start()
        new Main().start();
    }         ~~                      с

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

    }

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {

    }

    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {

    }

}
