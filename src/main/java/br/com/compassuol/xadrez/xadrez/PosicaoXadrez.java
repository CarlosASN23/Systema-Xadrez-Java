package br.com.compassuol.xadrez.xadrez;

import br.com.compassuol.xadrez.boardgame.Posicao;

public class PosicaoXadrez {

    private char column;
    private int row;

    public PosicaoXadrez(char column, int row) {
        if(column <'a' || column > 'h' || row < 1 || row > 8){
            throw new XadrezExcecao("Erro de instanciação: valores inválidos para as linhas e colunas");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Posicao toPosition(){
        return new Posicao(8 - row, column-'a');
    }

    protected static PosicaoXadrez fromPosition (Posicao posicao){
        return new PosicaoXadrez((char)('a' + posicao.getColumn()),8- posicao.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row;
    }
}
