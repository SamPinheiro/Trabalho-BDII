package model.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String usuario = "site";
	private String senha = "site123";
	private Connection conexao = null;
	private PreparedStatement comando = null;
	private Statement comand = null;
	
	public boolean abreComando() {
		boolean retorno = false;
		try {
			comand = conexao.createStatement();
			retorno = true;
		}
		catch(SQLException ex ) {
			System.out.println("Erro: " + ex.toString());
		}
		return retorno;
	}
	
	public ResultSet consulta(String sql) {
		ResultSet resultado = null;
		try {
			resultado = comand.executeQuery(sql);
		}
		catch(SQLException ex) {
			System.out.println("Erro:" + ex.toString());
		}
		return resultado;
	}
	
	public int modifica(String sql) {
		int resultado = 0;
		try {
			resultado = comand.executeUpdate(sql);
			conexao.commit();
		}catch(SQLException ex) {
			System.out.println("Erro: " + ex.toString());
		}
		return resultado;
	}

	public boolean carregaDriver() {
		boolean retorno = false;
		try {
			Class.forName(driver);
			retorno = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("erro " + ex.toString());
		}

		return retorno;
	}

	public boolean conecta() {
		boolean retorno = false;

		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			retorno = true;
		}

		catch (SQLException ex) {
			System.out.println("Erro:" + ex.toString());
		}

		return retorno;
	}

	public void preparaComando(PreparedStatement c) {
		comando = c;
	}

	public ResultSet consulta(PreparedStatement c) {
		ResultSet resultado = null;
		try {
			resultado = c.executeQuery();
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex.toString());
		}
		return resultado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public PreparedStatement getComando() {
		return comando;
	}

	public void setComando(PreparedStatement comando) {
		this.comando = comando;
	}

	public Statement getComand() {
		return comand;
	}

	public void setComand(Statement comand) {
		this.comand = comand;
	}
	

}
