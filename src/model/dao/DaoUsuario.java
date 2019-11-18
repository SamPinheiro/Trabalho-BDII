package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.banco.Oracle;
import model.entidade.Usuario;

public class DaoUsuario {
	private Oracle oracle;

	public boolean insere(Usuario u) {
		String sql = " INSERT INTO usuario (idusuario, nome, email, senha)" + " VALUES (" + "incUsuario.nextval" + ", '" + u.getNome() + "','"
				+ u.getEmail() + "','" + u.getSenha() + "') ";

		oracle = new Oracle();
		boolean retorno = false;
		if (oracle.carregaDriver() && oracle.conecta() && oracle.abreComando()) {
			if (oracle.modifica(sql) > 0) {
				retorno = true;
			}
		}
		return retorno;
	}

	public boolean delete(Usuario u) {
		String sql = " DELETE FROM usuario WHERE email = '" + u.getEmail() + "'";

		oracle = new Oracle();
		boolean retorno = false;
		if (oracle.carregaDriver() && oracle.conecta() && oracle.abreComando()) {
			if (oracle.modifica(sql) > 0) {
				retorno = true;
			}
		}
		return retorno;
	}

	public ArrayList<Usuario> consultaTodos() {
		ArrayList<Usuario> lista = null;
		String sql = " SELECT * FROM usuario";
		Oracle o = new Oracle();
		if (o.conecta() && o.abreComando()) {
			ResultSet r = o.consulta(sql);
			try {
				lista = new ArrayList<Usuario>();
				while (r.next()) {
					Usuario u = new Usuario();
					u.setId(r.getInt(1));
					u.setSenha(r.getString(2));
					u.setNome(r.getString(3));
					u.setEmail(r.getString(4));
					lista.add(u);
				}
			} catch (SQLException e) {
				System.out.println("Erro: " + e.toString());
			}
		}
		return lista;
	}
}
