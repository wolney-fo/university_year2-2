package entities;

import entities.Celula;
import entities.Iterador;
public class ListaDuplamenteEncadeada<T> {

    private Celula inicio, fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // Manipulação
    public void adiciona(T elemento, int posicao){
        if (posicao > 0 && posicao <= this.tamanho){
            Celula celula = new Celula(elemento);

            if (this.tamanho == 0 || posicao == 0){
                adicionaInicio(elemento);
            }
            else {
                Iterador it = new Iterador(this.inicio);

                int index = 0;
                while (it.hasNext()){
                    if (index == posicao){
                        break;
                    }
                    it.next();
                    index++;
                }

                it.getAtual().setAnterior(celula);
                celula.setProximo(it.getAtual());

                this.tamanho++;
            }
        } else {
            System.out.println("Posição inválida");
        }
    }


    public void adicionaInicio(T elemento){
        Celula celula = new Celula(elemento);
        if (this.tamanho == 0){
            inicio = fim = celula;
            this.tamanho++;
        } else {
            celula.setProximo(inicio);
            this.inicio.setAnterior(celula);
            this.inicio = celula;
            this.tamanho++;
        }
    }

    public void adicionaFim(T elemento){
        Celula celula = new Celula(elemento);
        this.fim.setProximo(celula);
        celula.setAnterior(this.fim);
        this.fim = celula;
        this.tamanho++;
    }

    public void remove(int posicao){
        Iterador it = new Iterador(this.inicio);

        int index = 0;
        while (it.hasNext()){
            if (index == posicao){
                break;
            }
            it.next();
            index++;
        }

        it.getAtual().getAnterior().setProximo(it.getAtual().getProximo());

        this.tamanho--;
    }

    public void removeInicio(){
        this.inicio = this.inicio.getProximo();
        this.inicio.setAnterior(null);
        this.tamanho--;
    }

    public void removeFim(){
        Iterador it = new Iterador(this.inicio);

        int index = 0;
        while (it.hasNext()){
            if (index == this.tamanho - 1){
                break;
            }
            index++;
        }
        it.getAtual().setProximo(null);
        this.tamanho--;
    }

    public void limpa(){
        this.inicio = null;
        this.fim = null;
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

    public T recupera(int posicao) {
        if (posicao > this.tamanho) {
            System.out.println("Posição Inválida");
        }
        else if (posicao < 0 || posicao > this.tamanho) {
            System.out.println("Posição fora da lista");
        }
        else {
            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()) {
                if (i != posicao) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }
        }
        return null;
    }

    public int tamanho(){
        return this.tamanho;
    }

    public void recuperaElementos(){
        Iterador it = new Iterador(this.inicio);
        for (int i=0; i<this.tamanho; i++){
            System.out.println(it.getAtual().getElemento());
            it.next();
        }
    }
}
