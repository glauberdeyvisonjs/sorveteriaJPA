package dao;

import java.util.List;

import entidade.Sorvete;

public interface SorveteDAO {
	
	public void inserir(Sorvete sorvete);
	public void remover(String nome);
	public List<Sorvete> listarTodos();

}
