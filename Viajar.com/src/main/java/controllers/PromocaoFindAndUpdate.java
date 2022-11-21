package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PromocaoDAO;
import model.Promocao;

/**
 * Servlet implementation class DestinoFindAndUpdate
 */
@WebServlet("/PromocaoUpdate")
public class PromocaoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PromocaoFindAndUpdate() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int promoId = Integer.parseInt(request.getParameter("promoId"));
		Promocao promocao = PromocaoDAO.findById(promoId);
		
		request.setAttribute("promocao", promocao);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Promocao promocao = new Promocao();
		
		promocao.setIdPromo(Integer.parseInt(request.getParameter("idPromo")));
		promocao.setNome(request.getParameter("nome"));
		promocao.setValorPromo(request.getParameter("valorPromo"));
		promocao.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		
		PromocaoDAO.update(promocao);
		
		PromocaoCreateAndFind promocaoCreateAndFind = new PromocaoCreateAndFind();
		promocaoCreateAndFind.doGet(request, response);
	}

}
