package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DaoUsuario;
import model.entidade.Usuario;

@WebServlet("/ControllerUsuario")
public class ControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerUsuario() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String botao = request.getParameter("botao");
		if (botao.equals("consultar")) {
			DaoUsuario dao = new DaoUsuario();
			ArrayList<Usuario> lista = dao.consultaTodos();
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("lista", lista);
			response.sendRedirect("users.jsp");   
		}
		if (botao.equals("inserir")) {
			String email = request.getParameter("email");
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			
			Usuario u = new Usuario();
			u.setNome(nome);
			u.setSenha(senha);
			u.setEmail(email);
			DaoUsuario dao = new DaoUsuario();
			if (dao.insere(u)) {
				response.sendRedirect("sucesso.jsp");
			} else {
				response.sendRedirect("erro.jsp");
			}

		}
		if (botao.equals("deletar")) {
			String email = request.getParameter("email");
			Usuario u = new Usuario();
			u.setEmail(email);
			DaoUsuario dao = new DaoUsuario();
			if (dao.delete(u)) {
				response.sendRedirect("sucesso.jsp");
			} else {
				response.sendRedirect("erro.jsp");
			}
		}
	}

}
