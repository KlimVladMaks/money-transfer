package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.klimvlad.moneytransfer.api.ApiClient;

public class RegisterWindow implements Screen {
    private final Stage primaryStage;
    private final Runnable onBackRequest;
    private final ApiClient apiClient;
    
    public RegisterWindow(Stage primaryStage, Runnable onBackRequest) {
        this.primaryStage = primaryStage;
        this.onBackRequest = onBackRequest;
        this.apiClient = new ApiClient();
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

        // Описание
        Text descriptionLabel = new Text("Введите описание (например, ФИО и т.п.):");
        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Описание");
        descriptionField.setMaxWidth(200);
        
        // Кнопки
        Button createAccountButton = new Button("Создать новый аккаунт");
        createAccountButton.setPrefWidth(200);
        createAccountButton.setOnAction(e -> {
            // Проверка полей
            if (loginField1.getText().isEmpty() || loginField2.getText().isEmpty() || 
                passwordField1.getText().isEmpty() || passwordField2.getText().isEmpty()) {
                showAlert("Ошибка", "Все поля должны быть заполнены");
                return;
            }
            
            if (!loginField1.getText().equals(loginField2.getText())) {
                showAlert("Ошибка", "Логины не совпадают");
                return;
            }
            
            if (!passwordField1.getText().equals(passwordField2.getText())) {
                showAlert("Ошибка", "Пароли не совпадают");
                return;
            }
            
            // Отправка запроса
            try {
                String response = apiClient.registerUser(
                    loginField1.getText(),
                    passwordField1.getText(),
                    descriptionField.getText()
                );
                
                showAlert("Успех", "Аккаунт успешно создан: " + response);
                onBackRequest.run();
            } catch (Exception ex) {
                showAlert("Ошибка", "Не удалось создать аккаунт: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
        
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
            descriptionLabel, descriptionField,
            createAccountButton, cancelButton, goToLoginButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Регистрация");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
