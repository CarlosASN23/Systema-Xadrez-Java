package br.com.compassuol.xadrez.boardgame;

public class Posicao {

    private int row;
    private int column;


    public Posicao(){

    }

    public Posicao(int row, int column){
        this.row = row;
        this.column = column;
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

    public void setColumn(int collumn) {
        this.column = collumn;
    }

    @Override
    public String toString() {
        return row + "," + column;
    }
}
