package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DaoCategoria;
import model.entidade.Categoria;

@WebServlet("/ControllerCategoria")
public class ControllerCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerCategoria() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String botao = request.getParameter("botao");
		if (botao.equals("consultar")) {
			DaoCategoria dao = new DaoCategoria();
			ArrayList<Categoria> lista = dao.consultaTodos();
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("lista", lista);
			response.sendRedirect("categorias.jsp");
		}
		if (botao.equals("inserir")) {
			String descricao = request.getParameter("descricao");

			Categoria c = new Categoria();
			c.setDescricao(descricao);
			DaoCategoria dao = new DaoCategoria();
			if (dao.insere(c)) {
				response.sendRedirect("sucesso.jsp");
			} else {
				response.sendRedirect("erro.jsp");
			}

		}
		if (botao.equals("deletar")) {
			String descricao = request.getParameter("descricao");
			Categoria c = new Categoria();
			c.setDescricao(descricao);
			DaoCategoria dao = new DaoCategoria();
			if (dao.delete(c)) {
				response.sendRedirect("sucesso.jsp");
			} else {
				response.sendRedirect("erro.jsp");
			}
		}
	}

}
