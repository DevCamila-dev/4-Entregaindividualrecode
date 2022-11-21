package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DestinoDAO;
import model.Destino;


@WebServlet("/CreateAndFind")
public class DestinoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    
    public DestinoCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Destino> destinos = DestinoDAO.find(pesquisa);
		
		request.setAttribute("destinos", destinos);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista.jsp");
		resquesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Destino destino = new Destino();
		
		destino.setNome(request.getParameter("nome"));
		destino.setEstado(request.getParameter("estado"));
		destino.setPais(request.getParameter("pais"));
		destino.setDataIda(request.getParameter("dataIda"));
		destino.setDataVolta(request.getParameter("dataVolta"));
		destino.setValor(request.getParameter("valor"));
		
		DestinoDAO.create(destino);

		doGet(request, response);
	}

}
