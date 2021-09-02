import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParesImpares{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(), ii = 0, v;
        
        ArrayList<Integer> prs = new ArrayList<>();
        ArrayList<Integer> imp = new ArrayList<>();

        while(ii < q){          
            v = sc.nextInt();
            if ((v % 2) == 0) 
                prs.add(v);
            else
                imp.add(v);
            
          ii++;
        }

        Collections.sort(prs);
        Collections.sort(imp);
        Collections.reverse(imp);

        prs.addAll(imp);

        for (Integer value : prs) {
            System.out.println(value);
        }

    }


}