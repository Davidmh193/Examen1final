package Controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Parcela;
import DAO.ParcelaModelo;
import DAO.ReservaModelo;

/**
 * Servlet implementation class IniciarReserva
 */
@WebServlet("/IniciarReserva")
public class IniciarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementar la funcionalidad de iniciar reserva
		//se abrirá la vista formReserva.jsp
		ParcelaModelo parcelaModelo =new ParcelaModelo();
		ReservaModelo reservaModelo =new ReservaModelo();

		
		request.setAttribute("parcelas", parcelaModelo.getParcelaReserva(Integer.parseInt(request.getParameter("id"))));
		request.setAttribute("reserva", reservaModelo.getUltimaId());
		
		request.getRequestDispatcher("formReserva.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
		
	}

}
