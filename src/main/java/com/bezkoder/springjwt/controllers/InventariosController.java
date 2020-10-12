package com.bezkoder.springjwt.controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Inventario;
import com.bezkoder.springjwt.models.Products;
import com.bezkoder.springjwt.payload.request.SetProductRequest;
import com.bezkoder.springjwt.repository.InventarioRepository;
import com.bezkoder.springjwt.repository.ProductRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/inventarios")
public class InventariosController {
	@Autowired
	private InventarioRepository inventario;
	@Autowired
	private ProductRepository productos;
	@GetMapping("/getAll")
	public ResponseEntity<?> GetAllProducts(){
		return ResponseEntity.ok(inventario.findAll());
	}
	@PostMapping("/setInventario")
	public ResponseEntity<?> SetProducts(@Valid @RequestBody SetProductRequest product){
		try {
			System.out.println(product.getNombre());
			byte[] decodedImg = Base64.getDecoder().decode(product.getBase64().getBytes(StandardCharsets.UTF_8));
			Path destinationFile = Paths.get("fileTmp/", product.getNombre());
			Files.write(destinationFile, decodedImg);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("fileTmp/"+ product.getNombre()),StandardCharsets.ISO_8859_1 ));
						
			saveInventario(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(HttpStatus.OK);
	}
	public void saveInventario(BufferedReader br) throws IOException  {
		String line = "";
		int contador = 1;
		while ((line = br.readLine()) != null) {
			if (contador != 1) {
				String[] datos = line.split(";");
				if(inventario.getOne(Integer.parseInt(datos[0]))!=null) {
					Inventario datosarchivos = inventario.getOne(Integer.parseInt(datos[0]));
					datosarchivos.setCantidad(Integer.parseInt(datos[1])+datosarchivos.getCantidad());
					inventario.save(datosarchivos);
				}
				else {
					Inventario datosarchivos = new Inventario();
					datosarchivos.setProduct_id(Integer.parseInt(datos[0]));
					datosarchivos.setProducto(productos.getOne(datos[0]));
					datosarchivos.setCantidad(Integer.parseInt(datos[1]));;
					inventario.save(datosarchivos);	
				}
			}
			contador++;
		}
		System.out.println("Finalizo aqui");
	}
}
