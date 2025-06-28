package me.klimvlad.moneytransfer.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu implements Screen {
    private final Stage primaryStage;
    private final Runnable onRegisterRequest;
    
    public MainMenu(Stage primaryStage, Runnable onRegisterRequest) {
        this.primaryStage = primaryStage;
        this.onRegisterRequest = onRegisterRequest;
    }
    
    @Override
    public void show() {
        Text title = new Text("MoneyTransfer");
        title.setFont(Font.font(24));
        
        Button loginButton = new Button("Войти");
        loginButton.setPrefWidth(200);
        
        Button registerButton = new Button("Зарегистрироваться");
        registerButton.setPrefWidth(200);
        
        VBox layout = new VBox(20, title, loginButton, registerButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoneyTransfer - Главное меню");
        primaryStage.setResizable(false);
        primaryStage.show();
        
        registerButton.setOnAction(e -> onRegisterRequest.run());
    }
}
