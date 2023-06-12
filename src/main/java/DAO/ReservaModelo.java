package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class ReservaModelo extends Conector{
/*
	"INSERT INTO reservas(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva,  luz, id_parcela) "
			+ "VALUES (?,?,?,?,?,?,?,?)"
			
	"DELETE FROM reservas WHERE id = ?"
		*/
		
	
	//Insertar
	public void insertarReserva(String nombre,String apellido, String dni, int numpersonas, Date iniciores, Date finres, boolean luz,int idparcela) throws ClassNotFoundException {
		try {
			Conector conector = new Conector();
			conector.conectar();
			
			PreparedStatement pSt = conector.getCon().prepareStatement(

					"INSERT INTO reservas(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva,  luz, id_parcela)"
							+ "VALUES (?,?,?,?,?,?,?,?)");
			
			pSt.setString(1, nombre);
			pSt.setString(2, apellido);
			pSt.setString(3, dni);
			pSt.setInt(4, numpersonas);
			pSt.setDate(5, new java.sql.Date(iniciores.getTime()));
			pSt.setDate(6, new java.sql.Date(finres.getTime()));
			pSt.setBoolean(7, luz);
			pSt.setInt(8, idparcela);
			pSt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public int getUltimaId() {
	    int id = 0;
	    Conector c = new Conector();
	    c.conectar();
	    
	    try {
	        PreparedStatement pSt = c.getCon().prepareStatement("SELECT max(id) FROM reservas");
	        ResultSet resultado = pSt.executeQuery();
	        resultado.next();
	        id = resultado.getInt(1);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    c.cerrar();
	    return id;
	}
	
	
	

	
	
	
	//Eliminar
	

	public void eliminarReserva(String id) throws ClassNotFoundException {
		String sentencia = "DELETE FROM reservas WHERE max(id)=?";
		try {
			Conector conector = new Conector();
			conector.conectar();
			
			PreparedStatement pSt = conector.getCon().prepareStatement(sentencia);
			pSt.setString(1, id);
			pSt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

	public Reserva getReserva(int id) {

		String sql = "select * from reservas where id=?";
		Conector conector = new Conector();
		
		conector.conectar();
		PreparedStatement pSt;
		Reserva reser = new Reserva();
		
		try {
			pSt = conector.getCon().prepareStatement(sql);
			pSt.setInt(1, id);
			ResultSet resultado = pSt.executeQuery();
			resultado.next();
			
			reser.setId(resultado.getInt("id"));
			reser.setNombreUsuario("nombre_usuario");
			reser.setApellidoUsuario("apellido_usuario");
			reser.setDniUsuario("dni_usuario");
			reser.setNumeroUsuario(resultado.getInt("numero_usuarios"));
			reser.setInicioReserva(resultado.getDate("inicio_reserva"));
			reser.setFechares(resultado.getDate("fin_reserva"));
			reser.setLuz(resultado.getBoolean("luz"));

		
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return reser;

			
	}

}
