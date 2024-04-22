package br.com.compassuol.xadrez.application;

import br.com.compassuol.xadrez.boardgame.Posicao;
import br.com.compassuol.xadrez.boardgame.Tabuleiro;
import br.com.compassuol.xadrez.xadrez.PartidaXadrez;
import br.com.compassuol.xadrez.xadrez.PecaXadrez;
import br.com.compassuol.xadrez.xadrez.PosicaoXadrez;
import br.com.compassuol.xadrez.xadrez.XadrezExcecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        PartidaXadrez partidaXadrez = new PartidaXadrez();
        Scanner sc = new Scanner(System.in);

        while(true){

            try{
            UI.limparTela();
            UI.printTabuleiro(partidaXadrez.getPecas());
            System.out.println();
            System.out.print("Buscar: ");
            PosicaoXadrez busca = UI.lerPosicaoXadrez(sc);

            boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(busca);
            UI.limparTela();
            UI.printTabuleiro(partidaXadrez.getPecas(),movimentosPossiveis);
            System.out.println();
            System.out.print("Encontrar: ");
            PosicaoXadrez encontrar = UI.lerPosicaoXadrez(sc);

            System.out.println();
            System.out.print("Entrada: ");
            PosicaoXadrez encontra = UI.lerPosicaoXadrez(sc);

            PecaXadrez pecaCapturada = partidaXadrez.performaceMovimentoXadrez(busca,encontrar);
            }
            catch (XadrezExcecao e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
