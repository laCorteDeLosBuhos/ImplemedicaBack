package com.bezkoder.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos,Long>{

}
