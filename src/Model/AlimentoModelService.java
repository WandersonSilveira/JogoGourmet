/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelService, que possui as funções e regras de negócio do sistema.
 */

package Model;

import java.util.LinkedList;
import java.util.List;

public class AlimentoModelService {
	
	/*Listas de alimentos(nunca são removidos alimentos)*/
	private List<AlimentoModelEntity> listaAlimentos = new LinkedList<AlimentoModelEntity>();
	/*Listas de alimentos para usar nas perguntas(são removidos alimentos)*/
	private List<AlimentoModelEntity> listaAlimentosParaPerguntar = new LinkedList<AlimentoModelEntity>();
	/*Listas usadas para guardar respostas perguntas já feitas*/
	private List<String> tiposAlimentosExistentesPerguntados = new LinkedList<String>();
	private List<String> tiposAlimentosNaoExistentesPerguntados = new LinkedList<String>();
	/*Usadas para armazenar pergunta atual feita*/
	private String perguntaAtualTipo;
	private String perguntaAtualNome;
	
	/*Gera dois primeiros alimentos*/
	public void perguntasIniciais() {
		AlimentoModelEntity alimento1 = new AlimentoModelEntity();
		alimento1.setNomeAlimento("Lasanha");
		alimento1.setTipoAlimento("Massa");
		
		AlimentoModelEntity alimento2 = new AlimentoModelEntity();
		alimento2.setNomeAlimento("Bolo de chocolate");
		
		listaAlimentos.add(alimento1);
		listaAlimentos.add(alimento2);
		
		listaAlimentosParaPerguntar.addAll(listaAlimentos);
	}
	
	/*Reseta a partida*/
	public void recomecaJogo() {
		tiposAlimentosExistentesPerguntados.clear();
		tiposAlimentosNaoExistentesPerguntados.clear();
		
		listaAlimentosParaPerguntar.clear();
		listaAlimentosParaPerguntar.addAll(listaAlimentos);
	}
	
	/*Adiciona novo alimento*/
	public void adicionarAlimento(String nomeAlimento, String tipoAlimento){
		AlimentoModelEntity alimento = new AlimentoModelEntity();
		
		alimento.setNomeAlimento(nomeAlimento);
		//Pega todos os tipos que foram respondidos com "sim" para colocar no novo alimento
		alimento.setListaTipoAlimento(tiposAlimentosExistentesPerguntados);
		alimento.setTipoAlimento(tipoAlimento);
		
		listaAlimentos.add(alimento);
	}
	
	/*Gera as perguntas ao usuário*/
	public String geraPergunta() {
		
		//Retorna nome do alimento
		if(listaAlimentosParaPerguntar.size() == 1) {
			for(AlimentoModelEntity alimento : listaAlimentosParaPerguntar) {
				perguntaAtualNome = alimento.getNomeAlimento();
				return alimento.getNomeAlimento();
			}
		}
		//Retorna tipo do alimento que ainda não foi perguntado
		else {
			for(AlimentoModelEntity alimento : listaAlimentosParaPerguntar) {
				for(String tipoAlimento : alimento.getListaTipoAlimento()) {
					if(!tiposAlimentosExistentesPerguntados.contains(tipoAlimento) &&
					  !tiposAlimentosNaoExistentesPerguntados.contains(tipoAlimento)) {
						perguntaAtualTipo = tipoAlimento;
						return tipoAlimento;
					}
				}
			}
		}
						
		return null;
	}
	
	public Integer validaResposta(Integer resposta) {
		//Sim
		if( resposta == 0) {
			//Mostrar que jogo foi ganho
			if(listaAlimentosParaPerguntar.size() == 1) {
				return 1;
			}
			
			//Remover da lista de perguntados o sim
			for(int i=0; i< listaAlimentosParaPerguntar.size(); i++) {
				if(!listaAlimentosParaPerguntar.get(i).getListaTipoAlimento().contains(perguntaAtualTipo)){
					listaAlimentosParaPerguntar.remove(i);
				}
			}
			
			//Adicionar as respostas positivas para poder criar novo alimento
			tiposAlimentosExistentesPerguntados.add(perguntaAtualTipo);
			
		}
		//Não
		else {
			//Mostrar que jogo foi nao foi ganho
			if(listaAlimentosParaPerguntar.size() <= 1) {
				return 2;
			}
			
			//Remover da lista de perguntados o nao
			for(int i=0; i< listaAlimentosParaPerguntar.size(); i++) {
				if(listaAlimentosParaPerguntar.get(i).getListaTipoAlimento().contains(perguntaAtualTipo)){
					listaAlimentosParaPerguntar.remove(i);
				}
			}
			
			//Adicionar as respostas positivas para poder criar novo alimento
			tiposAlimentosNaoExistentesPerguntados.add(perguntaAtualTipo);
			 
		}
		//Continua fazendo perguntas
		return 0;
	}
	
	/*Retorna ultimo alimento perguntado*/
	public String retornaNomeUltimoAlimento() {
		return perguntaAtualNome;
	}
}
