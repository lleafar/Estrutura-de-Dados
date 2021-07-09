package lib;

public class No<T> {
     T dado;
     No<T> proximo;

    No(T d) {
        dado = d;
        proximo = null;
    }
}


