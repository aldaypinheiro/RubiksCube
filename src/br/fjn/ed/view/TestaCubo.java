package br.fjn.ed.view;

import br.fjn.ed.controller.CuboController;
import br.fjn.ed.model.Orientacao;
import br.fjn.ed.model.Lado;

public class TestaCubo {
	public static void main(String[] args) {
		CuboController cc = new CuboController();
		
		cc.girar(Lado.TOPO, Orientacao.DIREITA);//girarTopoDireita();
		cc.girar(Lado.DIREITA, Orientacao.CIMA);//girarDireitaCima();
		System.out.println(cc);
	}
}
