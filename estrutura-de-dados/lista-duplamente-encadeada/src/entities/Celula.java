package entities;

public class Celula {

    private Celula anterior, proximo;
    private Object elemento;


    public Celula(Object elemento) {
        this.elemento = elemento;
    }

    public Celula(Celula anterior, Celula proximo, Object elemento) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.proximo = anterior;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

}
