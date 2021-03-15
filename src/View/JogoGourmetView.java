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

import Controller.JogoGourmetController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JogoGourmetView extends JFrame {

	private JPanel principalPane;
	Integer resposta = 0; /*0 - Pergunta | 1 - Acerto | 2 - Cadastro novo*/

	
	private void exibeTela() {
		
		/*Tela de perguntas*/
		 if(JogoGourmetController.validaResposta(resposta) == 0) {
			 
			 Object[] options = { "Yes", "No" };
			 
			 resposta = JOptionPane.showOptionDialog(
						null, "A comida que você pensou é " + JogoGourmetController.gerarPergunta() +
						" ?","Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0]
						);
								
			 /*Chama tela de perguntas até haver uma conclusão*/	
			 exibeTela();
				
		 }
		 /*Tela de acerto*/				 
		 else if(JogoGourmetController.validaResposta(resposta) == 1) {
			 JOptionPane.showMessageDialog(null, "Acertei de novo!");
			 JogoGourmetController.recomecaJogo(true);
		 }
		 /*Tela de cadastro*/
		 else if(JogoGourmetController.validaResposta(resposta) == 2) {
				 String nomeComida = JOptionPane.showInputDialog("Qual prato você pensou?");
				 String tipoComida = JOptionPane.showInputDialog(nomeComida +" é _______ e "+
				 JogoGourmetController.retornaUltimoNomeAlimento()+" não é:");
					
			 JogoGourmetController.adicionarAlimentoNovo(tipoComida, nomeComida);
			 
			 JogoGourmetController.recomecaJogo(false);
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
					JogoGourmetController.perguntasIniciais();
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
