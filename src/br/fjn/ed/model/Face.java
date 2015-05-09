package br.fjn.ed.model;

import java.awt.Color;

public class Face {
	private Peca[][] pecas;

	public Face(Color cor, String texto) {
		pecas = new Peca[3][3];
		int cont = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Peca p = new Peca(cont++, cor, texto);
				pecas[i][j] = p;
			}
		}
	}

	public Peca getPeca(int linha, int coluna) {
		if (linha > 3) {
			throw new RuntimeException("Número de linha inválido!");
		} else if (linha < 0) {
			throw new RuntimeException("Número de linha inválido!");
		} else if (coluna > 3) {
			throw new RuntimeException("Número de coluna inválido!");
		} else if (coluna < 0) {
			throw new RuntimeException("Número de coluna inválido!");
		}
		
		return pecas[linha][coluna];
	}

	public Peca[] getLinha(int numero) {
		if (numero > 3) {
			throw new RuntimeException("Número inválido!");
		} else if (numero < 0) {
			throw new RuntimeException("Número inválido!");
		}
		
		Peca[] linha = new Peca[3];
		
		numero -= 1;
		
		for (int i = 0; i < 3; i++) {
			linha[i] = pecas[numero][i];
		}

		return linha;
	}

	public Peca[] getColuna(int numero) {
		if (numero > 3) {
			throw new RuntimeException("Número inválido!");
		} else if (numero < 0) {
			throw new RuntimeException("Número inválido!");
		}
		
		Peca[] coluna = new Peca[3];

		numero -= 1;
		
		for (int i = 0; i < 3; i++) {
			coluna[i] = pecas[i][numero];
		}

		return coluna;
	}

	public void setLinha(int numero, Peca[] linha) {
		if (linha.length < 3 || linha.length > 3) {
			throw new RuntimeException("Tamanho da Linha inválido!");
		} else if (numero > 3) {
			throw new RuntimeException("Número inválido!");
		} else if (numero < 0) {
			throw new RuntimeException("Número inválido!");
		}
		
		numero -= 1;
		
		for (int i = 0; i < 3; i++) {
			pecas[numero][i] = linha[i];
		}
	}

	public void setColuna(int numero, Peca[] coluna) {
		if (coluna.length < 3 || coluna.length > 3) {
			throw new RuntimeException("Tamanho da Coluna inválido!");
		} else if (numero > 3) {
			throw new RuntimeException("Número inválido!");
		} else if (numero < 0) {
			throw new RuntimeException("Número inválido!");
		}
		
		numero -= 1;
		
		for (int i = 0; i < 3; i++) {
			pecas[i][numero] = coluna[i];
		}
	}

	public void girar90Graus(Orientacao orientacao) {
		switch (orientacao) {
		case ESQUERDA:
			System.out.println("Esquerda");
			Peca[] primeiraColuna = getColuna(1);
			Peca[] segundaColuna = getColuna(2);
			Peca[] terceiraColuna = getColuna(3);

			setLinha(1, primeiraColuna);
			setLinha(2, segundaColuna);
			setLinha(3, terceiraColuna);
			
			break;
		case DIREITA:
			System.out.println("Direita");
			Peca[] colunaUm = getColuna(1);
			Peca[] colunaDois = getColuna(2);
			Peca[] colunaTres = getColuna(3);

			setLinha(1, colunaTres);
			setLinha(2, colunaDois);
			setLinha(3, colunaUm);
			
			break;
		case CIMA:
			throw new RuntimeException("Movimento Inválido!");
		case BAIXO:
			throw new RuntimeException("Movimento Inválido!");
		}
	}

	public String toString() {
		String s = new String();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j < 2) {
					s += pecas[i][j].toString() + " | ";
				} else {
					s += pecas[i][j].toString();
				}
			}
			s += "\n";
		}

		return s;
	}
}