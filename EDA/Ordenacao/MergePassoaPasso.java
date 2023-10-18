/**
 * Este programa implementa o algoritmo de ordenação Merge Sort e demonstra seu funcionamento passo a passo.
 * O programa lê uma sequência de valores separados por espaço, em seguida, ordena a sequência usando o algoritmo
 * de Merge Sort e exibe o estado da sequência em cada etapa do processo de fusão.
 */
import java.util.Arrays;
import java.util.Scanner;

public class MergePassoaPasso {
    /**
     * Esta função executa a etapa de fusão de duas partes de um array.
     * @param array - O array a ser fundido.
     * @param inicio - O índice de início da primeira parte do array.
     * @param meio - O índice que divide as duas partes a serem fundidas.
     * @param fim - O índice de fim da segunda parte do array.
     */
    public static void Merge(String[] array, int inicio, int meio, int fim) {
        // Cria um array auxiliar para manter temporariamente os valores.
        String[] auxiliar = new String[array.length];
        for (int i = inicio; i <= fim; i++) {
            auxiliar[i] = array[i];
        }
        System.out.println(Arrays.toString(auxiliar));

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        // Realiza a fusão das duas partes do array.
        while (i <= meio && j <= fim) {
            if (Integer.parseInt(auxiliar[i]) <= Integer.parseInt(auxiliar[j])) {
                array[k] = auxiliar[i];
                i++;
            } else {
                array[k] = auxiliar[j];
                j++;
            }
            k++;
            System.out.println(Arrays.toString(array));
        }

        // Copia quaisquer elementos restantes da primeira parte.
        while (i <= meio) {
            array[k] = auxiliar[i];
            i++;
            k++;
        }

        // Copia quaisquer elementos restantes da segunda parte.
        while (j <= fim) {
            array[k] = auxiliar[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Esta função executa o algoritmo de ordenação Merge Sort de forma recursiva.
     * @param array - O array a ser ordenado.
     * @param inicio - O índice de início da parte a ser ordenada.
     * @param fim - O índice de fim da parte a ser ordenada.
     */
    public static void MergeSort(String[] array, int inicio, int fim) {
        if (fim <= inicio) {
            return;
        } else {
            int meio = (inicio + fim) / 2;
            MergeSort(array, inicio, meio);
            MergeSort(array, meio + 1, fim);
            Merge(array, inicio, meio, fim);
        }
    }

    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);

        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] entrada = sc.nextLine().split("");

        // Imprime a sequência original.
        System.out.println(Arrays.toString(entrada));

        // Chama o MergeSort para ordenar a sequência.
        MergeSort(entrada, 0, entrada.length - 1);

        // Imprime a sequência ordenada.
        System.out.println(Arrays.toString(entrada));
    }
}
