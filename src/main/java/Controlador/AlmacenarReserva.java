package Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReservaModelo;

/**
 * Servlet implementation class ConfirmarReserva
 */
@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementar la funcionalidad de almacenar reserva
		//se abrirá la vista infoReserva
		
		request.getRequestDispatcher("CancelarReserva");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReservaModelo reservar = new ReservaModelo();
		
		int idparcela = Integer.parseInt(request.getParameter("id_parcela"));
		String nombreUsuario = request.getParameter("nombre");
		String apellidoUsuario =request.getParameter("apellido");
		String dniUsuario= request.getParameter("dni");
		int numeroUsuario=Integer.parseInt(request.getParameter("numero_personas"));
		String inicioReserva = request.getParameter("fecha_inicio");
		String finReserva = request.getParameter("fecha_fin");
		boolean luz = Boolean.parseBoolean(request.getParameter("luz"));
		
		
		Date inicioRe = null;
		Date finRe= null;
		
		try {
			inicioRe = new SimpleDateFormat("yyyy-MM-dd").parse(inicioReserva);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			finRe = new SimpleDateFormat("yyyy-MM-dd").parse(finReserva);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
			reservar.insertarReserva(nombreUsuario, apellidoUsuario, dniUsuario, numeroUsuario, inicioRe, finRe, luz, idparcela);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.sendRedirect(request.getContextPath() + "/CancelarReserva");
		
		
	}

}
