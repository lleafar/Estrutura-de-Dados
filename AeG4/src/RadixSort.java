public class RadixSort {
             
    

    
    public static void radixSort(int[] lista, int maior){
        int tamanhoNmro = tamanhoDoNumero(maior); // retorna a quantia de digitos do maior número
        int posicao = 1;                          // começa na posição 1

        while (tamanhoNmro-- > 0) {
            System.out.println(tamanhoNmro);
            countingsort(lista, posicao);        // manda a lista e posição do digito
            posicao *= 10;                       // incrementa a posição do digito 1 10 100
                                                 // ex.: digito 325                5  2  3
        }

    }

    public static int tamanhoDoNumero(int nmro){
        char[] n = String.valueOf(nmro).toCharArray();
        return n.length;
    }

    private static void countingsort(int[] numbers, int posicao) {
        int range = 10;

        int length = numbers.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];


        // conta a frequencia de cada digito
        for (int i = 0; i < length; i++) {
            int digit = (numbers[i] / posicao) % range;
            frequency[digit]++;
        }

        // soma a quantidade do digito com a quantidade do digito anterior
        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        // posiciona os numeros de acordo
        // com o valor da frequencia do digito - 1
        // e diminui remove 1 ocorrencia do digito 
        // na lista de frequencia 
        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / posicao) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }



}
