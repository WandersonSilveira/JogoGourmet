/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelController, que gerencia a comunicação entre view e model.
 */

package Controller;

import Model.AlimentoModelService;

public class AlimentoController {
	
	private static AlimentoModelService modelService = new AlimentoModelService();
	
	/*Controlador função gera pergunta*/
	public static String gerarPergunta() {
		return modelService.geraPergunta();
	}
	
	/*Controlador função recomeca jogo*/
	public static void recomecaJogo() {
		modelService.recomecaJogo();
	}
	
	/*Controlador função perguntas iniciais*/
	public static void perguntasIniciais() {
		modelService.perguntasIniciais();
	}
	
	/*Controlador função adicionar alimento*/
	public static void adicionarAlimentoNovo(String tipoAlimento, String nomeAlimento) {	
		modelService.adicionarAlimento(nomeAlimento, tipoAlimento);
	}
	
	/*Controlador função valida resposta*/
	public static Integer validaResposta(Integer resposta) {
		return modelService.validaResposta(resposta);
	}
	
	public static String retornaNomeUltimoAlimento() {
		return modelService.retornaNomeUltimoAlimento();
	}

}
