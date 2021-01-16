package com.sysconard.Glojas.service.dashboard.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysconard.Glojas.DTO.dashboard.InfoProdutoDashboard;
import com.sysconard.Glojas.DTO.dashboard.InfoVendedoresDashboardDTO;
import com.sysconard.Glojas.DTO.dashboard.TotaisDashboardDTO;
import com.sysconard.Glojas.controller.dashboard.jab.DashBoard_jabController;
import com.sysconard.Glojas.model.DashboardPreProcessor;
import com.sysconard.Glojas.repository.DashboardPreProcessorRepository;
import com.sysconard.Glojas.service.dashboard.DashboardPreProcessorService;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioAnoService;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioDiaService;
import com.sysconard.Glojas.service.dashboard.VendaFuncionarioMesService;
import com.sysconard.Glojas.service.dashboard.VendaProdutoDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaQuantidadeFuncionarioService;
import com.sysconard.Glojas.service.dashboard.VendaTotaLDoDiaDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaTotalDoAnoDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaTotalDoMesDashboardService;
import com.sysconard.Glojas.service.dashboard.VendaTrocaFuncionarioService;

@Service
public class DashboardPreProcessorServiceImpl implements DashboardPreProcessorService {

    @Autowired
    private DashBoard_jabController dashBoard_jabController;
 
    @Override
    public void DashboardPreProcessor() {
//        dashBoard_jabController.DashboardPreProcessor();
    }
}
