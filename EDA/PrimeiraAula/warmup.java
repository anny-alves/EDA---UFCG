/**
 * Este programa calcula os múltiplos de um número dado, multiplicando-o por uma lista de fatores fornecidos como entrada.
 */
package PrimeiraAula;

import java.util.Scanner;

class warmup {
    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);
        
        // Lê o número a ser multiplicado.
        int numero = Integer.parseInt(sc.nextLine());
        
        // Lê a lista de fatores como uma única linha de entrada e a divide em um array de strings.
        String[] fatores = sc.nextLine().split(" ");
        
        // Inicializa uma string para armazenar a saída.
        String saida = "";
        
        // Calcula os múltiplos do número dado, multiplicando-o por cada fator na lista.
        for (int i = 0; i < fatores.length; i++) {
            int multiplicacao = numero * Integer.parseInt(fatores[i]);
            
            // Converte o resultado da multiplicação em uma string e a concatena à saída.
            saida += Integer.toString(multiplicacao) + " ";
        }

        // Remove o espaço em branco extra no final da saída e imprime o resultado.
        System.out.println(saida.trim());
    }
}