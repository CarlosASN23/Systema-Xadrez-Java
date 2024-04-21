package br.com.compassuol.xadrez.boardgame;

public class Tabuleiro {

    private int row;
    private int column;
    private Pecas[][] pecas;

    public Tabuleiro(int row,int column){
        if(row<1 || column < 1){
            throw new TabuleiroExeccoes("Erro na criação do tabuleiro: é necessário que haja uma linha e uma coluna");
        }
        this.column = column;
        this.row = row;
        pecas = new Pecas[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Pecas peca(int row, int column){

        if(!posicaoExistente(row,column)){
            throw new TabuleiroExeccoes("Posição não encontrada no tabuleiro");
        }
        return pecas[row][column];
    }

    public Pecas peca(Posicao posicao){

        if(!posicaoExistente(posicao)){
            throw new TabuleiroExeccoes("Posição não encontrada no tabuleiro");
        }
        return pecas[posicao.getRow()][posicao.getColumn()];
    }

    public void lugarPeca( Pecas peca, Posicao posicao){
        if(temUmaPeca(posicao)){
            throw new TabuleiroExeccoes("Já existe uma peça na posição: " + posicao);
        }
        pecas[posicao.getRow()][posicao.getColumn()] = peca;
        peca.posicao = posicao;
    }

    private boolean posicaoExistente(int rows, int columns){
        return rows >=0 && rows < row && columns >= 0 && columns < column;
    }
    public boolean posicaoExistente(Posicao posicao){
        return posicaoExistente(posicao.getRow(), posicao.getColumn());
    }

    public boolean temUmaPeca(Posicao posicao){
        if(!posicaoExistente(posicao)){
            throw new TabuleiroExeccoes("Posição não encontrada no tabuleiro");
        }
       return peca(posicao) != null;
    }
}
