package br.com.compassuol.xadrez.xadrez.peca;

import br.com.compassuol.xadrez.boardgame.Posicao;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;
import br.com.compassuol.xadrez.xadrez.Color;
import br.com.compassuol.xadrez.xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
    public Rei(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat= new boolean[getTabuleiro().getRow()][getTabuleiro().getColumn()];

        Posicao p = new Posicao(0,0);

        p.setValues(posicao.getRow() - 1, posicao.getColumn());
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow() + 1, posicao.getColumn());
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow(), posicao.getColumn() - 1);
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow(), posicao.getColumn() + 1);
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow() - 1, posicao.getColumn() -1);
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow() - 1, posicao.getColumn() + 1);
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow() + 1, posicao.getColumn() - 1);
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(posicao.getRow() + 1, posicao.getColumn() + 1);
        if(getTabuleiro().posicaoExistente(p) && podeMover(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return null;
    }
}
