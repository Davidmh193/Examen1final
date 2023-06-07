package DAO;

import java.util.ArrayList;
/**
 * 
 * @author Eñaut
 * Esta clase DTO representa la entidad
 * PARCELA de la BBDD
 *
 */
public class Parcela {
	//TODO crear los atributos pribados, setters y getters
	private int id;
	private String numero;
	private int mcuadrados;
	private double preciodia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public int getMcuadrados() {
		return mcuadrados;
	}
	public void setMcuadrados(int mcuadrados) {
		this.mcuadrados = mcuadrados;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getPreciodia() {
		return preciodia;
	}
	public void setPreciodia(double preciodia) {
		this.preciodia = preciodia;
	}
	
	
}
