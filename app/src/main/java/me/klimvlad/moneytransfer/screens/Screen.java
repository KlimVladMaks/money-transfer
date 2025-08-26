// Код оптимизации: 1

package me.klimvlad.moneytransfer.screens;

import javafx.scene.Scene;

public interface Screen {
    Scene getScene();
    default void onShow() {}
    default void onHide() {}
}
