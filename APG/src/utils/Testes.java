package utils;

import tad.ListaDuplamenteEncadeada.ListaDuplamenteEncadeada;

import java.util.*;

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

    public static ListaDuplamenteEncadeada<Map<Integer, String>> ordenar(ListaDuplamenteEncadeada<Map<Integer, String>> lista){
        ListaDuplamenteEncadeada<Map<Integer, String>> sorted = new ListaDuplamenteEncadeada<>();
        ArrayList<Integer> ordenada = new ArrayList<>();

        for (int i = 0; i < lista.size() ; i++) {
            Map<Integer, String> entry = lista.get(i).getDado();
            for (Integer key: entry.keySet()) {
                ordenada.add(key);
            }

        }
        ordenada.sort(null);

        for (int i = 0; i < ordenada.size(); i++) {
            Map<Integer, String> mp;


            for (int j = 0; j < lista.size() ; j++) {
                Map<Integer, String> entry = lista.get(j).getDado();
                Integer k = null;
                String value;
                for (Integer key: entry.keySet()) {
                   k = key;
                   value = entry.get(key);

                }

                if (k.equals(ordenada.get(i))){
                    value = entry.get(k);
                    mp = new HashMap<>();
                    mp.put(k, value);
                    sorted.adicionarFim(mp);
                    break;
                }

            }
        }
        return sorted;
    }

    public static void print(ListaDuplamenteEncadeada<Map<Integer, String>> lista){

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getDado().entrySet());
        }

    }

    //ARVORE BINARIA


    //VETOR

}
