package me.klimvlad.moneytransfer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
    private Stage primaryStage;
    
    public MainMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void show() {
        // Создаем элементы интерфейса
        Text title = new Text("MoneyTransfer");
        title.setFont(Font.font(24));
        
        Button loginButton = new Button("Войти");
        loginButton.setPrefWidth(200);
        
        Button registerButton = new Button("Зарегистрироваться");
        registerButton.setPrefWidth(200);
        
        // Располагаем элементы вертикально
        VBox layout = new VBox(20, title, loginButton, registerButton);
        layout.setAlignment(Pos.CENTER);
        
        // Настройка сцены и отображение
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer");
        primaryStage.show();
        
        // Обработчики событий для кнопок
        loginButton.setOnAction(e -> {
            // Здесь будет переход к окну входа
            System.out.println("Login");
        });
        
        registerButton.setOnAction(e -> {
            // Здесь будет переход к окну регистрации
            System.out.println("Register");
        });
    }
}
