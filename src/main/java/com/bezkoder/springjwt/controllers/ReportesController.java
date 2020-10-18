package com.bezkoder.springjwt.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.DetallePedido;
import com.bezkoder.springjwt.models.Pedidos;
import com.bezkoder.springjwt.repository.ReportesRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reportes")
public class ReportesController {
	@Autowired
	private ReportesRepository ciudadRepository;
	@GetMapping("/getAll/{ano}")
	public ResponseEntity<?> GetDatos(@PathVariable int ano){
		int[] is = new int[12];
		for (int i = 0; i < 12; i++) {
			is[i]=ciudadRepository.findbyyear(i+1, ano).size();
		}
		return ResponseEntity.ok(is);
	}
	@GetMapping("/getAllMarca/{ano}/{linea}")
	public ResponseEntity<?> GetDatosMarca(@PathVariable int ano,@PathVariable String linea){
		int[] is = new int[12];
		for (int i = 0; i < 12; i++) {
			int cantidad=0;
			List<Pedidos> pedidos=ciudadRepository.findbyyear(i+1, ano);
			for (Pedidos detalle:pedidos) {
				for (DetallePedido detalles:detalle.getProductos()) {
					if(detalles.getProducto().getLinea().startsWith(linea)) {
						cantidad=cantidad+detalles.getCantidad();
					}
				}	
			}
			is[i]=cantidad;
		}
		return ResponseEntity.ok(is);
	}
}
