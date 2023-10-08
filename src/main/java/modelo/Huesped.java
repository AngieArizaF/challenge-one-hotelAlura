package modelo;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "huespedes")
public class Huesped {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionlaidad;
	private String telefono;
	private Reserva idReserva;
	
	
	public Huesped() {
		super();
	}
	public Huesped(Long id) {
		super();
		this.id = id;
	}
	public Huesped(Long id, String nombre, String apellido, Date fechaNacimiento, String nacionlaidad,
			String telefono, Reserva idReserva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionlaidad = nacionlaidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Huesped other = (Huesped) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "huesped [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", nacionlaidad=" + nacionlaidad + ", telefono=" + telefono + ", idReserva="
				+ idReserva + "]";
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento != null ? new Date(fechaNacimiento.getTime()) : null;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento != null 
                ? new Date(fechaNacimiento.getTime()) : null;
	}
	public String getNacionlaidad() {
		return nacionlaidad;
	}
	public void setNacionlaidad(String nacionlaidad) {
		this.nacionlaidad = nacionlaidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Reserva getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Reserva idReserva) {
		this.idReserva = idReserva;
	}
	
	
	
	
	

}
