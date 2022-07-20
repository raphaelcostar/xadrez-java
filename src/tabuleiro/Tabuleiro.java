package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas; 
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new BoardException("Erro: � necess�rio que haja ao menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new BoardException("Posic�o n�o existe na tabela");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new BoardException("Posic�o n�o existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void placePiece(Peca peca, Posicao posicao) {
		if(eUmaPeca(posicao)) {
			throw new BoardException("J� existe uma pe�a no local");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	
	public boolean eUmaPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new BoardException("Posic�o n�o existe no tabuleiro");
		}
		return peca(posicao) != null; 
	}
	
	
}
