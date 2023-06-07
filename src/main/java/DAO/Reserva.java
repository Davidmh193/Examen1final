package DAO;

import java.util.Date;

/**
 * 
 * @author Eñaut
 * Esta clase DTO representa la entidad
 * RESERVA de la BBDD
 *
 */
public class Reserva {
	//TODO crear los atributos pribados, setters y getters
	private int id;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String dniUsuario;
	private int numeroUsuario;
	private Date inicioReserva;
	private Date finReserva;
	private Date fechares;
	private boolean luz;
	private int idparcela;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	public int getNumeroUsuario() {
		return numeroUsuario;
	}
	public void setNumeroUsuario(int numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}
	public Date getInicioReserva() {
		return inicioReserva;
	}
	public void setInicioReserva(Date inicioReserva) {
		this.inicioReserva = inicioReserva;
	}
	public Date getFinReserva() {
		return finReserva;
	}
	public void setFinReserva(Date finReserva) {
		this.finReserva = finReserva;
	}
	public Date getFechares() {
		return fechares;
	}
	public void setFechares(Date fechares) {
		this.fechares = fechares;
	}
	public boolean isLuz() {
		return luz;
	}
	public void setLuz(boolean luz) {
		this.luz = luz;
	}
	public int getIdparcela() {
		return idparcela;
	}
	public void setIdparcela(int idparcela) {
		this.idparcela = idparcela;
	}
}
