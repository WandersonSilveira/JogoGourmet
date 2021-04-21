/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelView, que � a camada de visualiza��o.
 * As fun��es da tela s�o realizadas do meio de um controlador(JogoGourmetController).
 */

package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AlimentoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JogoGourmetView extends JFrame {
	
	private JPanel principalPane;
	Integer resposta = 0; 
	
	private void exibeTela() {
		
		/*Tela de perguntas*/
		do {
			 
			 Object[] options = { "Yes", "No" };
			 
			 resposta = JOptionPane.showOptionDialog(
						null, "A comida que voc� pensou � " + AlimentoController.gerarPergunta() +
						" ?","Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]
						);
			 
		}while(AlimentoController.validaResposta(resposta) == 0);
		
		 /*Tela de acerto*/				 
		 if(AlimentoController.validaResposta(resposta) == 1) {
			 JOptionPane.showMessageDialog(null, "Acertei de novo!");
			 AlimentoController.recomecaJogo();
		 }
		 /*Tela de cadastro*/
		 else if(AlimentoController.validaResposta(resposta) == 2) {
				 String nomeComida = JOptionPane.showInputDialog("Qual prato voc� pensou?");
				 String tipoComida = JOptionPane.showInputDialog(nomeComida +" � _______ e "+
				 AlimentoController.retornaNomeUltimoAlimento()+" n�o �:");
					
			 AlimentoController.adicionarAlimentoNovo(tipoComida, nomeComida);
			 AlimentoController.recomecaJogo();
		 }
	}

	/**
	 * Inicia a aplica��o.
	 * Muitas a��es da camada view s�o feitas a partir de um controller(JogoGourmetController).
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlimentoController.perguntasIniciais();
					JogoGourmetView frame = new JogoGourmetView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria��o do frame
	 */
	public JogoGourmetView() {
		/*Painel*/
		setTitle("Jogo Gourmet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 127);
		principalPane = new JPanel();
		principalPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(principalPane);
		principalPane.setLayout(null);
		
		/*Bot�o Ok*/
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*M�todo que chamas as telas*/
				exibeTela();
			}
		});	
		btnOk.setBounds(103, 37, 57, 23);
		principalPane.add(btnOk);
		
		/*Label*/
		JLabel lblPensePrato = new JLabel("Pense em um prato que gosta");
		lblPensePrato.setBounds(45, 11, 170, 14);
		principalPane.add(lblPensePrato);
	}
}
