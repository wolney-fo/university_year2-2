package entities;

import entities.Celula;
import entities.Iterador;


public class Pilha<T> {

    private Celula inicio, fim;
    private int tamanho;


    public Pilha() {
        this.inicio = this.fim = null;
        this.tamanho = 0;
    }

    // Manipulação
    public void push(T elemento) {
        Celula celula = new Celula(elemento);
        if (existeDado()) {
            this.fim.setProximo(celula);
            this.fim = celula;
        } else {
            this.inicio = this.fim = celula;
        }
        this.tamanho++;
    }

    public void pull(T elemento) {
        if (existeDado()) {
            this.fim.setElemento(elemento);
        } else {
            throw new IndexOutOfBoundsException("Stack size is Zero");
        }
    }

    public void pop() {
        Iterador it = new Iterador(this.inicio);
        int index = 0;
        while (index < this.tamanho - 2) {
            it.next();
            index++;
        }
        it.getAtual().setProximo(null);
        this.fim = it.getAtual();
    }

    public void limpa() {
        this.inicio = this.fim = null;
        this.tamanho = 0;
    }

    // Consultas
    public boolean existeDado() { return !isEmpty(); }

    public boolean isEmpty() { return this.tamanho == 0; }

    public T top() { return (T) this.fim.getElemento(); }

    public int tamanho() { return this.tamanho; }

}
