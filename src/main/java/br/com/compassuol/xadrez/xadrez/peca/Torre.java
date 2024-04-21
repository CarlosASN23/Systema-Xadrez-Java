package br.com.compassuol.xadrez.xadrez.peca;

import br.com.compassuol.xadrez.boardgame.Tabuleiro;
import br.com.compassuol.xadrez.xadrez.Color;
import br.com.compassuol.xadrez.xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }
    @Override
    public String toString(){
        return "T";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat= new boolean[getTabuleiro().getRow()][getTabuleiro().getColumn()];
        return null;
    }
}
