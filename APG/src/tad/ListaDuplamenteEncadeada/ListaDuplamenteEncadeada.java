package tad.ListaDuplamenteEncadeada;


public class ListaDuplamenteEncadeada<T> {

    private No<T> head;
    private No<T> tail;
    private Integer size = 0;

    public void adicionarInicio(T dado) {
        No<T> novoNo = new No<>(dado);

        novoNo.proximo  = head;
        novoNo.anterior = null;

        if (head != null)
            head.anterior = novoNo;

        head = novoNo;

        if (tail == null)
            tail = novoNo;
        size++;
    }

    public void adicionarFim(T dado){

        No<T> novoNo = new No<>(dado);
        No<T> ultimo = head;

        novoNo.proximo = null;
        if (tail != null)
            tail.proximo = novoNo;
        tail = novoNo;

        if(head == null) {
            head = novoNo;
        }else {


            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }

            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
        }
        size++;
    }

    public void remove(No<T> no){

        if (head == null || no == null)
            return;

        if (head == no)
            head = no.proximo;

        if (no.proximo != null)
            no.proximo.anterior = no.anterior;


        if (no.anterior != null)
            no.anterior.proximo = no.proximo;


        size--;
    }


    public No<T> getPrimeiro(){return head;}

    public No<T> get(Integer index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index fora de limite!");
        }else{
            No<T> aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.proximo;
            }
            return aux;
        }
    }

    public Integer size(){
        return this.size;
    }

}
