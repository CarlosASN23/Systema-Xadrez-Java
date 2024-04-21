package br.com.compassuol.xadrez.boardgame;

public abstract class Pecas {

    // Inicialização das variaveis
    protected  Posicao posicao;
    private Tabuleiro tabuleiro;

    // Criação do construtor com passagem de parâmetros
    public Pecas(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        posicao = null;
    }

    // Getters e Setters
    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis();

    public boolean movimentosPossiveis(Posicao posicao){
        return movimentosPossiveis()[posicao.getRow()][posicao.getColumn()];
    }

    public boolean temMovimentosPossiveis(){
        boolean [][] mat = movimentosPossiveis();
        for(int i =0; i< mat.length;i++){
            for(int j=0; j< mat.length;j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
