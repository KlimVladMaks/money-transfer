package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterWindow implements Screen {
    private final Stage primaryStage;
    private final Runnable onBackRequest;
    
    public RegisterWindow(Stage primaryStage, Runnable onBackRequest) {
        this.primaryStage = primaryStage;
        this.onBackRequest = onBackRequest;
    }
    
    @Override
    public void show() {
        Text title = new Text("Регистрация");
        title.setFont(Font.font(24));
        
        // Логин
        Text loginLabel = new Text("Введите уникальный логин:");
        TextField loginField1 = new TextField();
        loginField1.setPromptText("Логин");
        loginField1.setMaxWidth(200);
        
        TextField loginField2 = new TextField();
        loginField2.setPromptText("Повторите логин");
        loginField2.setMaxWidth(200);
        
        HBox loginFields = new HBox(10, loginField1, loginField2);
        loginFields.setAlignment(Pos.CENTER);
        
        // Пароль
        Text passwordLabel = new Text("Введите пароль:");
        TextField passwordField1 = new TextField();
        passwordField1.setPromptText("Пароль");
        passwordField1.setMaxWidth(200);
        
        TextField passwordField2 = new TextField();
        passwordField2.setPromptText("Повторите пароль");
        passwordField2.setMaxWidth(200);
        
        HBox passwordFields = new HBox(10, passwordField1, passwordField2);
        passwordFields.setAlignment(Pos.CENTER);
        
        // Кнопки
        Button createAccountButton = new Button("Создать новый аккаунт");
        createAccountButton.setPrefWidth(200);
        
        Button cancelButton = new Button("Отменить");
        cancelButton.setPrefWidth(200);
        cancelButton.setOnAction(e -> onBackRequest.run());

        Button goToLoginButton = new Button("Войти в аккаунт");
        goToLoginButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px;");
        goToLoginButton.setOnMouseEntered(e -> goToLoginButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #004499; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: hand;"));
        goToLoginButton.setOnMouseExited(e -> goToLoginButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: default;"));
        
        VBox layout = new VBox(20, 
            title, 
            loginLabel, loginFields, 
            passwordLabel, passwordFields, 
            createAccountButton, cancelButton, goToLoginButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Регистрация");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
