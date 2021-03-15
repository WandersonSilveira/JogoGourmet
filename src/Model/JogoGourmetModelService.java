/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelService, que possui as fun��es e regras de neg�cio do sistema.
 */

package Model;

import java.util.HashMap;
import java.util.Map.Entry;

public class JogoGourmetModelService {
	/*Vari�veis para tratamento das fun��es de retorno de nome de alimento e finaliza��o de partida*/
	private static String ultimoTipo;
	private static String ultimoNome;
	/*Vari�veis para tratamento das de gerar mensagem*/
	private static String ultimaPerguntaTipo;
	private static String proximaPerguntaNome;
	/*Lista que armazena os alimentos da partida*/
	public static HashMap<String,String> listaAlimentos = new HashMap<String,String>();
	
	/*Getters/Setter*/
	public static String getUltimaPerguntaTipo() {
		return ultimaPerguntaTipo;
	}
	public static void setUltimaPerguntaTipo(String ultimaPergunta) {
		JogoGourmetModelService.ultimaPerguntaTipo = ultimaPergunta;
	}
	public static String getUltimoTipo() {
		return ultimoTipo;
	}
	public static void setUltimoTipo(String ultimoTipo) {
		JogoGourmetModelService.ultimoTipo = ultimoTipo;
	}
	public static String getUltimoNome() {
		return ultimoNome;
	}
	public static void setUltimoNome(String ultimoNome) {
		JogoGourmetModelService.ultimoNome = ultimoNome;
	}
	public static String getProximaPerguntaNome() {
		return proximaPerguntaNome;
	}
	public static void setProximaPerguntaNome(String proximaPergunta) {
		JogoGourmetModelService.proximaPerguntaNome = proximaPergunta;
	}
	
	/*Gera alimentos iniciais e coloca na lista*/
	public static void perguntasIniciais() {
		listaAlimentos.put("Massa","Lasanha");	
		listaAlimentos.put("Bolo","Bolo de chocolate");
	}
	
	/*Adiciona novo alimento*/
	public static void adicionarAlimento(JogoGourmetModelEntity alimento) {
		listaAlimentos.put(alimento.getTipoAlimento(), alimento.getNomeAlimento());
	}
	
	/*Retorna o nome do �ltimo alimento perguntado*/
	public static String retornaUltimoNomeAlimento() {
		return getUltimoNome();
	}
	
	/*Reseta a partida parcialmente e totalmente*/
	public static void recomecaJogo(Boolean recomecaTotalmente) {
		//Ap�s um acerto, recome�a o jogo totalmente
		if(recomecaTotalmente) {
			listaAlimentos.clear();
		}
		
		setProximaPerguntaNome(null);
		setUltimaPerguntaTipo(null);
		setUltimoNome(null);
		setUltimoTipo(null);
		perguntasIniciais();
	}
	
	/*Valida o que ocorre ap�s a resposta do usu�rio (resposta[1 - Sim ,2 - N�o])*/
	public static Integer validaResposta(Integer resposta) {
		//Sim
		if(resposta == 0 ) {
			//Conclui que d� para perguntar o nome
			if(getUltimoTipo() == null && getUltimoNome() == null) {
				setUltimoTipo(getUltimaPerguntaTipo());
				return 0;
			}
			//Conclui que � um acerto
			else if(getUltimoTipo()!= null) {
				return 1;
			}
		}
		//N�o
		else {
			//Conclui que deve fazer outra pergunta de tipo
			if(getUltimoTipo()== null && listaAlimentos.size()>=1) {
				setProximaPerguntaNome(null);
				setUltimoTipo(null);
				return 0;
			}
			//Conclui que deve ser cadastrado novo alimento
			else{
				setUltimoNome(getProximaPerguntaNome());
				return 2;
			}
		}
		
		return null;
	}
	
	/*Gera as perguntas ao usu�rio*/
	public static String geraPergunta() {
		
		//Gera pergunta relacionada ao tipo do alimento
		if(getUltimoTipo() == null) {
			if(!listaAlimentos.isEmpty()) {
				for(Entry<String, String> alimento : listaAlimentos.entrySet()) {
					setUltimaPerguntaTipo(alimento.getKey());
					setProximaPerguntaNome(alimento.getValue());
					listaAlimentos.remove(alimento.getKey());
					return alimento.getKey();
				}	
			}
		}
		//Gera pergunta relacionada ao nome do alimento
		else {
			return getProximaPerguntaNome();
		}
						
		return null;
	}
	
	

}
