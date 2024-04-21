package br.com.compassuol.xadrez.application;

import br.com.compassuol.xadrez.boardgame.Posicao;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;

public class Principal {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(8,8);
        System.out.println(tabuleiro);
    }

}
