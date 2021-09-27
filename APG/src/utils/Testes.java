package utils;

import tad.ListaDuplamenteEncadeada.ListaDuplamenteEncadeada;

import java.util.Arrays;
import java.util.Map;

public class Testes {

    //LISTA ENCADEADA
    public static ListaDuplamenteEncadeada<Map<Integer, String>> remover(ListaDuplamenteEncadeada<Map<Integer, String>> lista, Integer matricula){

        for (int i = 0; i < lista.size(); i++) {
            Map<Integer, String> entry = lista.get(i).getDado();

            for (Integer key : entry.keySet()) {
                if (key <= matricula)
                    lista.remove(lista.get(i));
            }
        }

        return lista;
    }

    public static int pesquisar(ListaDuplamenteEncadeada<Map<Integer, String>> lista, String curso){
        int qtd=0;
        boolean ehduplicata;

        for (int i = 0; i < lista.size(); i++) {
            Map<Integer, String> entry = lista.get(i).getDado();


            for (Integer key : entry.keySet()) {
                String value = entry.get(key);

                if (value.equals(curso)) {
                    ehduplicata = false;

                    for (int j = i + 1; j < lista.size(); j++) {
                        Map<Integer, String> a = lista.get(j).getDado();
                        if (entry.entrySet().equals(a.entrySet())) {
                            ehduplicata = true;
                        }

                    }

                    if (!ehduplicata)
                        qtd++;

                }

            }

        }


        return qtd;
    }



    //ARVORE BINARIA


    //VETOR

}
