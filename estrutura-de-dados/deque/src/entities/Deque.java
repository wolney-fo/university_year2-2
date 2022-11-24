package entities;


import entities.Celula;
import entities.Iterador;

public class Deque<T> {

    private Celula inicio, fim;
    private int tamanho;

    public Deque() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // Manipulação
    public void inserirNoInicio(T elemento) {
        Celula celula = new Celula(elemento);
        if (isEmpty()) {
            this.inicio = this.fim = celula;
        } else {
            celula.setProximo(this.inicio);
            this.inicio.setAnterior(celula);
            this.inicio = celula;
        }
        this.tamanho++;
    }

    public void inserirNoFim(T elemento) {
        Celula celula = new Celula(elemento);
        if (this.tamanho == 0) {
            this.inicio = this.fim = celula;
        } else {
            celula.setAnterior(this.fim);
            this.fim.setProximo(celula);
            this.fim = celula;
        }
    }

    public void alterarInicio(T elemento) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is Empty");
        } else {
            this.inicio.setElemento(elemento);
            if (tamanho == 1) {
                this.fim.setElemento(elemento);
            }
        }
    }

    public void alterarFim(T elemento) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is Empty");
        } else {
            this.fim.setElemento(elemento);
            if (tamanho == 1) {
                this.inicio.setElemento(elemento);
            }
        }
    }

    public void removerInicio() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is Empty");
        } else if (this.tamanho == 1){
            limpa();
        } else if (this.tamanho == 2) {
            this.fim.setAnterior(null);
            this.inicio = this.fim;
            this.tamanho = 1;
        }else {
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(null);
            tamanho--;
        }
    }

    public void removerFim() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is Empty");
        } else if (this.tamanho == 1){
            limpa();
        } else if (this.tamanho == 2) {
            this.inicio.setProximo(null);
            this.fim = this.inicio;
            this.tamanho = 1;
        }else {
            this.fim = this.fim.getAnterior();
            this.fim.setProximo(null);
            tamanho--;
        }
    }

    public void limpa() {
        this.inicio = this.fim = null;
        this.tamanho = 0;
    }




    // Consultas
    public boolean existeDado(T elemento){
        Iterador it = new Iterador(this.inicio);

        while (it.hasNext()) {
            if (it.getAtual() == elemento) {
                return true;
            }
            it.next();
        }
        return false;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public T recuperarInicio() {
        return (T) this.inicio.getElemento();
    }

    public T recuperarFim() {
        return (T) this.fim.getElemento();
    }

    public int tamanho() {
        return this.tamanho;
    }

}
