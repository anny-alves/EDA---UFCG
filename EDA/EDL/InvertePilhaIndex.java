package EDL;

import java.util.Scanner;

class InvertePilhaIndex {
    
    private int capacidade;
    private int[] pilha;
    private int topo;

    public InvertePilhaIndex(int tamanho) {
        this.capacidade = tamanho;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }
    public boolean isEmpty() {
        return this.topo == -1;
    }
    public void push(int n) {
        this.topo += 1;
        this.pilha[topo] = n;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        int valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        return this.pilha[topo];
    }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        String[] entrada = sc.nextLine().split(" ");
        InvertePilhaIndex pilha = new InvertePilhaIndex(tamanho);
        for (int i = 0; i < tamanho; i++) {
            pilha.push(Integer.parseInt(entrada[i]));
        }
        int index = sc.nextInt();

        invertePilha(tamanho, pilha, index);
        System.out.println("-");

        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }

    }
    private static void invertePilha(int capacidade, InvertePilhaIndex pilha, int index) {

        int[] aux = new int[index + 1]; //array para guarda os removidos
        int cont = 0;       //var para verificar a parada

        //remove os elementos até bate o index e joga no aux
        while(cont <= index) {
            aux[cont] = pilha.pop();
            cont++;
        }

        //add os elementos de aux de volta na pilha (ao contrario agora)
        for (int i = 0; i < aux.length; i++) {
            pilha.push(aux[i]);
        }

    }


}
