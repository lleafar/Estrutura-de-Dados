package lib;

public class ListaEncadeada<T> implements IListaEncadeada<T> {
    private No<T> cabeca;
    private Integer size = 0;

    @Override
    public void adicionarInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.proximo = cabeca;
        cabeca = novoNo;
        size++;
    }

    @Override
    public void adicionar(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.proximo = null;

        size++;

        if(cabeca == null) {
            cabeca = novoNo;
        }
        else{
            No<T> ultimo = cabeca;
            while(ultimo.proximo != null){
                ultimo = ultimo.proximo;
            }

            ultimo.proximo = novoNo;
        }
    }

    @Override
    public void remover(T dado) {
        No<T> noAtual = cabeca;

        while(noAtual != null){
            if (noAtual.proximo.dado == dado){
                noAtual.proximo = noAtual.proximo.proximo;
                size--;
                break;
            }
            noAtual = noAtual.proximo;
        }

    }

    @Override
    public String exibirTodos() {
        No<T> noAtual = cabeca;
        String str = "ListaEncadeada: ";

        while(noAtual != null){
            str += noAtual.dado + " ";
            noAtual = noAtual.proximo;
        }

        return str;
    }

    @Override
    public T retornaPrimeiro() {
        return cabeca.dado;
    }

    @Override
    public T retornaUltimo() {
        No<T> noAtual = cabeca;

        while(noAtual != null){
            if (noAtual.proximo == null){
                return noAtual.dado;
            }
            noAtual = noAtual.proximo;
        }

        return null;
    }

    @Override
    public T proximo(T dado){
        No<T> noAtual = cabeca;

        while(noAtual != null){
           if (noAtual.dado == dado){
               return noAtual.proximo.dado;
           }
            noAtual = noAtual.proximo;
        }

        return  null;
    }

    @Override
    public int tamanho(){
        return size;
    }

    @Override
    public T buscar(int indice){
        if(indice >= 0 && indice < size){
            No<T> noAtual = cabeca;
            int i = 0;

            while(noAtual != null){
                if(i == indice){
                    return noAtual.dado;
                }
                noAtual = noAtual.proximo;
                i++;
            }

        }

        throw new IndexOutOfBoundsException("Index out of bounds!");
    }


}
