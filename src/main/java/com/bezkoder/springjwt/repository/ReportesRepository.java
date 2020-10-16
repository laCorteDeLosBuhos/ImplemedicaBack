package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bezkoder.springjwt.models.Pedidos;

public interface ReportesRepository extends JpaRepository<Pedidos,Long>{
	@Query("SELECT p FROM Pedidos p WHERE month(p.fecha)=?1 and year(p.fecha)=?2 and p.estado='Entregado'")
	List<Pedidos> findbyyear(int mes,int ano);
}
