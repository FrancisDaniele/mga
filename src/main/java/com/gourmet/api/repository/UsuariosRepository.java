package com.gourmet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gourmet.api.entity.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}