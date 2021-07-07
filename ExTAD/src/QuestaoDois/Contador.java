package QuestaoDois;

public class Contador implements IContador{
    private Integer n;

    @Override
    public void inicializar(int n) {
        this.n = n;
    }

    @Override
    public int acessar() {
        return n;
    }

    @Override
    public void incrementar() {
        n++;
    }

    @Override
    public void decrementar() {
        n--;
    }
}

