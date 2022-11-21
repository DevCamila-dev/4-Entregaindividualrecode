package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PromocaoDAO;
import model.Promocao;

/**
 * Servlet implementation class PromocaoCreateAndFind
 */
@WebServlet("/CreateAndFind1")
public class PromocaoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PromocaoCreateAndFind() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Promocao> promocoes = PromocaoDAO.find(pesquisa);
		
		request.setAttribute("promocoes", promocoes);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista_promo.jsp");
		resquesDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Promocao promocao = new Promocao();
		
		promocao.setNome(request.getParameter("nome"));
		promocao.setValorPromo(request.getParameter("valorPromo"));
		promocao.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		
		PromocaoDAO.create(promocao);

		doGet(request, response);
	}

}
