package br.fjn.ed.model;


public interface Rubik {
	/**
	 * @return o cubo como uma string
	 */
	public String toString();
	
	/**
	 * @param face Uma das faces do cubo
	 *    |E|
	 * |A||B||C||D|
	 *    |F|
	 * @return Um array representando a face.
	 */
	public String[][] getFace(char face);
	
	/**
	 * Executa um giro no cubo no conjunto superior para direita
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void topRightSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto superior para esqueda
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void topLeftSpin(int times);

	/**
	 * Executa um giro no cubo no conjunto do meio para direita
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void middleRightSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto do meio para esqueda
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void middleLeftSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto inferior para direita
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void bottomRightSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto inferior para esqueda
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void bottomLeftSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto da direita para cima
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void rightTopSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto da direita para baixo
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void rightBottomSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto da esquerda para cima
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void leftTopSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto da esquerda para baixo
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void leftBottomSpin(int times);

	/**
	 * Executa um giro no cubo no conjunto da central para cima
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void centerTopSpin(int times);
	
	/**
	 * Executa um giro no cubo no conjunto da central para baixo
	 * @param times quantidade de vezes a qual o giro será executado
	 */
	public void centerBottomSpin(int times);
	
}