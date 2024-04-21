package br.com.compassuol.xadrez.xadrez;

import br.com.compassuol.xadrez.boardgame.Posicao;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;
import br.com.compassuol.xadrez.xadrez.peca.Rei;
import br.com.compassuol.xadrez.xadrez.peca.Torre;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;
    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        initialSetup();
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

    private void lugarNovoPeca(char column, int row, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new PosicaoXadrez(column, row).toPosition());
    }

    private void initialSetup(){
        lugarNovoPeca('b',6, new Torre(tabuleiro,Color.WHITE));
        lugarNovoPeca('e',8,new Rei(tabuleiro,Color.BLACK));
        lugarNovoPeca('e',1,new Rei(tabuleiro,Color.WHITE));
    }
}
