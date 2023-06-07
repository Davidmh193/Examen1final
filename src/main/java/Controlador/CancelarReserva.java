package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ParcelaModelo;
import DAO.ReservaModelo;

/**
 * Servlet implementation class CancelarReserva
 */
@WebServlet("/CancelarReserva")
public class CancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementar la eliminacion de la reserva
		//abrir la vista confirmacion.jsp
	
		ParcelaModelo parcelaModelo =new ParcelaModelo();
		ReservaModelo reservaModelo =new ReservaModelo();

		
		request.setAttribute("parcelas", parcelaModelo.getParcelaReserva(Integer.parseInt(request.getParameter("id"))));
		request.setAttribute("reserva", reservaModelo.getUltimaId());
		request.getRequestDispatcher("infoReserva.jsp").forward(request, response);
	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		doGet(request, response);
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	

	}
	}
