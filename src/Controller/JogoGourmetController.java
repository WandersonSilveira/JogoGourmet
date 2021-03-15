/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelController, que gerencia a comunica��o entre view e model.
 */

package Controller;

import Model.JogoGourmetModelEntity;
import Model.JogoGourmetModelService;

public class JogoGourmetController {
	
	private static JogoGourmetModelService modelService = new JogoGourmetModelService();
	
	/*Controlador fun��o gera pergunta*/
	@SuppressWarnings("static-access")
	public static String gerarPergunta() {
		return modelService.geraPergunta();
	}
	
	/*Controlador fun��o recomeca jogo*/
	@SuppressWarnings("static-access")
	public static void recomecaJogo(Boolean recomecaTotalmente) {
		modelService.recomecaJogo(recomecaTotalmente);
	}
	
	/*Controlador fun��o perguntas iniciais*/
	@SuppressWarnings("static-access")
	public static void perguntasIniciais() {
		modelService.perguntasIniciais();
	}
	
	/*Controlador fun��o adicionar alimento*/
	@SuppressWarnings("static-access")
	public static void adicionarAlimentoNovo(String tipoAlimento, String nomeAlimento) {
		JogoGourmetModelEntity alimento = new JogoGourmetModelEntity();
		alimento.setTipoAlimento(tipoAlimento);
		alimento.setNomeAlimento(nomeAlimento);
		
		modelService.adicionarAlimento(alimento);
	}
	
	/*Controlador fun��o valida resposta*/
	@SuppressWarnings("static-access")
	public static Integer validaResposta(Integer resposta) {
		return modelService.validaResposta(resposta);
	}
	
	/*Controlador fun��o retorna �ltimo alimento*/
	@SuppressWarnings("static-access")
	public static String retornaUltimoNomeAlimento() {
		return modelService.retornaUltimoNomeAlimento();
	}

}
