package me.klimvlad.moneytransfer;

import javafx.application.Application;
import javafx.stage.Stage;
import me.klimvlad.moneytransfer.screens.MainMenu;
import me.klimvlad.moneytransfer.screens.RegisterWindow;
import me.klimvlad.moneytransfer.screens.LoginWindow;

public class App extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMainMenu();
    }

    private void showMainMenu() {
        MainMenu mainMenu = new MainMenu(primaryStage, this::showLoginWindow, this::showRegisterWindow);
        mainMenu.show();
    }

    private void showRegisterWindow() {
        RegisterWindow registerWindow = new RegisterWindow(primaryStage, this::showMainMenu);
        registerWindow.show();
    }

    private void showLoginWindow() {
        LoginWindow loginWindow = new LoginWindow(primaryStage, this::showMainMenu);
        loginWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
