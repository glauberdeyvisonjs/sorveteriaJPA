package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SORVETE")
public class Sorvete {
	
	@Id
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;
	@Column(name = "INGREDIENTES", nullable = false)
	private String ingredientes;

	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		this.nome = nome;
		return nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Sorvete [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (fabricante != null ? "fabricante=" + fabricante + ", " : "")
				+ (ingredientes != null ? "ingredientes=" + ingredientes : "") + "]";
	}

}
