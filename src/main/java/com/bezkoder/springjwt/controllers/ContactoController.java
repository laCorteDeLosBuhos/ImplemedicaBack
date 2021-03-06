package com.bezkoder.springjwt.controllers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.SendMail;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/correo")
public class ContactoController {
	@Value("${spring.mail.username}")
	private String Remitente;
	@Autowired
	private JavaMailSender javaMailSender;
	@PostMapping("/getAll")
	public String enviarMail(@Valid @RequestBody SendMail request) {
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
		System.out.println(request.getComentario());
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("implemedica.virtual@gmail.com");
		helper.setCc("ventas@implemedica.com.co");
		helper.setFrom("implemedica.virtual@gmail.com");
		Path path=Paths.get("/app/src/main/resources/index.html");
		byte[] encoded = Files.readAllBytes(path);
		String body = new String(encoded, StandardCharsets.UTF_8);
		System.out.println(request.getCorreo());
		body=body.replace("{nombre}", request.getNombre());
		body=body.replace("{dedica}", request.getDedica());
		body=body.replace("{correo}", request.getCorreo());
		body=body.replace("{telefono}", request.getTelefono());
		body=body.replace("{comentario}", request.getComentario());
		helper.setText(body,true);
		helper.setSubject("Haz recibido una solicitud de contacto.");
		javaMailSender.send(msg);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "correo fallido";
		}
		
		return "correo enviado";
	}
}
