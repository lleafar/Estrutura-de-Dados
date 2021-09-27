package utils;

import tad.ListaDuplamenteEncadeada.ListaDuplamenteEncadeada;

import java.util.HashMap;
import java.util.Map;

public class Popular {

    private Estudante estudante;
    private Map<Integer,String> map_estudante;
    private final int total_alunos = 10000;


    public ListaDuplamenteEncadeada<Map<Integer, String>> getLDE(){
        //Estruturas de Dados
        ListaDuplamenteEncadeada<Map<Integer, String>> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<>();

        //Gera 100 000 alunos e adiciona a estrutura de dado
        System.out.println("Variáveis Setadas Iniciando...");
        for (int i = 0; i < total_alunos; i++) {
            estudante     = new Estudante();
            map_estudante = new HashMap<>();

            map_estudante.put(estudante.getMatricula(), estudante.getCurso());
            listaDuplamenteEncadeada.adicionarFim(map_estudante);
        }
        System.out.println("Lista Populada!");

        return listaDuplamenteEncadeada;
    }


}
