package br.com.compassuol.xadrez.boardgame;

public class Pecas {

    // Inicialização das variaveis
    protected  Posicao posicao;
    private Tabuleiro tabuleiro;

    // Criação do construtor com passagem de parâmetros
    public Pecas(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        posicao = null;
    }

    // Getters e Setters
    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

}
