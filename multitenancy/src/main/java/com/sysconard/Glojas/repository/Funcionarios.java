package com.sysconard.Glojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysconard.Glojas.model.Funcionario;
import com.sysconard.Glojas.repository.helper.funcionario.FuncionariosQueries;

public interface Funcionarios extends JpaRepository<Funcionario, Long>, FuncionariosQueries {

}
