package aplicacao;

import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		UI.printBoard(partida.getPecas());
		
		while(true) {
			UI.printBoard(partida.getPecas());
			System.out.println();
			System.out.println("Origem: ");
			PosicaoXadrez origem = UI.leiaAPosicaoNoXadres(sc);
			
			System.out.println();
			System.out.println("Destino:");
			PosicaoXadrez destino = UI.leiaAPosicaoNoXadres(sc);
			
			PecaDeXadrez pecaCapturada = partida.movimentoNoXadrez(origem, destino);
		}
	}
}
