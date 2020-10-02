package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad,Integer>{

}
