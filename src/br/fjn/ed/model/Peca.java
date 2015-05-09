package br.fjn.ed.model;

import java.awt.Color;

public class Peca {
	private int indice;
	private Color cor;
	private String texto;
	
	public Peca(int indice, Color cor, String texto) {
		setIndice(indice);
		setCor(cor);
		setTexto(texto);
	}
	
	public int getIndice() {
		return indice;
	}
	private void setIndice(int indice) {
		this.indice = indice;
	}
	public Color getCor() {
		return cor;
	}
	private void setCor(Color cor) {
		this.cor = cor;
	}
	public String getTexto() {
		return texto;
	}
	private void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String toString() {
		return texto;
	}
}
