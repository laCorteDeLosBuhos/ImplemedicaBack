package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Ciudad;
import com.bezkoder.springjwt.models.DetallePedido;
import com.bezkoder.springjwt.models.Pedidos;
import com.bezkoder.springjwt.models.Products;
import com.bezkoder.springjwt.payload.request.PedidosRequest;
import com.bezkoder.springjwt.payload.request.SavePedidoRequest;
import com.bezkoder.springjwt.repository.CiudadRepository;
import com.bezkoder.springjwt.repository.DetallePedidoRepository;
import com.bezkoder.springjwt.repository.PedidosRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {
	@Autowired
	private PedidosRepository pedidosRepository;
	@Autowired
	private DetallePedidoRepository detallepedidosRepository;
	@Autowired
	private CiudadRepository ciudadRepository;
	@SuppressWarnings("null")
	@PostMapping("/newPedido")
	public ResponseEntity<?> newPedido(@Valid @RequestBody PedidosRequest product){
		try {
			Pedidos ped = new Pedidos();
			ped.setNombre(product.getNombre());
			ped.setFecha(product.getFecha());
			ped.setNombre(product.getNombre());
			ped.setTipoDoc(product.getTipoDoc());
			ped.setNumDoc(product.getNumDoc());
			ped.setCorreo(product.getCorreo());
			ped.setDireccion(product.getDireccion());
			ped.setTelefono(product.getTelefono());
			Ciudad cd = this.ciudadRepository.getOne(product.getCiudad().getId()); 
			ped.setCiudad(cd);
			ped.setObservaciones(product.getObservaciones());
			ped.setEstado("Pendiente");
			List<DetallePedido> productos= product.getProductos();
			List<DetallePedido> products = new ArrayList<DetallePedido>();
			for (DetallePedido detalle:productos) {
				DetallePedido detail=new DetallePedido();
				detail.setCantidad(detalle.getCantidad());
				detail.setProducto(detalle.getProducto());
				detallepedidosRepository.save(detail);
				System.out.println(detail.getId());
				products.add(detail);
			}
			ped.setProductos(products);
			pedidosRepository.save(ped);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> GetAllProducts(){
		return ResponseEntity.ok(pedidosRepository.findAll());
	}
	@PostMapping("/savePedido")
	public ResponseEntity<?> savePedido(@Valid @RequestBody SavePedidoRequest product){
		try {
			Pedidos ped= new Pedidos();
			ped.setId(product.getId());
			ped.setNombre(product.getNombre());
			ped.setFecha(product.getFecha());
			ped.setNombre(product.getNombre());
			ped.setTipoDoc(product.getTipoDoc());
			ped.setNumDoc(product.getNumDoc());
			ped.setCorreo(product.getCorreo());
			ped.setDireccion(product.getDireccion());
			ped.setTelefono(product.getTelefono());
			Ciudad cd = this.ciudadRepository.getOne(product.getCiudad().getId()); 
			ped.setCiudad(cd);
			ped.setObservaciones(product.getObservaciones());
			ped.setEstado("Pendiente");
			List<DetallePedido> productos= product.getProductos();
			List<DetallePedido> products = new ArrayList<DetallePedido>();
			for (DetallePedido detalle:productos) {
				detallepedidosRepository.save(detalle);
				System.out.println(detalle.getId());
				products.add(detalle);
			}
			ped.setProductos(products);
			pedidosRepository.save(ped);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
	}
}
