/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelView, que é a camada de visualização.
 * As funções da tela são realizadas do meio de um controlador(JogoGourmetController).
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
						null, "A comida que você pensou é " + AlimentoController.gerarPergunta() +
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
				 String nomeComida = JOptionPane.showInputDialog("Qual prato você pensou?");
				 String tipoComida = JOptionPane.showInputDialog(nomeComida +" é _______ e "+
				 AlimentoController.retornaNomeUltimoAlimento()+" não é:");
					
			 AlimentoController.adicionarAlimentoNovo(tipoComida, nomeComida);
			 AlimentoController.recomecaJogo();
		 }
	}

	/**
	 * Inicia a aplicação.
	 * Muitas ações da camada view são feitas a partir de um controller(JogoGourmetController).
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
	 * Criação do frame
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
		
		/*Botão Ok*/
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Método que chamas as telas*/
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
