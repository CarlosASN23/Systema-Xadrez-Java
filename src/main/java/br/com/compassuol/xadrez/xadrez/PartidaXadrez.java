package br.com.compassuol.xadrez.xadrez;

import br.com.compassuol.xadrez.boardgame.Pecas;
import br.com.compassuol.xadrez.boardgame.Posicao;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;
import br.com.compassuol.xadrez.boardgame.TabuleiroExeccoes;
import br.com.compassuol.xadrez.xadrez.peca.Rei;
import br.com.compassuol.xadrez.xadrez.peca.Torre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartidaXadrez {

    private boolean checkMatch;
    private boolean check;
    private int turn;
    private Color currentPlayer;
    private Tabuleiro tabuleiro;
    private List<Pecas> capturedpiece = new ArrayList<>();
    private List<Pecas> piecesOnBoard = new ArrayList<>();


    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn(){
        return turn;
    }

    public Color getCurrentePlayer(){
        return currentPlayer;
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

    public boolean[][] movimentosPossiveis(PosicaoXadrez buscarPosicao){
        Posicao posicao = buscarPosicao.toPosition();
        validateSourcePosition(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }
    public PecaXadrez performaceMovimentoXadrez(PosicaoXadrez buscarPosicao, PosicaoXadrez posicaoEncontrada){

        Posicao busca = buscarPosicao.toPosition();
        Posicao encontrar = posicaoEncontrada.toPosition();

        validateSourcePosition(busca);
        validateTargetPosition(busca,encontrar);

        Pecas pecaCapturada = makeMove(busca,encontrar);

        if(testCheck(currentPlayer)){
            undoMove(busca,encontrar,pecaCapturada);
            throw new XadrezExcecao("Você não pode se colocar em check");
        }

        check = (testCheck(opponent(currentPlayer))) ? true : false;

        if(testCheckMatch(opponent(currentPlayer))){
            checkMatch= true
        }else{
            nextTurn();
        }
        return (PecaXadrez) pecaCapturada;
    }

    private Pecas makeMove(Posicao busca, Posicao encontrar){
        Pecas p = tabuleiro.removePeca(busca);
        Pecas pecaCapturada = tabuleiro.removePeca(encontrar);
        tabuleiro.lugarPeca(p,encontrar);

        if(pecaCapturada != null){
            piecesOnBoard.remove(pecaCapturada);
            capturedpiece.add(pecaCapturada);
        }
        return pecaCapturada;
    }

    private void validateTargetPosition(Posicao busca, Posicao encontrar){
        if (!tabuleiro.peca(busca).movimentosPossiveis(encontrar)){
            throw new XadrezExcecao("A peça não pode mexer para a posição escolhida");
        }
    }

    private void validateSourcePosition(Posicao posicao){
        if (!tabuleiro.temUmaPeca(posicao)){
            throw new TabuleiroExeccoes("Não há peças na posição buscada");
        }
        if(currentPlayer != ((PecaXadrez)tabuleiro.peca(posicao)).getColor()){
            throw new XadrezExcecao("A peça escolhida não é sua");
        }
        if(!tabuleiro.peca(posicao).temMovimentosPossiveis()){
            throw new XadrezExcecao("Não existe movimentos possiveis para a peça escolhida");
        }
    }

    private void lugarNovoPeca(char column, int row, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new PosicaoXadrez(column, row).toPosition());
        piecesOnBoard.add(peca);
    }

    private void initialSetup(){
        lugarNovoPeca('c',1, new Torre(tabuleiro,Color.WHITE));
        lugarNovoPeca('c',2, new Torre(tabuleiro,Color.WHITE));
        lugarNovoPeca('d',2, new Torre(tabuleiro,Color.WHITE));
        lugarNovoPeca('e',2, new Torre(tabuleiro,Color.WHITE));
        lugarNovoPeca('e',1, new Torre(tabuleiro,Color.WHITE));
        lugarNovoPeca('d',1,new Rei(tabuleiro,Color.WHITE));

        lugarNovoPeca('c',7, new Torre(tabuleiro,Color.BLACK));
        lugarNovoPeca('c',8, new Torre(tabuleiro,Color.BLACK));
        lugarNovoPeca('d',7, new Torre(tabuleiro,Color.BLACK));
        lugarNovoPeca('e',7, new Torre(tabuleiro,Color.BLACK));
        lugarNovoPeca('e',8, new Torre(tabuleiro,Color.BLACK));
        lugarNovoPeca('d',8,new Rei(tabuleiro,Color.BLACK));
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void undoMove(Posicao busca, Posicao encontrar, Pecas pecaCapturada){
        Pecas p = tabuleiro.removePeca(encontrar);
        tabuleiro.lugarPeca(p,busca);

        if(pecaCapturada != null){
            tabuleiro.lugarPeca(pecaCapturada,encontrar);
            capturedpiece.remove(pecaCapturada);
            piecesOnBoard.add(pecaCapturada);
        }
    }
    private Color opponent(Color color){
        return (color == Color.WHITE) ? Color.BLACK: Color.WHITE;
    }

    private PecaXadrez rei(Color color){
        List<Pecas> list = piecesOnBoard.stream().filter(x->((PecaXadrez)x).getColor() == color).collect(Collectors.toList());
        for (Pecas p : list){
            if(p instanceof Rei){
                return (PecaXadrez) p;
            }
        }
        throw new IllegalStateException("Não há no " + color + " Rei no tabuleiro");
    }

    private boolean testCheck(Color color){
        Posicao reiPosicao = rei(color).getPosicaoXadrez().toPosition();
        List<Pecas> opponentPieces = piecesOnBoard.stream().filter(x->((PecaXadrez)x).getColor()==opponent(color)).collect(Collectors.toList());
        for(Pecas p : opponentPieces){
            boolean[][] mat = p.movimentosPossiveis();
            if(mat[reiPosicao.getRow()][reiPosicao.getColumn()]){
                return true;
            }
        }
        return false;
    }

    public boolean getCheck(){
        return check;
    }
    public boolean getCheckMatch(){
        return checkMatch;
    }

    private boolean testCheckMatch(Color color){
        if (!testCheck(color)){
            return false;
        }
        List<Pecas>list = piecesOnBoard.stream().filter(x->((PecaXadrez)x).getColor() == color).collect(Collectors.toList());
        for (Pecas p:list){
            boolean [][] mat = p.movimentosPossiveis();
            for(int i = 0; i<tabuleiro.getRow(); i++){
                for(int j =0; j< tabuleiro.getColumn(); j++){
                    if(mat[i][j]){
                        Posicao busca = ((PecaXadrez)p).getPosicaoXadrez().toPosition();
                        Posicao encontrar = new Posicao(i, j);
                        Pecas pecaCapturada = makeMove(busca, encontrar);
                        boolean testCheck = testCheck(color);
                        undoMove(busca,encontrar,pecaCapturada);
                        if(!testCheck){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
