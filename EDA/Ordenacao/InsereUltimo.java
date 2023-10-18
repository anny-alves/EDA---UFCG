/**
 * Este programa insere o último elemento em sua posição correta em uma sequência de entrada.
 * O programa lê uma sequência de valores separados por espaço e insere o último elemento em sua posição
 * correta, de modo que a sequência esteja ordenada em ordem crescente.
 * Em seguida, o programa imprime o resultado como uma matriz de strings.
 */
import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
    public static void main(String[] args) {
        // Cria um objeto Scanner para a entrada padrão (teclado).
        Scanner sc = new Scanner(System.in);
        
        // Lê a entrada como uma única linha e divide os valores em um array de strings.
        String[] array = sc.nextLine().split(" ");

        // Percorre o array da direita para a esquerda para encontrar a posição correta para inserir o último elemento.
        for (int index = array.length - 1; index >= 1; index--) {
            if (Integer.parseInt(array[index]) < Integer.parseInt(array[index - 1])) {
                // Realiza a troca de elementos para inserir o último elemento na posição correta.
                String intermediario = array[index];
                array[index] = array[index - 1];
                array[index - 1] = intermediario;
            }           
        }

        // Imprime o resultado como uma matriz de strings usando Arrays.toString().
        System.out.println(Arrays.toString(array));
    }
}