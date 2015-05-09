package br.fjn.ed.model;

import java.awt.Color;

public class Cubo {
	private Face topo;
	private Face frente;
	private Face base;
	private Face tras;
	private Face esquerda;
	private Face direita;

	public Cubo() {
		topo = new Face(Color.WHITE, "Branco");
		frente = new Face(Color.BLUE, "Azul");
		base = new Face(Color.YELLOW, "Amarelo");
		tras = new Face(Color.RED, "Vermelho");
		esquerda = new Face(Color.GREEN, "Verde");
		direita = new Face(Color.ORANGE, "Laranja");
	}

	public void girarBaseEsquerda() {
		Peca[] linhaFrente = frente.getLinha(3);
		Peca[] linhaEsquerda = esquerda.getLinha(3);
		Peca[] linhaTras = tras.getLinha(3);
		Peca[] linhaDireita = direita.getLinha(3);
		
		frente.setLinha(3, linhaDireita);
		esquerda.setLinha(3, linhaFrente);
		tras.setLinha(3, linhaEsquerda);
		direita.setLinha(3, linhaTras);
		
		base.girar90Graus(Orientacao.ESQUERDA);
	}
	public void girarBaseDireita() {
		Peca[] linhaFrente = frente.getLinha(3);
		Peca[] linhaEsquerda = esquerda.getLinha(3);
		Peca[] linhaTras = tras.getLinha(3);
		Peca[] linhaDireita = direita.getLinha(3);
		
		frente.setLinha(3, linhaEsquerda);
		esquerda.setLinha(3, linhaTras);
		tras.setLinha(3, linhaDireita);
		direita.setLinha(3, linhaFrente);
		
		base.girar90Graus(Orientacao.DIREITA);
	}

	public void girarTopoEsquerda() {
		Peca[] linhaFrente = frente.getLinha(1);
		Peca[] linhaEsquerda = esquerda.getLinha(1);
		Peca[] linhaTras = tras.getLinha(1);
		Peca[] linhaDireita = direita.getLinha(1);
		
		frente.setLinha(1, linhaDireita);
		esquerda.setLinha(1, linhaFrente);
		tras.setLinha(1, linhaEsquerda);
		direita.setLinha(1, linhaTras);
		
		topo.girar90Graus(Orientacao.ESQUERDA);
	}
	public void girarTopoDireita() {
		Peca[] linhaFrente = frente.getLinha(1);
		Peca[] linhaEsquerda = esquerda.getLinha(1);
		Peca[] linhaTras = tras.getLinha(1);
		Peca[] linhaDireita = direita.getLinha(1);
		
		frente.setLinha(1, linhaEsquerda);
		esquerda.setLinha(1, linhaTras);
		tras.setLinha(1, linhaDireita);
		direita.setLinha(1, linhaFrente);
		
		topo.girar90Graus(Orientacao.DIREITA);
	}

	public void girarEsquerdaBaixo() {
		Peca[] colunaFrente = frente.getColuna(1);
		Peca[] colunaBase = base.getColuna(1);
		Peca[] colunaTopo = topo.getColuna(1);
		Peca[] colunaTras = tras.getColuna(1);
		
		topo.setColuna(1, colunaTras);
		frente.setColuna(1, colunaTopo);
		base.setColuna(1, colunaFrente);
		tras.setColuna(1, colunaBase);
		
		esquerda.girar90Graus(Orientacao.DIREITA);
	}
	public void girarEsquerdaCima() {
		Peca[] colunaFrente = frente.getColuna(1);
		Peca[] colunaBase = base.getColuna(1);
		Peca[] colunaTopo = topo.getColuna(1);
		Peca[] colunaTras = tras.getColuna(1);
		
		topo.setColuna(1, colunaFrente);
		frente.setColuna(1, colunaBase);
		base.setColuna(1, colunaTras);
		tras.setColuna(1, colunaTopo);
		
		esquerda.girar90Graus(Orientacao.ESQUERDA);
	}
	
