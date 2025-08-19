package com.sysconard.Glojas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.Usuario;
import com.sysconard.Glojas.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findByCodigoIn(Long[] codigos);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.ativo = CAST(:ativo AS boolean)")
	Usuario findByEmailAndAtivo(
			@Param("email") String email,
			@Param("ativo") Integer ativo
	);
		
}
