package br.com.compassuol.xadrez.xadrez;

import br.com.compassuol.xadrez.boardgame.Pecas;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;

public class PecaXadrez extends Pecas {

    private Color color;
    public PecaXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
