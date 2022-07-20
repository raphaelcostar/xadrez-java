package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	private Cor jogadorAtual;
	private int turno;
	
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.WHITE;
		initialSetup();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogadorAtual() {
		return jogadorAtual;
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
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoDeOrigem) {
		Posicao posicao = posicaoDeOrigem.paraAPosicao();
		validarPosicaoDeOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	
	public PecaDeXadrez movimentoNoXadrez(PosicaoXadrez posicaoDeOrigem, PosicaoXadrez posicaoDeDestino) {
		Posicao origem = posicaoDeOrigem.paraAPosicao();
		Posicao destino = posicaoDeDestino.paraAPosicao();
		validarPosicaoDeOrigem(origem);
		validarPosicaoDeDestino(origem, destino);
		Peca pecaCapturada = facaOMovimento(origem, destino);
		proximoTurno();
		return (PecaDeXadrez)pecaCapturada;
		
	}


	private void validarPosicaoDeOrigem(Posicao posicao) {
		if(!tabuleiro.eUmaPeca(posicao)) {
			throw new XadrezException("Não existe peça nesta posição");
		}
		if(jogadorAtual != ((PecaDeXadrez) tabuleiro.peca(posicao)).getCor()){
			throw new XadrezException("A peça escolhida não é sua");
			}
		if(!tabuleiro.peca(posicao).ePossivelMovimentar()) {
			throw new XadrezException("Não é possível movimentar esta peça");
		}
	}
	
	private void validarPosicaoDeDestino(Posicao origem, Posicao destino) {
		if(!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new XadrezException("A pessoa escolhida não pode se movimentar para o local selecionado");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}
	
	
	
	private Peca facaOMovimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.placePiece(p, destino);
		return pecaCapturada;
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
