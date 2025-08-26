// Код оптимизации: 1

package me.klimvlad.moneytransfer;

import javafx.application.Application;
import javafx.stage.Stage;
import me.klimvlad.moneytransfer.screens.BalanceWindow;
import me.klimvlad.moneytransfer.screens.LoginWindow;
import me.klimvlad.moneytransfer.screens.MainMenu;
import me.klimvlad.moneytransfer.screens.RegisterWindow;
import me.klimvlad.moneytransfer.screens.Screen;

public class App extends Application {
    private Stage primaryStage;
    private Screen currentScreen;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMainMenu();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showMainMenu() {
        changeScreen(new MainMenu(primaryStage, this::showLoginWindow, this::showRegisterWindow));
    }

    private void showRegisterWindow() {
        changeScreen(new RegisterWindow(primaryStage, this::showMainMenu));
    }

    private void showLoginWindow() {
        changeScreen(new LoginWindow(primaryStage, this::showMainMenu, this::showBalanceWindow));
    }

    private void showBalanceWindow() {
        changeScreen(new BalanceWindow(primaryStage, this::showMainMenu));
    }

    private void changeScreen(Screen newScreen) {
        if (currentScreen != null) {
            currentScreen.close();
        }

        currentScreen = newScreen;
        currentScreen.show();
    }
}
