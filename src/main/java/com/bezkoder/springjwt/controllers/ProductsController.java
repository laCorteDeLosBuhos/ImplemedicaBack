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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Products;
import com.bezkoder.springjwt.payload.request.SaveProduct;
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
	@GetMapping("/eliminar/{ano}")
	public ResponseEntity<?> Eliminar(@PathVariable String ano){
		Object response;
		try {
			products.delete(products.getOne(ano));
			response="Eliminado Exitosamente";
			return ResponseEntity.ok(response);	
		} catch (Exception e) {
			response="Hay pedidos con este producto por lo cual no se puede eliminar";
			return ResponseEntity.ok(response);
		}
	}
	@PostMapping("/editar")
	public ResponseEntity<?> Editar(@Valid @RequestBody SaveProduct sve){
		Object response;
		try {
			Products product=new Products();
			product.setCodigo(sve.getCodigo());
			product.setDescripcion(sve.getDescripcion());
			product.setLinea(sve.getLinea());
			product.setMarca(sve.getMarca());
			product.setNombre(sve.getNombre());
			product.setPresentacion(sve.getPresentacion());
			product.setUrlImg(sve.getUrlImg());
			products.save(product);
			response="Editado Exitosamente";
			return ResponseEntity.ok(response);	
		} catch (Exception e) {
			response="Ha ocurrido un error";
			return ResponseEntity.ok(response);
		}
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
			byte[] decodedImg = Base64.getDecoder().decode(product.getBase64().getBytes(StandardCharsets.ISO_8859_1));
			Path destinationFile = Paths.get("fileTmp/", product.getNombre());
			Files.write(destinationFile, decodedImg);

			BufferedReader br = null;

			// Se define separador ","

			br = new BufferedReader(new InputStreamReader(new FileInputStream("fileTmp/"+ product.getNombre()),StandardCharsets.ISO_8859_1 ));
			saveProducts(br);
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
				System.out.println(line);
				datosarchivos.setNombre(datos[1].toUpperCase());
				datosarchivos.setCodigo(datos[2]);
				datosarchivos.setMarca(datos[6]);
				datosarchivos.setDescripcion(datos[4]);
				datosarchivos.setUrlImg(datos[0]);
				datosarchivos.setLinea(datos[3]);
				datosarchivos.setPresentacion(datos[5]);
				products.save(datosarchivos);
			}
			contador++;
		}
	}
}
