package com.abellozano.microservice_user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.abellozano.microservice_user.dto.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
    Page<Usuario> findAll(Pageable pageable);
    
}