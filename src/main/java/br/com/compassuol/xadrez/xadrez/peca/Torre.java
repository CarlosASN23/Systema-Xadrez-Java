package br.com.compassuol.xadrez.xadrez.peca;

import br.com.compassuol.xadrez.boardgame.Posicao;
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

        Posicao p = new Posicao(0,0);
        p.setValues(posicao.getRow() - 1, posicao.getColumn());
        while(getTabuleiro().posicaoExistente(p)&& !getTabuleiro().temUmaPeca(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if(getTabuleiro().posicaoExistente(p) && temPecasOponente(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow(), posicao.getColumn() + 1);
        while(getTabuleiro().posicaoExistente(p)&& !getTabuleiro().temUmaPeca(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if(getTabuleiro().posicaoExistente(p) && temPecasOponente(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow() + 1, posicao.getColumn());
        while(getTabuleiro().posicaoExistente(p)&& !getTabuleiro().temUmaPeca(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(getTabuleiro().posicaoExistente(p) && temPecasOponente(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
