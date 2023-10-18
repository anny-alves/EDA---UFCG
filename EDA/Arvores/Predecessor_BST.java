package Arvores;

import java.util.Scanner;

public class Predecessor_BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int no = Integer.parseInt(sc.nextLine());
        BST arvore = new BST();
        for (String string : array) {
            arvore.add(Integer.parseInt(string));
        }
        // System.out.println(arvore.predeccessor(no));
    }
}
class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }
    
    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    
}
class BST {

    private Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    // public int[] predeccessor(Node Node) {
    //     return null;
    // }

    public void add(int element) {
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
    }
}
