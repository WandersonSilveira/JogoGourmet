/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelController, que gerencia a comunica��o entre view e model.
 */

package Controller;

import Model.AlimentoModelService;

public class AlimentoController {
	
	private static AlimentoModelService modelService = new AlimentoModelService();
	
	/*Controlador fun��o gera pergunta*/
	public static String gerarPergunta() {
		return modelService.geraPergunta();
	}
	
	/*Controlador fun��o recomeca jogo*/
	public static void recomecaJogo() {
		modelService.recomecaJogo();
	}
	
	/*Controlador fun��o perguntas iniciais*/
	public static void perguntasIniciais() {
		modelService.perguntasIniciais();
	}
	
	/*Controlador fun��o adicionar alimento*/
	public static void adicionarAlimentoNovo(String tipoAlimento, String nomeAlimento) {	
		modelService.adicionarAlimento(nomeAlimento, tipoAlimento);
	}
	
	/*Controlador fun��o valida resposta*/
	public static Integer validaResposta(Integer resposta) {
		return modelService.validaResposta(resposta);
	}
	
	public static String retornaNomeUltimoAlimento() {
		return modelService.retornaNomeUltimoAlimento();
	}

}
