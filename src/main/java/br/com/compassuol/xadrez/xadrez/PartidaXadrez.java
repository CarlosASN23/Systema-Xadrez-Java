package br.com.compassuol.xadrez.xadrez;

import br.com.compassuol.xadrez.boardgame.Tabuleiro;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;
    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getRow()][tabuleiro.getColumn()];
        for(int i = 0; i<tabuleiro.getRow(); i++){
            for(int j=0; j<tabuleiro.getColumn();j++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }
        }
        return mat;
    }
}
