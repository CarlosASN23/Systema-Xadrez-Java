package br.com.compassuol.xadrez.boardgame;

public class Tabuleiro {

    private int row;
    private int column;
    private Pecas[][] pecas;

    public Tabuleiro(int row,int column){
        this.column = column;
        this.row = row;
        pecas = new Pecas[row][column];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Pecas peca(int row, int column){
        return pecas[row][column];
    }

    public Pecas peca(Posicao posicao){
        return pecas[posicao.getRow()][posicao.getColumn()];
    }
}
