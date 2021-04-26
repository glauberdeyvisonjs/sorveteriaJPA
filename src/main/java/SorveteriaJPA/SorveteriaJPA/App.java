package SorveteriaJPA.SorveteriaJPA;

import java.util.List;
import java.util.Scanner;

import dao.SorveteDAO;
import dao.impl.SorveteDAOImpl;
import entidade.Sorvete;

public class App {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Scanner leia1 = new Scanner(System.in);

		System.out.println("*** GERENCIAMENTO DE SORVETES ***\n");
		System.out.println("Escolha uma opção abaixo:");
		System.out.println("1- Inserir sorvete");
		System.out.println("2- Remover sorvete");
		System.out.println("3- Listar sorvetes");
		int opcao = leia.nextInt();

		switch (opcao) {
		case 1:
			Sorvete sorvete = new Sorvete();
			System.out.println("Digite o nome do sorvete: ");
			sorvete.setNome(leia1.nextLine());
			System.out.println("Digite o fabricante: ");
			sorvete.setFabricante(leia1.nextLine());
			System.out.println("Digite os ingredientes: ");
			sorvete.setIngredientes(leia1.nextLine());

			SorveteDAO sorveteInserir = new SorveteDAOImpl();
			sorveteInserir.inserir(sorvete);

			break;

		case 2:
			Sorvete sorvete1 = new Sorvete();
			System.out.println("Digite o nome do sorvete a ser removido: ");
			sorvete1.setNome(leia1.nextLine());

			SorveteDAO sorveteRemover = new SorveteDAOImpl();
			sorveteRemover.remover(sorvete1.getNome());

			break;

		case 3:
			SorveteDAO sorveteListar = new SorveteDAOImpl();
			List<Sorvete> listarTodos = sorveteListar.listarTodos();
			for (Sorvete p : listarTodos) {
				System.out.println(p.toString());
			}
			
			break;

		default:
			System.err.println("Opção inválida!!");
			break;
		}
	}
}