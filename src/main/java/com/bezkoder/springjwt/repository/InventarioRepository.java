package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Inventario;
import com.bezkoder.springjwt.models.Products;

public interface InventarioRepository extends JpaRepository<Inventario,Integer>{

}
