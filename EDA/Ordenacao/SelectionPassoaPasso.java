/**
 * Este programa implementa o algoritmo de ordenação Selection Sort e demonstra seu funcionamento passo a passo.
 * O programa lê uma sequência de valores separados por espaço, em seguida, ordena a sequência em ordem crescente
 * usando o algoritmo de Selection Sort. A cada iteração do algoritmo, a sequência é impressa para ilustrar o processo.
 */
import java.util.Arrays;
import java.util.Scanner;

public class SelectionPassoaPasso {
    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);
        
        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] array = sc.nextLine().split(" ");
        
        // Itera sobre o array e encontra o menor elemento não classificado em cada iteração.
        for (int i = 0; i < array.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (Integer.parseInt(array[j]) < Integer.parseInt(array[indiceMenor])) {
                    indiceMenor = j;
                }
            }
            
            // Se o índice do elemento menor for diferente do índice atual, troca os elementos.
            if (indiceMenor != i) {
                String intermediario = array[i];
                array[i] = array[indiceMenor];
                array[indiceMenor] = intermediario;
                
                // Imprime a sequência após a troca.
                System.out.println(Arrays.toString(array));
            }
        }
    }
}
