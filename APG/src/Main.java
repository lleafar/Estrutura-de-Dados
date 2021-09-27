import tad.ListaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import utils.Popular;
import utils.Testes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Váriaveis locais
        Popular popular   = new Popular();
        String  curso     = "Engenharia de Software";
        Integer matricula = 202060000;
        Long    inicio;
        Long    fim;

        //Váriaveis de Tempo de execução da Lista duplamente encadeada
        Long    insert_time_lde;
        Long    search_time_lde;
        Long    remove_time_lde;
        Long    show_time_lde;


        //Estruturas de Dados
        ListaDuplamenteEncadeada<Map<Integer, String>> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<>();


        //Popular listas
        inicio = System.nanoTime();
        listaDuplamenteEncadeada = popular.getLDE();
        fim = System.nanoTime();
        insert_time_lde = fim - inicio;


        //Apresentar
        inicio = System.nanoTime();
        fim = System.nanoTime();
        show_time_lde = fim - inicio;

        //Pesquisar
        inicio = System.nanoTime();
        Integer qntd_estudantes_es = Testes.pesquisar(listaDuplamenteEncadeada, curso);
        fim = System.nanoTime();
        search_time_lde = fim - inicio;


        //Remover
        System.out.println(listaDuplamenteEncadeada.size());
        inicio = System.nanoTime();
        Testes.remover(listaDuplamenteEncadeada, matricula);
        fim = System.nanoTime();
        remove_time_lde = fim - inicio;
        System.out.println(listaDuplamenteEncadeada.size());

        //Tempo de execução
        System.out.println("----------------------------------");
        System.out.println("Lista duplamente encadeada");
        System.out.println("Inserção:  " + insert_time_lde);
        System.out.println("Pesquisa:  " + search_time_lde);
        System.out.println("Remover:   " + remove_time_lde);
        System.out.println("Apresenta: " + show_time_lde);
        System.out.println("----------------------------------");

    }


}

