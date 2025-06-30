package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginWindow implements Screen {
    private final Stage primaryStage;
    private final Runnable onBackRequest;
    
    public LoginWindow(Stage primaryStage, Runnable onBackRequest) {
        this.primaryStage = primaryStage;
        this.onBackRequest = onBackRequest;
    }
    
    @Override
    public void show() {
        Text title = new Text("Вход");
        title.setFont(Font.font(24));
        
        // Логин
        Text loginLabel = new Text("Введите ваш логин:");
        TextField loginField = new TextField();
        loginField.setPromptText("Логин");
        loginField.setMaxWidth(200);
        
        // Пароль
        Text passwordLabel = new Text("Введите ваш пароль:");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Пароль");
        passwordField.setMaxWidth(200);
        
        // Кнопки
        Button loginButton = new Button("Войти в аккаунт");
        loginButton.setPrefWidth(200);
        
        Button cancelButton = new Button("Отменить");
        cancelButton.setPrefWidth(200);
        cancelButton.setOnAction(e -> onBackRequest.run());

        // Кнопка регистрации в стиле ссылки
        Button goToRegisterButton = new Button("Зарегистрироваться");
        goToRegisterButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px;");
        goToRegisterButton.setOnMouseEntered(e -> goToRegisterButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #004499; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: hand;"));
        goToRegisterButton.setOnMouseExited(e -> goToRegisterButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: default;"));
        
        VBox layout = new VBox(20, 
            title, 
            loginLabel, loginField, 
            passwordLabel, passwordField, 
            loginButton, cancelButton, goToRegisterButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Вход");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
