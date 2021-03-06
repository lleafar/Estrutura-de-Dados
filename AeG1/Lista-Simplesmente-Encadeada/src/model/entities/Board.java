package model.entities;

public class Board {
    private final Integer boxSize = 16;
    private final Snake snake = new Snake();
    private Fruit fruit = new Fruit(boxSize);
    private char direction = 'D';
    private char flag;


    public Board() {
        generateApple();
    }

    private void setObjectPosition(Object obj, Position pos) {
        if (obj instanceof Snake) {
            snake.getSnakeBody().buscar(0).setxPos(pos.getxPos());
            snake.getSnakeBody().buscar(0).setyPos(pos.getyPos());
            eat();
        } else if (obj instanceof Fruit) {
                fruit.setFruitPos(pos);
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void move() {
        for (int i = snake.getSnakeBody().tamanho() - 1; i > 0; i--) {
            snake.getSnakeBody().buscar(i).setxPos(snake.getSnakeBody().buscar(i - 1).getxPos());
            snake.getSnakeBody().buscar(i).setyPos(snake.getSnakeBody().buscar(i - 1).getyPos());
        }
        switch (direction) {
            case 'W':
                if (snake.getSnakeBody().buscar(0).getyPos() - 1 < 0) {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().buscar(0).getxPos(), 15));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().buscar(0).getxPos(), snake.getSnakeBody().buscar(0).getyPos() - 1));
                }
                break;
            case 'A':
                if (snake.getSnakeBody().buscar(0).getxPos() - 1 < 0) {
                    setObjectPosition(snake, new Position(15, snake.getSnakeBody().buscar(0).getyPos()));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().buscar(0).getxPos() - 1, snake.getSnakeBody().buscar(0).getyPos()));
                }
                break;
            case 'S':
                if (snake.getSnakeBody().buscar(0).getyPos() + 1 > 15) {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().buscar(0).getxPos(), 0));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().buscar(0).getxPos(), snake.getSnakeBody().buscar(0).getyPos() + 1));
                }
                break;
            case 'D':
                if (snake.getSnakeBody().buscar(0).getxPos() + 1 > 15) {
                    setObjectPosition(snake, new Position(0, snake.getSnakeBody().buscar(0).getyPos()));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().buscar(0).getxPos() + 1, snake.getSnakeBody().buscar(0).getyPos()));
                }
                break;
        }

        flag = direction;
    }

    public void setDirection(char c) {
        this.direction = c;
    }

    public char getDirection() {
        return flag;
    }

    public boolean checkCollision() {
        for (int i = 1; i < snake.getSnakeBody().tamanho(); i++) {
            if ((snake.getSnakeBody().buscar(i).getxPos().equals(snake.getSnakeBody().buscar(0).getxPos())) && (snake.getSnakeBody().buscar(i).getyPos().equals(snake.getSnakeBody().buscar(0).getyPos()))) {
                return true;
            }
        }
        return false;
    }

    private void generateApple() {
        setObjectPosition(fruit, new Position(fruit.getRandomX(), fruit.getRandomY()));
    }

    private void eat() {
        if (snake.getSnakeBody().buscar(0).getxPos().equals(fruit.getFruitPos().getxPos()) && snake.getSnakeBody().buscar(0).getyPos().equals(fruit.getFruitPos().getyPos())) {
            generateApple();
            snake.grow(snake.getSnakeBody().buscar(snake.getSnakeBody().tamanho() - 1).getxPos(), snake.getSnakeBody().buscar(snake.getSnakeBody().tamanho() - 1).getyPos());
        }
    }


}
