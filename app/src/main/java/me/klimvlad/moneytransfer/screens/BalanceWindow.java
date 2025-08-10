package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
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

        VBox layout = new VBox(20, title);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Баланс");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
