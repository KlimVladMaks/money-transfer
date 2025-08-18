package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.klimvlad.moneytransfer.api.ApiClient;
import me.klimvlad.moneytransfer.api.SessionManager;

public class BalanceWindow implements Screen {
    private final Stage primaryStage;
    private Runnable onMainMenuRequest;
    private final ApiClient apiClient;

    public BalanceWindow(Stage primaryStage, Runnable onMainMenuRequest) {
        this.primaryStage = primaryStage;
        this.onMainMenuRequest = onMainMenuRequest;
        this.apiClient = new ApiClient();
    }

    @Override
    public void show() {
        Text title = new Text("Баланс");
        title.setFont(Font.font(24));

        Button logoutButton = new Button("Выйти из аккаунта");
        logoutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px;");
        logoutButton.setOnMouseEntered(e -> logoutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #004499; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: hand;"));
        logoutButton.setOnMouseExited(e -> logoutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: default;"));

        logoutButton.setOnAction(e -> {
            String sessionId = SessionManager.getInstance().getSessionId();

            if (sessionId == null || sessionId.isEmpty()) {
                // Если сессии нет, просто переходим на главный экран
                onMainMenuRequest.run();
            }

            try {
                String response = apiClient.logoutUser(sessionId);
                
                if (response.equals("Logged out successfully")) {
                    // Очищаем сессию
                    SessionManager.getInstance().setSessionId(null);
                    // Переходим на главный экран
                    onMainMenuRequest.run();
                } else {
                    // Если сервер вернул что-то неожиданное, всё равно очищаем сессию
                    SessionManager.getInstance().setSessionId(null);
                    onMainMenuRequest.run();
                }
            } catch (Exception ex) {
                // В случае ошибки соединения всё равно очищаем сессию локально
                SessionManager.getInstance().setSessionId(null);
                onMainMenuRequest.run();
                ex.printStackTrace();
            }
        });

        VBox layout = new VBox(20, title, logoutButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Баланс");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
