/**
 * Este programa implementa o algoritmo de ordenação Merge Sort e demonstra seu funcionamento.
 * O programa lê uma sequência de valores separados por espaço e, em seguida, ordena a sequência
 * em ordem crescente usando o algoritmo de Merge Sort. A cada etapa da fusão, a sequência é impressa.
 */
import java.util.Arrays;
import java.util.Scanner;

public class MergeSecond {
    /**
     * Esta função executa o algoritmo Merge Sort para ordenar um array.
     * @param array - O array a ser ordenado.
     * @param left - O índice à esquerda da parte a ser ordenada.
     * @param right - O índice à direita da parte a ser ordenada.
     */
    public static void MergeSort(String[] array, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int middle = (left + right) / 2;
            MergeSort(array, left, middle);
            MergeSort(array, middle + 1, right);
            Merge(array, left, middle, right);
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Esta função executa a etapa de fusão do Merge Sort.
     * @param array - O array a ser fundido.
     * @param left - O índice à esquerda da primeira parte a ser fundida.
     * @param middle - O índice que divide as duas partes a serem fundidas.
     * @param right - O índice à direita da segunda parte a ser fundida.
     */
    public static void Merge(String[] array, int left, int middle, int right) {
        String[] helper = new String[array.length];

        // Copia os elementos do array original para um array auxiliar.
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        // Realiza a fusão das duas partes do array.
        while (i <= middle && j <= right) {
            if (Integer.parseInt(helper[i]) <= Integer.parseInt(helper[j])) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copia quaisquer elementos restantes da primeira parte.
        while (i <= middle) {
            array[k] = helper[i];
            i++;
            k++;
        }

        // Copia quaisquer elementos restantes da segunda parte.
        while (j <= right) {
            array[k] = helper[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);

        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] entrada = sc.nextLine().split(" ");

        // Imprime a sequência original.
        System.out.println(Arrays.toString(entrada));

        // Chama o MergeSort para ordenar a sequência.
        MergeSort(entrada, 0, entrada.length - 1);

        // Imprime a sequência ordenada.
        System.out.println(Arrays.toString(entrada));
    }
}
