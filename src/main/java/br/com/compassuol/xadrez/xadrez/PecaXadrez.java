package br.com.compassuol.xadrez.xadrez;

import br.com.compassuol.xadrez.boardgame.Pecas;
import br.com.compassuol.xadrez.boardgame.Posicao;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;

public abstract class PecaXadrez extends Pecas {

    private Color color;
    public PecaXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean temPecasOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getColor() != color;
    }

    public PosicaoXadrez getPosicaoXadrez(){
        return PosicaoXadrez.fromPosition(posicao);
    }

}
