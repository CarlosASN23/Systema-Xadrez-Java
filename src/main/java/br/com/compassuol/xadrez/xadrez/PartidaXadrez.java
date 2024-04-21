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

    private void initialSetup(){
        tabuleiro.lugarPeca(new Torre(tabuleiro,Color.WHITE),new Posicao(2,1));
        tabuleiro.lugarPeca(new Rei(tabuleiro,Color.BLACK),new Posicao(0,4));
        tabuleiro.lugarPeca(new Rei(tabuleiro,Color.WHITE),new Posicao(7,4));
    }
}
