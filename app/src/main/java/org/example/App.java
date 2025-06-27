package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application { // Наследуемся от Application

    @Override
    public void start(Stage primaryStage) {
        // Создаём метку с текстом "Hello World!"
        Label label = new Label("Hello World!");

        // Создаём сцену и добавляем метку
        Scene scene = new Scene(label, 300, 200);

        // Настраиваем окно
        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Запускаем JavaFX приложение
    }
}
