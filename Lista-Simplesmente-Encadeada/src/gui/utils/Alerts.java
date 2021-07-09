package gui.utils;

import gui.BoardController;
import javafx.scene.control.Alert;

public class Alerts {
    public static void gameOver(BoardController.Animate clock) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("GAME OVER");
        alert.setHeaderText(null);
        alert.setContentText("Você Perdeu :/");
        alert.setOnHidden(evt -> clock.start());
        alert.show();
    }
}
