package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitys.Articulo;
import entitys.Categoria;
import entitys.Cliente;
import entitys.DetalleFactura;
import entitys.Domicilio;
import entitys.Factura;

public class PersistenceApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
//			/* Creacion Factura */
//			Factura factura1 = new Factura();
//			factura1.setNumero(1212);
//			factura1.setFecha("20220424");
//
//			/* Relacion Domicilio y Cliente */
//			Domicilio domicilio = new Domicilio("Tegucigalpa", 5697);
//			Cliente cliente = new Cliente("Akin", "Ramirez", 801199512);
//			cliente.setDomicilio(domicilio);
//			domicilio.setCliente(cliente);
//
//			/* Relacion Cliente y Factura */
//			factura1.setCliente(cliente);
//
//			/* Creacion de Categorias */
//			Categoria perecederos = new Categoria("Perecederos");
//			Categoria lacteos = new Categoria("Lacteos");
//			Categoria limpieza = new Categoria("Limpieza");
//
//			/* Creacion de Articulos */
//			Articulo aarticulo1 = new Articulo(200, "Pollo Rostizado", 110);
//			Articulo aarticulo2 = new Articulo(300, "Leche Descremada", 50);
//			Articulo aarticulo3 = new Articulo(400, "Jabon Xtra", 80);
//
//			/* Relacion Articulo y Categorias */
//			aarticulo1.getCategorias().add(perecederos);
//			perecederos.getArticulos().add(aarticulo1);
//
//			aarticulo2.getCategorias().add(perecederos);
//			aarticulo2.getCategorias().add(lacteos);
//			lacteos.getArticulos().add(aarticulo2);
//			perecederos.getArticulos().add(aarticulo2);
//
//			aarticulo3.getCategorias().add(limpieza);
//			limpieza.getArticulos().add(aarticulo3);
//
//			/* Creacion DetalleFactura 1 */
//			DetalleFactura det1 = new DetalleFactura();
//			det1.setArticulo(aarticulo1);
//			det1.setCantidad(2);
//			det1.setSubtotal(40);
//
//			/* Relacion Articulo y DetalleFactura */
//			aarticulo1.getFacturas().add(det1);
//			factura1.getFacturasDet().add(det1);
//			det1.setFactura(factura1);
//
//			/* Creacion DetalleFactura 2 */
//			DetalleFactura det2 = new DetalleFactura();
//			det2.setArticulo(aarticulo2);
//			det2.setCantidad(1);
//			det2.setSubtotal(80);
//
//			aarticulo2.getFacturas().add(det2);
//			factura1.getFacturasDet().add(det2);
//			det2.setFactura(factura1);
//
//			/* Creacion DetalleFactura 3 */
//			DetalleFactura det3 = new DetalleFactura();
//			det3.setArticulo(aarticulo3);
//			det3.setCantidad(1);
//			det3.setSubtotal(100);
//
//			aarticulo3.getFacturas().add(det3);
//			factura1.getFacturasDet().add(det3);
//			det3.setFactura(factura1);
//
//			factura1.setTotal(260);
//			em.persist(factura1);
			
			
			/* Prueba Auditoria */
//			Factura factura = em.find(Factura.class, 1L);
//			factura.setNumero(86);
//			em.merge(factura);
//			em.remove(factura);
			
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.getMessage();
		} finally {
			em.close();
			emf.close();
		}

	}
}
