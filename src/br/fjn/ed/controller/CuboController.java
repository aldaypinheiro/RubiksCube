package br.fjn.ed.controller;

import br.fjn.ed.model.Lado;
import br.fjn.ed.model.Orientacao;

public class CuboController {

	private CuboAdapter cuboAdapter;

	public CuboController() {
		cuboAdapter = new CuboAdapter();
	}

	public RuntimeException lancaErro() {
		return new RuntimeException("Impossível fazer este movimento");
	}

	public void girar(Lado lado, Orientacao orientacao) {
		switch (lado) {
		case ESQUERDA:
			switch (orientacao) {
			case CIMA:
				cuboAdapter.leftTopSpin(1);
				break;
			case BAIXO:
				cuboAdapter.leftBottomSpin(1);
				break;
			case ESQUERDA:
				throw lancaErro();
			case DIREITA:
				throw lancaErro();
			}
			break;
		case DIREITA:
			switch (orientacao) {
			case CIMA:
				cuboAdapter.rightTopSpin(1);
				break;
			case BAIXO:
				cuboAdapter.rightBottomSpin(1);
				break;
			case ESQUERDA:
				throw lancaErro();
			case DIREITA:
				throw lancaErro();
			}
			break;
		case CENTRO:
			switch (orientacao) {
			case CIMA:
				cuboAdapter.centerTopSpin(1);
				break;
			case BAIXO:
				cuboAdapter.centerBottomSpin(1);
				break;
			case ESQUERDA:
				cuboAdapter.middleLeftSpin(1);
				break;
			case DIREITA:
				cuboAdapter.middleRightSpin(1);
				break;
			}
			break;
		case TOPO:
			switch (orientacao) {
			case CIMA:
				throw lancaErro();
			case BAIXO:
				throw lancaErro();
			case ESQUERDA:
				cuboAdapter.topLeftSpin(1);
				break;
			case DIREITA:
				cuboAdapter.topRightSpin(1);
				break;
			}
			break;
		case BASE:
			switch (orientacao) {
			case CIMA:
				throw lancaErro();
			case BAIXO:
				throw lancaErro();
			case ESQUERDA:
				cuboAdapter.bottomLeftSpin(1);
				break;
			case DIREITA:
				cuboAdapter.bottomRightSpin(1);
				break;
			}
			break;
		}
	}

	public void girar(Lado lado, Orientacao orientacao, int vezes) {
		switch (lado) {
		case ESQUERDA:
			switch (orientacao) {
			case CIMA:
				cuboAdapter.leftTopSpin(vezes);
				break;
			case BAIXO:
				cuboAdapter.leftBottomSpin(vezes);
				break;
			case ESQUERDA:
				throw lancaErro();
			case DIREITA:
				throw lancaErro();
			}
			break;
		case DIREITA:
			switch (orientacao) {
			case CIMA:
				cuboAdapter.rightTopSpin(vezes);
				break;
			case BAIXO:
				cuboAdapter.rightBottomSpin(vezes);
				break;
			case ESQUERDA:
				throw lancaErro();
			case DIREITA:
				throw lancaErro();
			}
			break;
		case CENTRO:
			switch (orientacao) {
			case CIMA:
				cuboAdapter.centerTopSpin(vezes);
				break;
			case BAIXO:
				cuboAdapter.centerBottomSpin(vezes);
				break;
			case ESQUERDA:
				cuboAdapter.middleLeftSpin(vezes);
				break;
			case DIREITA:
				cuboAdapter.middleRightSpin(vezes);
				break;
			}
			break;
		case TOPO:
			switch (orientacao) {
			case CIMA:
				throw lancaErro();
			case BAIXO:
				throw lancaErro();
			case ESQUERDA:
				cuboAdapter.topLeftSpin(vezes);
				break;
			case DIREITA:
				cuboAdapter.topRightSpin(vezes);
				break;
			}
			break;
		case BASE:
			switch (orientacao) {
			case CIMA:
				throw lancaErro();
			case BAIXO:
				throw lancaErro();
			case ESQUERDA:
				cuboAdapter.bottomLeftSpin(vezes);
				break;
			case DIREITA:
				cuboAdapter.bottomRightSpin(vezes);
				break;
			}
			break;
		}
	}

	public CuboAdapter getCuboAdapter() {
		return cuboAdapter;
	}

	public String toString() {
		return cuboAdapter.toString();
	}
}
