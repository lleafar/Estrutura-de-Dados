import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FilaRecreio{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt(), index = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        while (index < numTests){
            int numAl = sc.nextInt(), nota, t;
            int[] notas = new int[numAl];
            int[] ntsCompara = new int[numAl];

            for (int i = 0; i < numAl; i++) {
                nota = sc.nextInt();
                notas[i] = nota;
                ntsCompara[i] = nota; 
            }

            Arrays.sort(notas);
            
            for (int i = 0; i < notas.length / 2; i++) {
                t = notas[i];
                notas[i] = notas[notas.length - i - 1];
                notas[notas.length - i - 1] = t;
            }

            int acm = 0; //contador
            for (int i = 0; i < notas.length; i++) {
                if(notas[i] == ntsCompara[i])
                    acm++;

            }

            res.add(acm);
            index++;
        }

        for (Integer n : res) {
           System.out.println(n); 
        }


    }
}