package application;

import entities.ListaEncadeada;
import entities.Aluno;

public class main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        for (int i=0; i<3; i++){
            Aluno aluno = new Aluno();
            lista.adicionaInicio(aluno);
        }

        lista.recuperaElementos();
    }
}
