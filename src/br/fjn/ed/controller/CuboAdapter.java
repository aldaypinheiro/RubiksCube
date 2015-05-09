package br.fjn.ed.controller;

import br.fjn.ed.model.Cubo;
import br.fjn.ed.model.Rubik;

public class CuboAdapter implements Rubik {

	private Cubo cubo;

	public CuboAdapter() {
		cubo = new Cubo();
	}
	
	public Cubo getCubo() {
		return cubo;
	}
	
	public void lancaErro() {
		throw new RuntimeException("Face Inconrreta");
	}

	@Override
	public String[][] getFace(char face) {

		/*
		 * Face A = Direita Face B = Frente Face C = Esquerda Face D = Trás Face
		 * E = Topo Face F = Base
		 */

		boolean teste = (face == 'A' || face == 'B' || face == 'C'
				|| face == 'D' || face == 'E' || face == 'F');
		String[][] retorno = new String[3][3];

		if (teste == false)
			lancaErro();

		switch (face) {
		case 'A':
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					retorno[i][j] = cubo.getDireita().getPeca(i, j).getTexto();
				}
			}
			break;

		case 'B':
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					retorno[i][j] = cubo.getFrente().getPeca(i, j).getTexto();
				}
			}
			break;
		case 'C':
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					retorno[i][j] = cubo.getEsquerda().getPeca(i, j).getTexto();
				}
			}
			break;
		case 'D':
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					retorno[i][j] = cubo.getTras().getPeca(i, j).getTexto();
				}
			}
			break;
		case 'E':
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					retorno[i][j] = cubo.getTopo().getPeca(i, j).getTexto();
				}
			}
			break;
		case 'F':
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					retorno[i][j] = cubo.getBase().getPeca(i, j).getTexto();
				}
			}
			break;
		}

		return retorno;
	}

	@Override
	public void topRightSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarTopoDireita();
		}
	}

	@Override
	public void topLeftSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarTopoEsquerda();
		}
	}

	@Override
	public void middleRightSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarCentroDireita();
		}
	}

	@Override
	public void middleLeftSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarCentroEsquerda();
		}
	}

	@Override
	public void bottomRightSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarBaseDireita();
		}
	}

	@Override
	public void bottomLeftSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarBaseEsquerda();
		}
	}

	@Override
	public void rightTopSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarDireitaCima();
		}
	}

	@Override
	public void rightBottomSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarDireitaBaixo();
		}
	}

	@Override
	public void leftTopSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarEsquerdaCima();
		}
	}

	@Override
	public void leftBottomSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarEsquerdaBaixo();
		}
	}

	@Override
	public void centerTopSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarCentroCima();
		}
	}

	@Override
	public void centerBottomSpin(int times) {
		for (int i = 0; i < times; i++) {
			cubo.girarCentroBaixo();
		}
	}

	public String toString() {
		return cubo.toString();
	}
}
