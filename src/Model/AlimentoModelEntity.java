/**
 * @author Wanderson da Silveira
 * Classe JogoGourmetModelEntity, que modela a entidade alimento.
 */

package Model;

import java.util.LinkedList;
import java.util.List;

public class AlimentoModelEntity {
	
	/*Atributos*/
	private String nomeAlimento;
	private List<String> listaTipoAlimento = new LinkedList<String>();
	
	/*Getters/Setters*/
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
	public List<String> getListaTipoAlimento() {
		return listaTipoAlimento;
	}
	public void setListaTipoAlimento(List<String> listaTipoAlimento) {
		this.listaTipoAlimento.addAll(listaTipoAlimento);
	}
	//Feito para poder colocar um tipo de cada vez
	public void setTipoAlimento(String tipoAlimento) {
		this.listaTipoAlimento.add(tipoAlimento);
	}
}
