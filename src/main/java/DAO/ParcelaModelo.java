package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParcelaModelo extends Conector {
	
	//select * from parcelas
	
	public ArrayList<Parcela> getParcela() throws SQLException {
		ArrayList<Parcela> parcelas = new ArrayList<>();
		Conector conector = new Conector();
		
		conector.conectar();
		
		PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM parcelas");
		ResultSet resultado = pSt.executeQuery();
		while (resultado.next()) {
			Parcela par = new Parcela();
			
			par.setId(resultado.getInt("id"));
			par.setNumero(resultado.getString("numero"));
			par.setMcuadrados(resultado.getInt("m_cuadrados"));
			par.setPreciodia(resultado.getDouble("precio_dia"));
			
			parcelas.add(par);
		}
		pSt.close();
		conector.cerrar();
		return parcelas;
		
	}
	
	
	public Parcela getParcelaReserva(int id) {

		String sql = "select * from parcelas where id=?";
		Conector conector = new Conector();
		
		conector.conectar();
		PreparedStatement pSt;
		Parcela par = new Parcela();
		
		try {
			pSt = conector.getCon().prepareStatement(sql);
			pSt.setInt(1, id);
			ResultSet resultado = pSt.executeQuery();
			resultado.next();
			
			par.setId(resultado.getInt("id"));
			par.setNumero(resultado.getString("numero"));
			par.setMcuadrados(resultado.getInt("m_cuadrados"));
			par.setPreciodia(resultado.getDouble("precio_dia"));
			pSt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conector.cerrar();
		return par;

			
	}
	
	
	
	
	


}
