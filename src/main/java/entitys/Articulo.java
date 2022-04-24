package entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity(name = "Articulo")
@Table(name = "ARTICULO")
@Audited
public class Articulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CANTIDAD")
	private Integer cantidad;

	@Column(name = "DENOMINACION")
	private String denominacion;

	@Column(name = "PRECIO")
	private Integer precio;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
	private List<DetalleFactura> facturas = new ArrayList<DetalleFactura>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ARTICULO_CATEGORIA", joinColumns = @JoinColumn(name = "ARTICULO_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORIA_ID"))
	private List<Categoria> categorias = new ArrayList<Categoria>();

	public Articulo(Integer cantidad, String denominacion, Integer precio, List<DetalleFactura> facturas,
			List<Categoria> categorias) {
		super();
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
		this.facturas = facturas;
		this.categorias = categorias;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Articulo(Integer cantidad, String denominacion, Integer precio, List<DetalleFactura> facturas) {
		super();
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
		this.facturas = facturas;
	}

	public List<DetalleFactura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<DetalleFactura> facturas) {
		this.facturas = facturas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Articulo(Integer cantidad, String denominacion, Integer precio) {
		super();
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
	}

	public Articulo() {

	}

}
