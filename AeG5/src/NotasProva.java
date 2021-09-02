import java.util.Scanner;

public class NotasProva{

    //        0  -   E
    //  1 a  35  -   D
    // 36 a  60  -   C 
    // 61 a  85  -   B
    // 86 a 100  -   A

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nt = sc.nextInt();
        String n = "";

        if (nt < 61){
            if (nt > 35)
                n = "C";
            else{
                if(nt > 0)
                    n = "D";
                else
                    n = "E";
            }

        } else if (nt > 60) {
            if(nt < 86)
                n = "B";
            else
                n = "A";
        }

        System.out.println(n);
    }

}