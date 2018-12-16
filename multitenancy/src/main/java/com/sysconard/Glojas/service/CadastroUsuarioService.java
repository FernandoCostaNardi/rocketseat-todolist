package com.sysconard.Glojas.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.sysconard.Glojas.service.exception.EmailUsuarioJaCadastradoException;
import com.sysconard.Glojas.service.exception.ImpossivelExcluirEntidadeException;
import com.sysconard.Glojas.service.exception.SenhaObrigatoriaUsuarioException;
import com.sysconard.Glojas.model.Usuario;
import com.sysconard.Glojas.repository.Usuarios;

@Service
public class CadastroUsuarioService {

	// ************ Injeta Repositorio de Usuários **************
	@Autowired
	private Usuarios usuarios;

	// ************ Injeta o PasswordEncoder **************
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> usuarioExistente = usuarios.findByEmail(usuario.getEmail());
		if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
			throw new EmailUsuarioJaCadastradoException("E-mail já cadastrado");
		}

		if (usuario.isNovo() && StringUtils.isEmpty(usuario.getSenha())) {
			throw new SenhaObrigatoriaUsuarioException("Senha é obrigatória para novo usuário");
		}

		if (usuario.isNovo() || !StringUtils.isEmpty(usuario.getSenha())) {
			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		} else if (StringUtils.isEmpty(usuario.getSenha())) {
			usuario.setSenha(usuarioExistente.get().getSenha());
		}
		usuario.setConfirmacaoSenha(usuario.getSenha());

		if (!usuario.isNovo() && usuario.getAtivo() == null) {
			usuario.setAtivo(usuarioExistente.get().getAtivo());
		}

		return usuarios.saveAndFlush(usuario);
	}

	@Transactional
	public void excluir(Long codigo) {
		try {
			usuarios.delete(codigo);
			usuarios.flush();
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException(
					"Impossivel apagar o usuário. Verifique com o administrador do sistema.");
		}
	}

	@Transactional
	public void alterarStatus(Long[] codigos, StatusUsuario statusUsuario) {
		statusUsuario.executar(codigos, usuarios);
	}
}
