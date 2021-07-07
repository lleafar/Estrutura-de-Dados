package QuestaoDois;

public class Main {
    public static void main(String[]args){
        Contador contador = new Contador();

        contador.inicializar(5);
        System.out.println("Valor Inicial: " + contador.acessar());

        contador.incrementar();
        System.out.println("Incrementado uma vez: " + contador.acessar());

        contador.decrementar();
        contador.decrementar();
        System.out.println("Decrementado duas vezes:" + contador.acessar());
    }
}
