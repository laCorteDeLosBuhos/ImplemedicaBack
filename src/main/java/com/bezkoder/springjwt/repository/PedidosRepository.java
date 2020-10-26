package com.bezkoder.springjwt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos,Long>{
	@Query("SELECT p FROM Pedidos p WHERE p.correo=?1")
	List<Pedidos> findby(String a);
}
