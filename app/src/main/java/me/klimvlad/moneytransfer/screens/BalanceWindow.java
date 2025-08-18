package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BalanceWindow implements Screen {
    private final Stage primaryStage;

    public BalanceWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void show() {
        Text title = new Text("Баланс");
        title.setFont(Font.font(24));

        Button logoutButton = new Button("Выйти из аккаунта");
        logoutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px;");
        logoutButton.setOnMouseEntered(e -> logoutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #004499; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: hand;"));
        logoutButton.setOnMouseExited(e -> logoutButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #0066cc; -fx-underline: true; -fx-font-size: 12px; -fx-cursor: default;"));

        VBox layout = new VBox(20, title, logoutButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Баланс");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
