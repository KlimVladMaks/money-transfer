package me.klimvlad.moneytransfer;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создаем и показываем главное меню
        MainMenu mainMenu = new MainMenu(primaryStage);
        mainMenu.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
