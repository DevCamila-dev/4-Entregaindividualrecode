package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DestinoDAO;
import model.Destino;

/**
 * Servlet implementation class DestinoFindAndUpdate
 */
@WebServlet("/DestinoUpdate")
public class DestinoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DestinoFindAndUpdate() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		Destino destino = DestinoDAO.findById(destinoId);
		
		request.setAttribute("destino", destino);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Destino destino = new Destino();
		
		destino.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		destino.setNome(request.getParameter("nome"));
		destino.setEstado(request.getParameter("estado"));
		destino.setPais(request.getParameter("pais"));
		destino.setDataIda(request.getParameter("dataIda"));
		destino.setDataVolta(request.getParameter("dataVolta"));
		destino.setValor(request.getParameter("valor"));
		
		DestinoDAO.update(destino);
		
		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);
	}

}
