package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.banco.Oracle;
import model.entidade.Categoria;

public class DaoCategoria {
	private Oracle oracle;

	public boolean insere(Categoria c) {
		String sql = " INSERT INTO categoria (idcategoria, descricao)" + " VALUES (" + "incCategoria.nextval" + ", '" + c.getDescricao() + "' ) ";

		oracle = new Oracle();
		boolean retorno = false;
		if (oracle.carregaDriver() && oracle.conecta() && oracle.abreComando()) {
			if (oracle.modifica(sql) > 0) {
				retorno = true;
			}
		}
		return retorno;
	}

	public boolean delete(Categoria c) {
		String sql = " DELETE FROM categoria WHERE descricao = '" + c.getDescricao() + "'";

		oracle = new Oracle();
		boolean retorno = false;
		if (oracle.carregaDriver() && oracle.conecta() && oracle.abreComando()) {
			if (oracle.modifica(sql) > 0) {
				retorno = true;
			}
		}
		return retorno;
	}

	public ArrayList<Categoria> consultaTodos() {
		ArrayList<Categoria> lista = null;
		String sql = " SELECT * FROM categoria";
		Oracle o = new Oracle();
		if (o.conecta() && o.abreComando()) {
			ResultSet r = o.consulta(sql);
			try {
				lista = new ArrayList<Categoria>();
				while (r.next()) {
					Categoria c = new Categoria();
					c.setIdCategoria(r.getInt(1));
					c.setDescricao(r.getString(2));
					lista.add(c);
				}
			} catch (SQLException e) {
				System.out.println("Erro: " + e.toString());
			}
		}
		return lista;
	}
}
