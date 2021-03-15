/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelEntity, que modela a entidade alimento.
 */

package Model;

public class JogoGourmetModelEntity {
	/*Atributos*/
	private String tipoAlimento;
	private String nomeAlimento;
	
	/*Getters/Setters*/
	public String getTipoAlimento() {
		return tipoAlimento;
	}
	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
}
