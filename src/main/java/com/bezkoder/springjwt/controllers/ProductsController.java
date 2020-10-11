package com.bezkoder.springjwt.controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Products;
import com.bezkoder.springjwt.payload.request.SetProductRequest;
import com.bezkoder.springjwt.repository.ProductRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductsController {
	InputStream listas;
	@Autowired
	ProductRepository products;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> GetAllProducts(){
		return ResponseEntity.ok(products.findAll());
	}
	@GetMapping("/deleteAll")
	public ResponseEntity<?> DeleteProducts(){
		products.deleteAll();
		return ResponseEntity.ok("Ok");
	}
	@PostMapping("/setProducts")
	public ResponseEntity<?> SetProducts(@Valid @RequestBody SetProductRequest product){
		try {
			System.out.println(product.getNombre());
			byte[] decodedImg = Base64.getDecoder().decode(product.getBase64().getBytes(StandardCharsets.UTF_8));
			Path destinationFile = Paths.get("fileTmp/", product.getNombre());
			Files.write(destinationFile, decodedImg);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("fileTmp/"+ product.getNombre()),StandardCharsets.ISO_8859_1 ));
						
			saveProducts(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(products.findAll());
	}
	public void saveProducts(BufferedReader br) throws IOException  {
		String line = "";
		int contador = 1;
		while ((line = br.readLine()) != null) {
			if (contador != 1) {
				String[] datos = line.split(";");
				Products datosarchivos = new Products();				
				datosarchivos.setNombre(datos[1].toUpperCase());
				datosarchivos.setCodigo(datos[2]);
				datosarchivos.setMarca(datos[5]);
				datosarchivos.setDescripcion(datos[4]);
				datosarchivos.setUrlImg(datos[0]);
				datosarchivos.setLinea(datos[3]);
				datosarchivos.setPresentacion(datos[6]);
				products.save(datosarchivos);
			}
			contador++;
		}
	}
}
