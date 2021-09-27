package gui;

import gui.utils.Alerts;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.entities.Board;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    private final Circle SNAKE_HEAD = new Circle(50, 50, 15, Color.web("8E09E0"));
    private Board board = new Board();
    private final InputStream input = this.getClass().getResourceAsStream("/gui/utils/img/purpleapple.png");
    private final Image image = new Image(input, 40, 40, false, true);
    private final ImageView imageView = new ImageView(image);
    private Animate clock;

    @FXML
    private Label points, highscore;

    @FXML
    private GridPane gridPane;

    @FXML
    public void onKeyPressedHandle(KeyEvent e) {
        if (e.getCode() == KeyCode.W && board.getDirection() != 'S') {
            board.setDirection('W');
        } else if (e.getCode() == KeyCode.A && board.getDirection() != 'D') {
            board.setDirection('A');
        } else if (e.getCode() == KeyCode.S && board.getDirection() != 'W') {
            board.setDirection('S');
        } else if (e.getCode() == KeyCode.D && board.getDirection() != 'A') {
            board.setDirection('D');
        } else if (e.getCode() == KeyCode.SPACE) {
            clock.stop();
        }
    }

    @FXML
    public void onKeyRelesed(KeyEvent e) {
        if (e.getCode() == KeyCode.SPACE) {
            clock.start();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gridPane.setFocusTraversable(true);
        clock = new Animate();
        clock.start();
    }

    private void setHighscore() {
        if (Integer.parseInt(points.getText()) > Integer.parseInt(highscore.getText())) {
            highscore.setText(points.getText());
        }
    }

    private void restart() {
        board = new Board();
    }

    public class Animate extends AnimationTimer {
        private long last = 0;

        @Override
        public void handle(long now) {
            long FRAMES_PER_SEC = 11L;
            long INTERVAL = 1000000000L / FRAMES_PER_SEC;
            if (now - last > INTERVAL) {
                //clean the grid
                gridPane.getChildren().clear();

                gridPane.add(imageView, board.getFruit().getFruitPos().getxPos(), board.getFruit().getFruitPos().getyPos());


                //update and draw snake
                board.move();
                gridPane.add(SNAKE_HEAD, board.getSnake().getSnakeBody().buscar(0).getxPos(), board.getSnake().getSnakeBody().buscar(0).getyPos());

                //update points
                points.setText(String.valueOf(board.getSnake().getSnakeBody().tamanho() - 1));

                //Draw snake tail
                for (int i = 1; i < board.getSnake().getSnakeBody().tamanho(); i++) {
                    gridPane.add(new Circle(13, Color.web("4205B6")), board.getSnake().getSnakeBody().buscar(i).getxPos(), board.getSnake().getSnakeBody().buscar(i).getyPos());
                }
                //check collision before continuing
                if (board.checkCollision()) {
                    clock.stop();
                    setHighscore();
                    Alerts.gameOver(clock);
                    restart();
                }
                last = now;
            }
        }
    }
}