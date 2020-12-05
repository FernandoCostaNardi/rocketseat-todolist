package com.sysconard.pcbuilder.ordemServico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pcbuilder/ordem")
public class OrdemServicoController {

    public String listar(){
        return "EndPoint funcionando";
    }
}
