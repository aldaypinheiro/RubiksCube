package br.fjn.ed.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.fjn.ed.controller.CuboController;
import br.fjn.ed.model.Face;
import br.fjn.ed.model.Orientacao;
import br.fjn.ed.model.Lado;

public class View extends JFrame implements Serializable, ActionListener{

	private static final long serialVersionUID = 1L;
	private CuboController cc;
	private JComboBox<String> comboCondicoes;
	private JComboBox<String> comboDirecoes;
	private JButton girar, resetar;
	private JPanel faces;
	
	public View() {
		setTitle("Cubo de Rubik");
		setBounds(10, 10, 500, 250);
		setResizable(false);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cc = new CuboController();
		
		faces = configureFaces();
		
		add(faces, BorderLayout.NORTH);
		add(configureButtons(), BorderLayout.SOUTH);
	}

	private JPanel configureFaces() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(3, 3));

		JPanel[] paineis = new JPanel[9];

		paineis[0] = configureFace("Frente", cc.getCuboAdapter().getCubo().getFrente());
		paineis[1] = configureFace("Topo", cc.getCuboAdapter().getCubo().getTopo());
		paineis[2] = configureFace("Trás", cc.getCuboAdapter().getCubo().getTras());
		paineis[3] = configureFace();
		paineis[4] = configureFace();
		paineis[5] = configureFace();
		paineis[6] = configureFace("Base", cc.getCuboAdapter().getCubo().getBase());
		paineis[7] = configureFace("Esquerda", cc.getCuboAdapter().getCubo().getEsquerda());
		paineis[8] = configureFace("Direita", cc.getCuboAdapter().getCubo().getDireita());
		
		for (int i = 0; i < paineis.length; i++) {
			panel.add(paineis[i]);
		}
		
		return panel;
	}

	private JPanel configureFace() {
		JPanel panel = new JPanel();

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 25, 25);

		panel.add(label);

		label = new JLabel("");
		label.setBounds(0, 0, 50, 50);

		panel.add(label);

		return panel;
	}

	private JPanel configureFace(String nome, Face face) {
		JLabel label = new JLabel(nome);
		label.setBounds(0, 0, 25, 25);

		TableModel tableModel = new DefaultTableModel(3, 3);
		int cont = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				//JLabel rotulo = new JLabel(face.getPeca(i, j).getIndice()+"");
				//rotulo.setBackground(face.getPeca(i, j).getCor());
				tableModel.setValueAt(cont++, i, j);
				//tableModel.setValueAt(face.getPeca(i, j).getIndice(), i, j);
			}
		}

		JTable tabela = new JTable(tableModel);
		tabela.setCellSelectionEnabled(false);
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(false);
		tabela.setEnabled(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 75, 75);
		panel.setLayout(new GridLayout(1, 2));
		panel.add(label);
		panel.add(tabela);

		return panel;
	}

	private JPanel update() {
		return configureFaces();
	}

	private JPanel configureButtons() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 75);
		panel.setLayout(new FlowLayout());

		JLabel label;
		
		int linha = 0, coluna = 0;
		String[] condicoes = new String[6];
		for (int i = 0; i < condicoes.length; i++) {
			if (i < 3) {
				condicoes[i] = (linha++ + 1) + "º Linha";
			} else {
				condicoes[i] = (coluna++ + 1) + "º Coluna";
			}
		}

		comboCondicoes = new JComboBox<String>(condicoes);

		panel.add(comboCondicoes);

		String[] direcoes = { "esquerda", "direita", "cima", "baixo" };

		label = new JLabel(" para ");
		comboDirecoes = new JComboBox<String>(direcoes);

		panel.add(label);
		panel.add(comboDirecoes);
		
		girar = new JButton("Girar");
		girar.addActionListener(this);
		panel.add(girar);
		
		resetar = new JButton("Resetar");
		resetar.addActionListener(this);
		panel.add(resetar);
		
		return panel;
	}

	public static void main(String[] args) {
		View cuboRubik = new View();
		cuboRubik.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == girar) {
			String strCondicao = String.valueOf(comboCondicoes
					.getSelectedItem());
			String strDirecao = String.valueOf(comboDirecoes
					.getSelectedItem());
			Lado condicao = null;
			Orientacao direcao = null;

			if (strCondicao.equalsIgnoreCase("1º linha")) {
				condicao = Lado.TOPO;
			} else if (strCondicao.equalsIgnoreCase("2º linha")
					|| strCondicao.equalsIgnoreCase("2º coluna")) {
				condicao = Lado.CENTRO;
			} else if (strCondicao.equalsIgnoreCase("3º linha")) {
				condicao = Lado.BASE;
			} else if (strCondicao.equalsIgnoreCase("1º coluna")) {
				condicao = Lado.ESQUERDA;
			} else if (strCondicao.equalsIgnoreCase("3º coluna")) {
				condicao = Lado.DIREITA;
			} else {
				throw new RuntimeException(
						"Algum problema aconteceu na escolha da condição!");
			}

			if (strDirecao.equalsIgnoreCase("esquerda")) {
				direcao = Orientacao.ESQUERDA;
			} else if (strDirecao.equalsIgnoreCase("direita")) {
				direcao = Orientacao.DIREITA;
			} else if (strDirecao.equalsIgnoreCase("cima")) {
				direcao = Orientacao.CIMA;
			} else if (strDirecao.equalsIgnoreCase("baixo")) {
				direcao = Orientacao.BAIXO;
			} else {
				throw new RuntimeException(
						"Algum problema aconteceu na escolha da direção!");
			}
			
			System.out.println(condicao);
			System.out.println(direcao);
			
			try {
				cc.girar(condicao, direcao);
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, erro.getMessage());
			}
			
			System.out.println("Girou");
			System.out.println(cc);
			
			getContentPane().remove(faces);
			getContentPane().add(update(), BorderLayout.NORTH);
		} else if (evento.getSource() == resetar) {
			cc = new CuboController();
			System.out.println(cc);
		}
	}
}
