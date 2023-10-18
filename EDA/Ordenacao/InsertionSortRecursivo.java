/**
 * Este programa implementa o algoritmo de ordenação Insertion Sort de forma recursiva.
 * O programa lê uma sequência de valores separados por espaço, e em seguida, ordena a sequência
 * em ordem crescente usando o algoritmo de Insertion Sort recursivo.
 * O progresso da ordenação é impresso a cada passo para ilustrar o funcionamento do algoritmo.
 */
import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
   
    /**
     * Esta função realiza o passo do algoritmo Insertion Sort recursivo para ordenar a sequência.
     * @param array - A sequência a ser ordenada.
     * @param indiceInicial - O índice inicial da sequência a ser considerado.
     * @param indiceFinal - O índice final da sequência a ser considerado.
     */
    public static void InsertionSort(String[] array, int indiceInicial, int indiceFinal) {
        int i = indiceInicial;

        // Percorre a sequência e insere o elemento atual na posição correta.
        while (i <= indiceFinal) {
            int j = i;

            // Compara o elemento atual com os elementos anteriores e move-o para a posição correta.
            while (j > 0 && Integer.parseInt(array[j]) < Integer.parseInt(array[j - 1])) {
                String auxiliar = array[j];
                array[j] = array[j - 1];
                array[j - 1] = auxiliar;
                j--;
            }

            // Imprime a sequência após cada passo.
            System.out.println(Arrays.toString(array));
            
            i++;

            // Chama a função recursivamente para continuar a ordenação.
            if (i <= indiceFinal) {
                InsertionSort(array, i, indiceFinal);
            }
        }
    }

    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);

        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] entrada = sc.nextLine().split(" ");

        // Chama a função InsertionSort para ordenar a sequência.
        InsertionSort(entrada, 1, entrada.length - 1);
    }
}