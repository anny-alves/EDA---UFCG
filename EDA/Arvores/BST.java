/**
 * Esta classe implementa uma Árvore Binária de Busca (BST - Binary Search Tree).
 * A árvore é composta por nós, cada um armazenando um valor inteiro. Os nós são organizados
 * de forma que os valores menores ficam à esquerda e os valores maiores ficam à direita do nó raiz.
 */
package Arvores;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BST {

    private Node root; // O nó raiz da árvore.
    private int size; // O tamanho da árvore (quantidade de nós).

    /**
     * Verifica se a árvore está vazia.
     * @return true se a árvore estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Adiciona um elemento na árvore de forma iterativa.
     * @param element - O valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
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
    
    /**
     * Retorna o nó que contém o valor mínimo da árvore. Implementação recursiva.
     * @return O nó contendo o valor mínimo da árvore ou null se a árvore estiver vazia.
     */
    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }
    
    /**
     * Retorna o nó que contém o valor mínimo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param node - A raiz da árvore.
     * @return O nó contendo o valor mínimo da árvore ou null se a árvore estiver vazia.
     */
    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    /**
     * Retorna o nó que contém o valor máximo da árvore. Implementação iterativa.
     * @return O nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    public Node max() {
        if (isEmpty()) return null;
        
        Node node = this.root;
        while(node.right != null)
            node = node.right;
        
        return node;
    }
    
    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param node - A raiz da árvore.
     * @return O nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }
    
    /**
     * Retorna o nó cujo valor é o predecessor do valor passado como parâmetro. 
     * @param node - O nó para o qual deseja-se identificar o predecessor.
     * @return O nó contendo o predecessor do valor passado como parâmetro. O método retorna null caso não haja predecessor.
     */
    public Node predecessor(Node node) {
        if (node == null) return null;
        
        if (node.left != null)
            return max(node.left);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value > node.value)
                aux = aux.parent;
            
            return aux;
        }
    }
    
    /**
     * Retorna o nó cujo valor é o sucessor do valor passado como parâmetro. 
     * @param node - O nó para o qual deseja-se identificar o sucessor.
     * @return O nó contendo o sucessor do valor passado como parâmetro. O método retorna null caso não haja sucessor.
     */
    public Node sucessor(Node node) {
        if (node == null) return null;
        
        if (node.right != null)
            return min(node.right);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value < node.value)
                aux = aux.parent;
            
            return aux;
        }
    }
    
    /**
     * Adiciona um elemento na árvore de forma recursiva.
     * @param element - O elemento a ser adicionado.
     */
    public void recursiveAdd(int element) {
        if (isEmpty())
            this.root = new Node(element);
        else {
            Node aux = this.root;
            recursiveAdd(aux, element);
        }
        this.size += 1;
    }
    
    /**
     * Método auxiliar para a implementação recursiva do método de adição.
     * @param node - A raiz da árvore.
     * @param element - O elemento a ser adicionado.
     */
    private void recursiveAdd(Node node, int element) {
        if (element < node.value) {
            if (node.left == null) {
                Node newNode = new Node(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            recursiveAdd(node.left, element);
        } else {
            if (node.right == null) {
                Node newNode = new Node(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }
            recursiveAdd(node.right, element);
        }
    }
    
    /**
     * Remove o nó com o valor especificado.
     * @param value - O valor a ser removido.
     */
    public void remove(int value) {
        Node toRemove = search(value);
        if (toRemove != null) {
            remove(toRemove);
            this.size -= 1;
        }
    }
    
    /**
     * Método privado para controlar a recursão e remover um nó.
     * @param toRemove - O nó a ser removido.
     */
    private void remove(Node toRemove) {
        // Primeiro caso: o nó é uma folha.
        if (toRemove.isLeaf()) {
            if (toRemove == this.root)
                this.root = null;
            else {
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = null;
                else
                    toRemove.parent.right = null;
            }
        } 
        // Segundo caso: o nó tem apenas filho à esquerda ou à direita.
        else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.left;
                else
                    toRemove.parent.right = toRemove.left;
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }
        } 
        // Terceiro caso: o nó tem dois filhos.
        else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }

    /**
     * Realiza a busca binária na árvore para encontrar um nó com o valor especificado.
     * @param element - O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        Node aux = this.root;
        while (aux != null) {   
            if (aux.value == element) return aux;
            if (element < aux.value) aux = aux.left;
            if (element > aux.value) aux = aux.right;
        }
        return null;
    }
    
    /**
     * Realiza uma busca binária recursiva na árvore para encontrar um nó com o valor especificado.
     * @param element - O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso o elemento não esteja presente na árvore.
     */
    public Node recursiveSearch(int element) {
        return recursiveSearch(this.root, element);
    }
    
    /**
     * Método auxiliar para a busca binária recursiva.
     * @param node - A raiz da árvore.
     * @param element - O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso o elemento não esteja presente na árvore.
     */
    private Node recursiveSearch(Node node, int element) {
        if (node == null) return null;
        if (element == node.value) return node;
        if (element < node.value) return recursiveSearch(node.left, element);
        else return recursiveSearch(node.right, element);
    }
    
    /**
     * Retorna a altura da árvore.
     * @return A altura da árvore.
     */
    public int height() {
        return height(this.root);
    }
    
    /**
     * Método auxiliar para a determinação da altura da árvore.
     * @param node - A raiz da árvore.
     * @return A altura da árvore cuja raiz é passada como parâmetro.
     */
    private int height(Node node) {
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }
    
    /**
     * Realiza um percurso pré-ordem na árvore, imprimindo os valores dos nós.
     */
    public void preOrder() {
        preOrder(this.root);
    }

    /**
     * Método auxiliar para a realização do percurso pré-ordem.
     * @param node - A raiz da subárvore a ser percorrida.
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * Realiza um percurso em-ordem na árvore, imprimindo os valores dos nós.
     */
    public void inOrder() {
        inOrder(this.root);
    }

    /**
     * Método auxiliar para a realização do percurso em-ordem.
     * @param node - A raiz da subárvore a ser percorrida.
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    /**
     * Realiza um percurso pós-ordem na árvore, imprimindo os valores dos nós.
     */
    public void posOrder() {
        posOrder(this.root);
    }

    /**
     * Método auxiliar para a realização do percurso pós-ordem.
     * @param node - A raiz da subárvore a ser percorrida.
     */
    private void posOrder(Node node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.value);
        }
    }
    
    /**
     * Realiza um percurso em largura (Breadth-First Search) na árvore, retornando os valores dos nós percorridos em largura.
     * @return Uma lista com os elementos percorridos em largura.
     */
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> queue = new LinkedList<Node>();
        
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                
                list.add(current.value);
                
                if(current.left != null) 
                    queue.addLast(current.left);
                if(current.right != null) 
                    queue.addLast(current.right);   
            }
        }
        return list;
    }

    /**
     * Retorna o tamanho da árvore, ou seja, a quantidade de nós na árvore.
     * @return O tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
}


/**
 * Esta classe representa um nó em uma árvore binária de busca (BST).
 */
class Node {
    
    int value; // O valor armazenado no nó.
    Node left; // O nó à esquerda.
    Node right; // O nó à direita.
    Node parent; // O nó pai.
    
    Node(int v) {
        this.value = v;
    }

    /**
     * Verifica se o nó possui apenas um filho à esquerda.
     * @return true se o nó possui apenas um filho à esquerda, false caso contrário.
     */
    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }
    
    /**
     * Verifica se o nó possui apenas um filho à direita.
     * @return true se o nó possui apenas um filho à direita, false caso contrário.
     */
    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    /**
     * Verifica se o nó é uma folha, ou seja, não possui filhos.
     * @return true se o nó for uma folha, false caso contrário.
     */
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}

