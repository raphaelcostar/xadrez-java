package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		UI.printBoard(partida.getPecas());

		while (true) {
			try {
				UI.limparTela();
				UI.printJogo(partida);
				System.out.println();
				System.out.println("Origem: ");
				PosicaoXadrez origem = UI.leiaAPosicaoNoXadres(sc);

				boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
				UI.limparTela();
				UI.printBoard(partida.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.println("Destino:");
				PosicaoXadrez destino = UI.leiaAPosicaoNoXadres(sc);

				PecaDeXadrez pecaCapturada = partida.movimentoNoXadrez(origem, destino);
			} 
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}