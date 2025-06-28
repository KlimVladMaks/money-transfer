package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        
        Button backButton = new Button("Назад");
        backButton.setOnAction(e -> onBackRequest.run());
        
        VBox layout = new VBox(20, title, backButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Регистрация");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
