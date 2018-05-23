package sca.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CriarUsuarioException;
import model.bean.SCABeanLocal;

/**
 * Servlet implementation class SCATest to teste access to EJB SCA Local
 */
public class SCATest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB 
	SCABeanLocal sca;
	
    public SCATest() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ServletOutputStream out = response.getOutputStream();
		 response.setContentType("text/html"); 
		try {
		Long id = new Long(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		sca.criarUsuario(id, nome, login, senha);
		out.println("<h1>Usuario " + id + " criado com sucesso</h1>");
		}
		catch (Exception e) {
			out.println("<h1>Erro = " + e.getMessage() + " - " + e.getCause().getMessage() + "</h1>");
		}
		finally {
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
