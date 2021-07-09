package model.entities;

import lib.ListaEncadeada;

public class Snake {
    private ListaEncadeada<Position> tail = new ListaEncadeada<>();
    private Position pos;

    public Snake() {
        this.pos = new Position(2, 15 / 2);
        tail.adicionarInicio(pos);
        grow(1, 15/2);
    }

    public void grow(int x, int y) {
        tail.adicionar(new Position(x, y));
    }

    public ListaEncadeada<Position> getSnakeBody() {
        return tail;
    }

}
