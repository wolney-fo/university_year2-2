package entities;


import entities.Celula;

public class Fila<T> {

    private Celula inicio, fim;
    private int tamanho;


    public Fila() {
        this.inicio = this.fim = null;
        this.tamanho = 0;
    }


    // Manipulação
    public void inserir(T elemento) {
        Celula celula = new Celula(elemento);
        if (!isEmpty()) {
            this.fim.setProximo(celula);
            this.fim = celula;
        } else {
            this.inicio = this.fim = celula;
        }
        tamanho++;
    }

    public void alterar(T elemento) {
        if (!isEmpty()) {
            Celula celula = new Celula(elemento);
            celula.setProximo(this.inicio.getProximo());
            this.inicio = celula;
        } else {
            throw new IndexOutOfBoundsException("Row size is Zero");
        }
    }

    public void remover() {
         if (this.tamanho > 1) {
             this.inicio = this.inicio.getProximo();
             this.tamanho--;
         } else if (this.tamanho == 1) {
             limpa();
         } else {
             throw new IndexOutOfBoundsException("Row size is Zero");
         }
    }

    public void limpa() {
        this.inicio = this.fim = null;
        this.tamanho = 0;
    }


    // Consultas
    public boolean existeDado(T elemento){
        return elemento == this.inicio;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public T recuperar() {
        return (T) this.inicio.getElemento();
    }

    public int tamanho() {
        return this.tamanho;
    }
}
