package entities;

import Factor.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {
	private int id;
	private String nome;
	private LocalDate data_nascimento;

	public Pessoa() {
		this.id = 0;
		this.nome = "";
		this.data_nascimento = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public ArrayList<Pessoa> getListaPessoas() {
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		ConnectionFactory cf = new ConnectionFactory();
		// READ - Leitura
		try {
			Connection conn = cf.conectar();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from pessoa");
			cf.desconectar();
			while (result.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(result.getInt("id"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setData_nascimento(LocalDate.parse(result.getString("data_nascimento")));
				listaPessoas.add(pessoa);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao tentar conetar a base de dados, erro: " + e.getMessage());
		}
		return listaPessoas;
	}
}
