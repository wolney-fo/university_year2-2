package entities;


public class ListaEncadeada<T> {

    private Celula inicio, fim;
    private int tamanho;


    public ListaEncadeada() {
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
                // Adicionar células seguintes
                Iterador it = new Iterador(this.inicio);

                int index = 0;
                while (it.hasNext()){
                    if (index == posicao - 1){
                        break;
                    }
                    it.next();
                    index++;
                }

                celula.setProximo(it.getAtual().getProximo());

                //Inserir na lista
                Iterador it1 = new Iterador(this.inicio);

                index = 0;
                while (it.hasNext()){
                    if (index == posicao - 1){
                        break;
                    }
                    it.next();
                    index++;
                }
                it1.getAtual().setProximo(celula);

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
            this.inicio = celula;
            this.tamanho++;
        }
    }

    public void adicionaFim(T elemento){
        Celula celula = new Celula(elemento);
        this.fim.setProximo(celula);
        this.fim = celula;
        this.tamanho++;
    }

    public void remove(int posicao){
        Iterador it = new Iterador(this.inicio);
        Iterador it1 = new Iterador(this.inicio);

        int index = 0;
        while (it.hasNext()){
            if (index == posicao - 1){
                break;
            }
            it.next();
            it1.next();
            index++;
        }
        it1.next();

        Celula novoProximo = it1.getAtual().getProximo();
        it.getAtual().setProximo(novoProximo);

        this.tamanho--;
    }

    public void removeInicio(){
        this.inicio = this.inicio.getProximo();
        this.tamanho--;
    }

    public void removeFim(){
        Iterador it = new Iterador(this.inicio);

        int index = 0;
        while (it.hasNext()){
            if (index == this.tamanho - 2){
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
