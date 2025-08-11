package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.klimvlad.moneytransfer.api.ApiClient;
import me.klimvlad.moneytransfer.api.SessionManager;
import org.json.JSONObject;

public class LoginWindow implements Screen {
    private final Stage primaryStage;
    private final Runnable onBackRequest;
    private final Runnable onBalanceRequest;
    private final ApiClient apiClient;
    private final SessionManager sessionManager;
    
    public LoginWindow(Stage primaryStage, Runnable onBackRequest, Runnable onBalanceRequest) {
        this.primaryStage = primaryStage;
        this.onBackRequest = onBackRequest;
        this.onBalanceRequest = onBalanceRequest;
        this.apiClient = new ApiClient();
        this.sessionManager = SessionManager.getInstance();
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
        
        // Сообщение об ошибке
        Text errorMessage = new Text();
        errorMessage.setStyle("-fx-fill: red;");
        
        // Кнопки
        Button loginButton = new Button("Войти в аккаунт");
        loginButton.setPrefWidth(200);
        loginButton.setOnAction(e -> {
            String login = loginField.getText();
            String password = passwordField.getText();
            
            if (login.isEmpty() || password.isEmpty()) {
                errorMessage.setText("Логин и пароль не могут быть пустыми");
                return;
            }
            
            try {
                String response = apiClient.loginUser(login, password);
                JSONObject jsonResponse = new JSONObject(response);
                
                if (jsonResponse.has("sessionId")) {
                    String sessionId = jsonResponse.getString("sessionId");
                    sessionManager.setSessionId(sessionId);
                    onBalanceRequest.run();
                } else {
                    errorMessage.setText("Ошибка авторизации: неверный логин или пароль");
                }
            } catch (Exception ex) {
                errorMessage.setText("Ошибка соединения с сервером");
                ex.printStackTrace();
            }
        });
        
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
            errorMessage,
            loginButton, cancelButton, goToRegisterButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Вход");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
