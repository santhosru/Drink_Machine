package Home;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conta {
	private String nome;
	private String email;
	private String dataNascimento;
	private String login;
	private String senha;
	private String idade;
	private boolean adulto;

	public Conta(String nome, String email, String dataNascimento, String login, String senha) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void valida_adulto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataNascimento);
		try {
			LocalDate data = LocalDate.parse(dataNascimento, formatter);
			LocalDate data_atual = LocalDate.parse(dataNascimento, formatter);
			/*
			 * int dia = data.getDayOfMonth(); int mes = data.getMonthValue();
			 */
			int ano = data.getYear();
			int ano_atual = data_atual.getYear();

			int valida = ano_atual - ano;

			if (valida < 18) {
				adulto = false;
			} else {
				adulto = true;
			}
		} catch (Exception e) {
			System.out.println("Data inválida.");
		}
	}

	@Override
	public String toString() {
		if (adulto) {
			idade = "Adulto";
		} else {
			idade = "Criança";
		}
		return "Nome: " + nome + "\nEmail: " + email + "\nData de Nascimento: " + dataNascimento + "\nLogin: " + login
				+ "\nSenha: " + senha + "\n" + idade + "\n";
	}

}
