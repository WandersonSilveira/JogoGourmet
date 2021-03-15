/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelService, que possui as funções e regras de negócio do sistema.
 */

package Model;

import java.util.HashMap;
import java.util.Map.Entry;

public class JogoGourmetModelService {
	/*Variáveis para tratamento das funções de retorno de nome de alimento e finalização de partida*/
	private static String ultimoTipo;
	private static String ultimoNome;
	/*Variáveis para tratamento das de gerar mensagem*/
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
	
	/*Retorna o nome do último alimento perguntado*/
	public static String retornaUltimoNomeAlimento() {
		return getUltimoNome();
	}
	
	/*Reseta a partida parcialmente e totalmente*/
	public static void recomecaJogo(Boolean recomecaTotalmente) {
		//Após um acerto, recomeça o jogo totalmente
		if(recomecaTotalmente) {
			listaAlimentos.clear();
		}
		
		setProximaPerguntaNome(null);
		setUltimaPerguntaTipo(null);
		setUltimoNome(null);
		setUltimoTipo(null);
		perguntasIniciais();
	}
	
	/*Valida o que ocorre após a resposta do usuário (resposta[1 - Sim ,2 - Não])*/
	public static Integer validaResposta(Integer resposta) {
		//Sim
		if(resposta == 0 ) {
			//Conclui que dá para perguntar o nome
			if(getUltimoTipo() == null && getUltimoNome() == null) {
				setUltimoTipo(getUltimaPerguntaTipo());
				return 0;
			}
			//Conclui que é um acerto
			else if(getUltimoTipo()!= null) {
				return 1;
			}
		}
		//Não
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
	
	/*Gera as perguntas ao usuário*/
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
