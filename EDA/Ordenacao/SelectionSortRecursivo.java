/**
 * Este programa implementa o algoritmo de ordenação Selection Sort de forma recursiva e demonstra seu funcionamento passo a passo.
 * O programa lê uma sequência de valores separados por espaço e, em seguida, ordena a sequência em ordem crescente
 * usando o algoritmo de Selection Sort recursivo. A cada iteração do algoritmo, a sequência é impressa para ilustrar o processo.
 */
import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
    /**
     * Esta função executa o algoritmo de ordenação Selection Sort de forma recursiva.
     * @param array - O array a ser ordenado.
     * @param limiteInicial - O índice inicial da parte da sequência a ser considerada.
     * @param limiteFinal - O índice final da parte da sequência a ser considerada.
     */
    public static void SelectionSortRecursivo(String[] array, int limiteInicial, int limiteFinal) {
        int j = limiteInicial;
        int i = j + 1;
        int menorIndice = j;
        
        // Encontra o índice do menor elemento na parte da sequência considerada.
        while (i <= limiteFinal) {
            if (Integer.parseInt(array[menorIndice]) > Integer.parseInt(array[i])) {
                menorIndice = i;
            }
            i++;
        }
        
        // Realiza a troca do menor elemento com o elemento na posição atual.
        String auxiliar = array[menorIndice];
        array[menorIndice] = array[j];
        array[j] = auxiliar;
        
        // Imprime a sequência após a troca.
        System.out.println(Arrays.toString(array));

        j++;
        
        // Chama a função recursivamente para continuar a ordenação na próxima posição.
        if (j < limiteFinal) {
            SelectionSortRecursivo(array, j, limiteFinal);
        }
    }

    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);
        
        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] entrada = sc.nextLine().split(" ");
        
        // Chama a função SelectionSortRecursivo para ordenar a sequência.
        SelectionSortRecursivo(entrada, 0, entrada.length - 1);
    }
}