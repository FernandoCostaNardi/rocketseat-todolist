package com.sysconard.Glojas.schedules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sysconard.Glojas.controller.dashboard.jab.DashBoard_jabController;
import com.sysconard.Glojas.service.dashboard.DashboardPreProcessorService;

@Component
@EnableScheduling
public class ScheduleDashBoard {

    @Value("${jobs.enabled}")
    private boolean isEnabled;

    @Autowired
    private DashBoard_jabController dashboardPreProcessorService;

    @Scheduled(cron = "${jobs.atualizarDashboard:-}")
    public void ScheduleDashBoard() {
        if (isEnabled) {
            try {
//                dashboardPreProcessorService.DashboardPreProcessor();
            } catch(Exception e) {
                e.getMessage();
            }
        }
    }
}