	public void girarDireitaBaixo() {
		Peca[] colunaFrente = frente.getColuna(3);
		Peca[] colunaBase = base.getColuna(3);
		Peca[] colunaTopo = topo.getColuna(3);
		Peca[] colunaTras = tras.getColuna(3);
		
		topo.setColuna(3, colunaTras);
		frente.setColuna(3, colunaTopo);
		base.setColuna(3, colunaFrente);
		tras.setColuna(3, colunaBase);
		
		direita.girar90Graus(Orientacao.DIREITA);
	}
	public void girarDireitaCima() {
		Peca[] colunaFrente = frente.getColuna(3);
		Peca[] colunaBase = base.getColuna(3);
		Peca[] colunaTopo = topo.getColuna(3);
		Peca[] colunaTras = tras.getColuna(3);
		
		topo.setColuna(3, colunaFrente);
		frente.setColuna(3, colunaBase);
		base.setColuna(3, colunaTras);
		tras.setColuna(3, colunaTopo);
		
		direita.girar90Graus(Orientacao.ESQUERDA);
	}
	
	public void girarCentroBaixo() {
		Peca[] colunaFrente = frente.getColuna(2);
		Peca[] colunaBase = base.getColuna(2);
		Peca[] colunaTopo = topo.getColuna(2);
		Peca[] colunaTras = tras.getColuna(2);
		
		topo.setColuna(2, colunaTras);
		frente.setColuna(2, colunaTopo);
		base.setColuna(2, colunaFrente);
		tras.setColuna(2, colunaBase);
	}
	public void girarCentroCima() {
		Peca[] colunaFrente = frente.getColuna(2);
		Peca[] colunaBase = base.getColuna(2);
		Peca[] colunaTopo = topo.getColuna(2);
		Peca[] colunaTras = tras.getColuna(2);
		
		topo.setColuna(2, colunaFrente);
		frente.setColuna(2, colunaBase);
		base.setColuna(2, colunaTras);
		tras.setColuna(2, colunaTopo);
	}
	public void girarCentroEsquerda() {
		Peca[] linhaFrente = frente.getLinha(2);
		Peca[] linhaEsquerda = esquerda.getLinha(2);
		Peca[] linhaTras = tras.getLinha(2);
		Peca[] linhaDireita = direita.getLinha(2);
		
		frente.setLinha(2, linhaDireita);
		esquerda.setLinha(2, linhaFrente);
		tras.setLinha(2, linhaEsquerda);
		direita.setLinha(2, linhaTras);
	}
	public void girarCentroDireita() {
		Peca[] linhaFrente = frente.getLinha(2);
		Peca[] linhaEsquerda = esquerda.getLinha(2);
		Peca[] linhaTras = tras.getLinha(2);
		Peca[] linhaDireita = direita.getLinha(2);
		
		frente.setLinha(2, linhaEsquerda);
		esquerda.setLinha(2, linhaTras);
		tras.setLinha(2, linhaDireita);
		direita.setLinha(2, linhaFrente);
	}
	
	public Face getTopo() {
		return topo;
	}
	public Face getFrente() {
		return frente;
	}
	public Face getBase() {
		return base;
	}
	public Face getTras() {
		return tras;
	}
	public Face getEsquerda() {
		return esquerda;
	}
	public Face getDireita() {
		return direita;
	}

	public String toString() {
		String s = new String();
		
		s += "\nTopo\n";
		s += topo.toString()+"\n";
		
		s += "\nFrente\n";
		s += frente.toString()+"\n"; 
		
		s += "\nBase\n";
		s += base.toString()+"\n";
		
		s += "\nEsquerda\n";
		s += esquerda.toString()+"\n";
		
		s += "\nDireita\n";
		s += direita.toString()+"\n";
		
		s += "\nTras\n";
		s += tras.toString()+"\n";
		
		return s;
	}
}