/**
 * Este programa troca elementos adjacentes em uma sequência de entrada dada.
 * O programa lê uma sequência de valores separados por espaço e, em seguida, troca os elementos adjacentes.
 * Se a sequência tiver um número ímpar de elementos, o último elemento não é trocado.
 * O resultado é impresso como uma matriz de strings.
 */
package PrimeiraAula;

import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);

        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] entrada = sc.nextLine().split(" ");

        // Verifica se a sequência de entrada tem um número par ou ímpar de elementos.
        if (entrada.length % 2 == 0) {
            // Se for par, troca os elementos adjacentes em pares.
            for (int i = 0; i < entrada.length - 1; i += 2) {
                String intermediario = entrada[i];
                entrada[i] = entrada[i + 1];
                entrada[i + 1] = intermediario;
            }
        } else {
            // Se for ímpar, troca os elementos adjacentes em pares, exceto o último elemento.
            for (int i = 0; i < entrada.length - 2; i += 2) {
                String intermediario = entrada[i];
                entrada[i] = entrada[i + 1];
                entrada[i + 1] = intermediario;
            }
        }

        // Imprime o resultado como uma matriz de strings usando Arrays.toString().
        System.out.println(Arrays.toString(entrada));
    }
}