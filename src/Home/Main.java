package Home;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factor.ConnectionFactory;

public class Main {

	public static void main(String[] args) {

		ConnectionFactory cf = new ConnectionFactory();

		try {
			cf.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		List<Conta> contas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		boolean continuar = true;

		while (continuar) {
			System.out.print("Digite o nome: ");
			String nome = scanner.nextLine();

			System.out.print("Digite o email: ");
			String email = scanner.nextLine();

			System.out.print("Digite a data de nascimento: ");
			String dataNascimento = scanner.nextLine();

			System.out.print("Digite o login: ");
			String login = scanner.nextLine();

			System.out.print("Digite a senha: \n");
			String senha = scanner.nextLine();

			Conta conta = new Conta(nome, email, dataNascimento, login, senha);
			contas.add(conta);

			System.out.println("Conta criada com sucesso!");
			System.out.println("Deseja criar outro usuario ? Y/N");
			String sair = scanner.nextLine();

			if (!sair.equalsIgnoreCase("Y")) {
				continuar = false;
			}
		}
		if (!contas.isEmpty())

		{
			System.out.println("\nLista de contas:");

			for (Conta conta : contas) {
				System.out.println(conta);
			}
		} else {
			System.out.println("\nNenhuma conta foi criada.");
		}
		scanner.close();
	}

}
