package xadrez;

import java.awt.Color;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		initialSetup();
	}

	public PecaDeXadrez[][] getPecas() {
		PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void lugarDaNovaPeca( char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.placePiece(peca, new PosicaoXadrez(coluna, linha).paraAPosicao());
	}
	
	private void initialSetup() {
		lugarDaNovaPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

		lugarDaNovaPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeca('e', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}
}
