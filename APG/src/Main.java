import tad.ListaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import tad.BinaryTree.*;

import utils.Popular;
import utils.Testes;
import utils.Estudante;

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
        ListaDuplamenteEncadeada<Map<Integer, String>> lde = new ListaDuplamenteEncadeada<>();
        lde = Testes.ordenar(listaDuplamenteEncadeada);
        Testes.print(lde);
        fim = System.nanoTime();
        show_time_lde = fim - inicio;


        System.out.println("print concluído!");

        //Pesquisar
        inicio = System.nanoTime();
        Integer qntd_estudantes_es = Testes.pesquisar(listaDuplamenteEncadeada, curso);
        fim = System.nanoTime();
        search_time_lde = fim - inicio;

        System.out.println("pesquisa concluída");
        //Remover
        inicio = System.nanoTime();
        Testes.remover(listaDuplamenteEncadeada, matricula);
        fim = System.nanoTime();
        remove_time_lde = fim - inicio;
        
        //Tempo de execução
        System.out.println("----------------------------------");
        System.out.println("Lista duplamente encadeada");
        System.out.println("Inserir:    " + insert_time_lde);
        System.out.println("Pesquisar:  " + search_time_lde);
        System.out.println("Remover:    " + remove_time_lde);
        System.out.println("Apresentar: " + show_time_lde);
        System.out.println("----------------------------------");

        

        // add 100k na árvore binária
        BinaryTree b = new BinaryTree();
        Estudante e = new Estudante(); // gera o Estudante root (todos os outros são instanciados em TreeNode)
        
        inicio = System.nanoTime();
        
        for (int i=0; i<100000; i++) {
            b.add(e.getMatricula());
        }

        fim = System.nanoTime();

        long insert_time_bt = fim - inicio;

        //Tempo de execução
        System.out.println("----------------------------------");
        System.out.println("Arvore binária");
        System.out.println("Inserir:    " + insert_time_bt);
        System.out.println("Pesquisar:  ");
        System.out.println("Remover:    ");
        System.out.println("Apresentar: ");
        System.out.println("----------------------------------");

        }


}

