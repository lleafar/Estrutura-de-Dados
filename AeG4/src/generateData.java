import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class generateData {
  private static List<Integer> genData;

public static void main(String[] args) throws IOException {
        int[] lista = getData(100);

        System.out.println(lista.length);

  }  
  
  static int[] getData(int tam){
    genData = genData(tam);

    int[] lst = new int[genData.size()];


    for (int i = 0; i < genData.size(); i++) {
        lst[i] = genData.get(i);
    }

    return lst;
  } 

  private static List<Integer> genData(int tam){
    String file = "src/Data/array.txt";
    int tam2 = (tam/2);

    BufferedWriter w;
    try {
        w = new BufferedWriter(new FileWriter(file));

        

        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        for (int i = 1; i <= tam2-1; i++) {
        lista.add(i);
        }
        lista2 = lista;

        Collections.reverse(lista);
        Collections.shuffle(lista);
        Collections.reverse(lista2);
        Collections.shuffle(lista2);

        lista.addAll(lista2);
        lista.add(tam2-1);
        lista.add(tam);      //valor único 90%
    
        while(lista.size() < tam){
            lista.add(1);
        }
    
        // for (Integer l : lista) {
        //     w.write(String.valueOf(l) + ";");
        //     w.newLine();
        // }

        // w.close();

        return lista;

    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
  }



}
