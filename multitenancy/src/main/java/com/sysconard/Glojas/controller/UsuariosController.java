package com.sysconard.Glojas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sysconard.Glojas.controller.page.PageWrapper;
import com.sysconard.Glojas.model.Usuario;
import com.sysconard.Glojas.repository.Grupos;
import com.sysconard.Glojas.repository.Usuarios;
import com.sysconard.Glojas.repository.filter.UsuarioFilter;
import com.sysconard.Glojas.service.CadastroUsuarioService;
import com.sysconard.Glojas.service.StatusUsuario;
import com.sysconard.Glojas.service.exception.EmailUsuarioJaCadastradoException;
import com.sysconard.Glojas.service.exception.ImpossivelExcluirEntidadeException;
import com.sysconard.Glojas.service.exception.SenhaObrigatoriaUsuarioException;

@Controller
@RequestMapping("/login/usuarios")
public class UsuariosController {

	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;

	@Autowired
	private Grupos grupos;

	@Autowired
	private Usuarios usuarios;

	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}

	@RequestMapping(value = { "/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuario);
		}

		try {
			cadastroUsuarioService.salvar(usuario);
		} catch (EmailUsuarioJaCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(usuario);
		} catch (SenhaObrigatoriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(usuario);
		}
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return new ModelAndView("redirect:/usuarios/novo");
	}
	
	@GetMapping
 	public ModelAndView pesquisar(UsuarioFilter usuarioFilter, @PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("usuario/PesquisaUsuario");
		mv.addObject("grupos", grupos.findAll());
		
		PageWrapper<Usuario> paginaWrapper = new PageWrapper<>(usuarios.filtrar(usuarioFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	@PutMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarStatus(@RequestParam("codigos[]") Long[] codigos, @RequestParam("status") StatusUsuario statusUsuario) {
		cadastroUsuarioService.alterarStatus(codigos, statusUsuario);
	}
	
	// ************ Apaga Usuário **************
			@DeleteMapping("/{codigo}")
			public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long codigo) {
				try {
					cadastroUsuarioService.excluir(codigo);
				} catch (ImpossivelExcluirEntidadeException e) {
					System.out.println(e.getMessage());
					return ResponseEntity.badRequest().body(e.getMessage());
				}
				return ResponseEntity.ok().build();
			}
		
			// ************ Edita Usuario **************

			@GetMapping("/{codigo}")
			public ModelAndView editar(@PathVariable Long codigo) {
				Usuario usuario = usuarios.buscarComGrupos(codigo);
				ModelAndView mv = novo(usuario);
				mv.addObject(usuario);
				return mv;
			}
	
	
}