package entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity(name = "Domicilio")
@Table(name = "DOMICILIO")
@Audited
public class Domicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE_CALLE")
	private String nombreCalle;

	@Column(name = "NUMERO")
	private Integer numero;

	/* Relacion Uno a Uno Bidireccinal = Cliente con Domicilio */
	@OneToOne(mappedBy = "domicilio")
	private Cliente cliente;

	public Domicilio(Long id, String nombreCalle, Integer numero, Cliente cliente) {
		super();
		this.id = id;
		this.nombreCalle = nombreCalle;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Domicilio(String nombreCalle, Integer numero) {
		super();
		this.nombreCalle = nombreCalle;
		this.numero = numero;
	}

	public Domicilio() {
	}

	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", nombreCalle=" + nombreCalle + ", numero=" + numero + ", cliente=" + cliente
				+ "]";
	}

}
