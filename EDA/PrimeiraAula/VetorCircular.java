/**
 * Este programa implementa um vetor circular, que repete elementos de uma entrada dada várias vezes.
 * O programa lê uma entrada, que é uma sequência de valores separados por espaço, e um número inteiro que
 * representa quantas vezes essa sequência deve ser repetida.
 * Em seguida, ele cria um vetor circular, repetindo a sequência de entrada de acordo com o número de vezes
 * especificado e imprime o resultado.
 */
package PrimeiraAula;

import java.util.Scanner;

class VetorCircular {
    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);

        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] entrada = sc.nextLine().split(" ");

        // Lê o número de vezes que a sequência de entrada deve ser repetida.
        int qtdVezes = sc.nextInt();
        
        // Inicializa um contador para acompanhar a posição atual no vetor circular.
        int cont = 0;
        
        // Inicializa uma string para armazenar a saída.
        String saida = "";
        
        // Repete a sequência de entrada de acordo com o número de vezes especificado.
        for (int i = 0; i < qtdVezes; i++) {
            // Verifica se o contador atingiu o final do vetor e, se sim, volta ao início (vetor circular).
            if (cont == entrada.length) {
                cont = 0;
            }
            
            // Adiciona o elemento atual do vetor à saída e inclui um espaço em branco.
            saida += entrada[cont] + " ";
            
            // Move o contador para o próximo elemento do vetor.
            cont += 1;
        }

        // Remove o espaço em branco extra no final da saída e imprime o resultado.
        System.out.println(saida.trim());
    }
}
