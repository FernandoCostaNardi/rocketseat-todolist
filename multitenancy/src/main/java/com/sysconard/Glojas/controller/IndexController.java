package com.sysconard.Glojas.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sysconard.Glojas.security.UsuarioSistema;

@Controller
@RequestMapping("/login/tenant")
public class IndexController {
	
//	implements ErrorController
//	private static final String PATH = "/error";
	
//	@Autowired
//	private Usuarios usuarios;
	
	@RequestMapping
	public String index(@AuthenticationPrincipal UsuarioSistema usuarioSistema) {
		System.out.println(usuarioSistema.getUsername());
		String banco = usuarioSistema.getUsuario().getBanco().toString();
		return "redirect:/dashboard/" + banco + "/dashboard/welcome";
	}
	
//	@RequestMapping
//	public String dash() {
//		String banco = "jab";
//		return "redirect:/dashboard/" + banco + "/dashboard";
//	}
	
//	 @RequestMapping(value = PATH)
//	public String error(@AuthenticationPrincipal UsuarioSistema usuarioSistema) {
//		 String banco = usuarios.buscarBancoDoCliente();
//			return "redirect:/dashboard/" + banco + "/dashboard";
//	}
//	
//	 @Override
//	    public String getErrorPath() {
//	        return PATH;
//	    }
}
