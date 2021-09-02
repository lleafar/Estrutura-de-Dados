import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        String file = "src/Data/result.txt";
        String fileOrdenado = "src/Data/ordenado.txt";
        
        BufferedWriter w = new BufferedWriter(new FileWriter(file));
        
        // maior integer suportado 
        // 2 147 483 647
        // 85000000 maior suportado no meu pc
        // 50000000 maior suportado em counting sort
        
        int maiorValor = 100; // maior valor para passar para os algoritmos e tambem é consequentemente o número de valores que o generateData.getData vai criar e por no array
                                // Obs.: esse generateData.getData ele seria o que cria 90% ou mais de dados duplicados
            
            int[] x = generateData.getData(maiorValor); //só vai gerar o valor exato se o número for par
            
            int[] y = {50,25,30,35,11};

            // por sempre o algoritmo aqui entre essa variáveis
            long startTime = System.nanoTime();
                
                RadixSort.radixSort(y, 50);                      // O(d(n+b)) complexidade
                //CountingSort.countingSort(x, i);
                // Merge aqui
            
            long endTime = System.nanoTime();

            long elapsed = endTime - startTime;
            double seconds = (double)elapsed / 1_000_000_000.0; // converte pra segundos


            // DA PRA FORMATAR MELHOR ISSO AQUI
            // ELE MANDA PRA UM ARQUIVO INFORMADO LÁ EM CIMA
            // OS DADOS PARA CRIAR OS GRÁFICOS DEPOIS 
            // w.append("Tempo de execução do algoritmo");
            // w.newLine();
            // w.newLine();
            // w.append("Nanosegundos : " + String.valueOf(elapsed));
            // w.newLine();
            // w.append("Segundos     : " + String.valueOf(seconds));
            // w.newLine();
            // w.append("Total Valores: " + String.valueOf(x.length));
            // w.newLine();
            // w.newLine();
            


            System.out.println("Teste concluído ");
            
        
        // foi pedido que o array ordenado fosse posto em um arquivo, acredito que pra ele veja que tá realmente funcionando
        // pro radix ficaria assim
        // BufferedWriter w2 = new BufferedWriter(new FileWriter(fileOrdenado));
        
        // for (int i = 0; i < x.length; i++) {
        //     w2.append(String.valueOf(x[i])); // esse algoritmo de radix sort que peguei ele não tem retorno
        //                                      // ele meio que organiza já o array passado pra ele então seria só isso
        //                                      // mas nos casos que o algoritmo retorna aí isso vai ser diferente.......
        // }


        w.close();  
    }
    
}
