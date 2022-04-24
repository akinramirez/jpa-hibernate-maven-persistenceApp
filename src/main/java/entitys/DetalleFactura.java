package entitys;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity(name = "DetalleFactura")
@Table(name = "DETALLE_FACTURA")
@Audited
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@Column(name = "CANTIDAD")
	private Integer cantidad;

	@Column(name = "SUBTOTAL")
	private Integer subtotal;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ARTICULO")
	private Articulo articulo;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_FACTURA")
	private Factura factura;

	public DetalleFactura(Integer cantidad, Integer subtotal, Articulo articulo, Factura factura) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articulo = articulo;
		this.factura = factura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public DetalleFactura(Integer cantidad, Integer subtotal, Articulo articulo) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articulo = articulo;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DetalleFactura(Integer cantidad, Integer subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public DetalleFactura() {

	}
}
