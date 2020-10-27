package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bezkoder.springjwt.models.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Integer>{
}
