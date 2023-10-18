package EDL;

import java.util.Scanner;

public class MaxPilhaIndex {
    private int capacidade;
    private int[] pilha;
    private int topo;

    public MaxPilhaIndex(int capacidade){
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
        
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] entrada = sc.nextLine().split(" ");
        InvertePilhaIndex pilha = new InvertePilhaIndex(entrada.length);
        for (int i = 0; i < entrada.length; i++) {
            pilha.push(Integer.parseInt(entrada[i]));
        }
        int index = sc.nextInt();
        int maior = maiorNoIntervalo(pilha, index);
        System.out.println(maior);
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public void push(int n){
        this.topo += 1;
        this.pilha[topo] = n;
    }

    public int pop(){
        int valor_topo = pilha[topo];
        this.topo -= 1;
        return valor_topo;
    }

    public static int maiorNoIntervalo(InvertePilhaIndex pilha, int index){
        int maior = 0;
        int[] aux = new int[index + 1];
        int i = 0;
    
        while(i <= index){
            aux[i] = pilha.pop();
            if(aux[i] > maior){
                maior = aux[i];
            }
            i++;
        }
        for (int j = aux.length-1; j >= 0; j--) {
            pilha.push(aux[j]);
        }
        
        return maior;
    }

    
    
}
