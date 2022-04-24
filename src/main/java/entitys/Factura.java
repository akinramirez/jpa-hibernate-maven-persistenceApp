package entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity(name = "Factura")
@Table(name = "FACTURA")
@Audited
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FECHA")
	private String fecha;

	@Column(name = "NUMERO")
	private Integer numero;

	@Column(name = "TOTAL")
	private Integer total;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_CLIENTE")
	private Cliente cliente;

	/* Relacion Uno a Muchos Unidireccional = Factura con Detalle de Factura */
	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// private List<DetalleFactura> facturasDet = new ArrayList<DetalleFactura>();

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> facturasDet = new ArrayList<DetalleFactura>();

	public Factura(String fecha, Integer numero, Integer total, Cliente cliente, List<DetalleFactura> facturasDet) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.cliente = cliente;
		this.facturasDet = facturasDet;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Factura(String fecha, Integer numero, Cliente cliente, List<DetalleFactura> facturasDet) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.cliente = cliente;
		this.facturasDet = facturasDet;
	}

	public List<DetalleFactura> getFacturasDet() {
		return facturasDet;
	}

	public void setFacturasDet(List<DetalleFactura> facturasDet) {
		this.facturasDet = facturasDet;
	}

	public Factura(String fecha, Integer numero, Cliente cliente) {
		super();
		this.fecha = fecha;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Factura(String fecha, Integer numero) {
		super();
		this.fecha = fecha;
		this.numero = numero;
	}

	public Factura() {
	}

}
