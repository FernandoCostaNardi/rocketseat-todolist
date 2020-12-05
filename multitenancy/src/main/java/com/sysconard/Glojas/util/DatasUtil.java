package com.sysconard.Glojas.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DatasUtil {

	public String diaDeHoje() {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String diaDeHoje = data.format(formatter);
		return diaDeHoje;
	}
	
	
	public String primeiroDiaDoMesString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime primeiroDiaDoMesData = data.with(TemporalAdjusters.firstDayOfMonth());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String primeiroDiaDoMes = primeiroDiaDoMesData.format(formatter);
		return primeiroDiaDoMes;
	}

	public String UltimoDiaDoMesString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime ultimoDiaDoMesData = data.with(TemporalAdjusters.lastDayOfMonth());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ultimoDiaDoMes = ultimoDiaDoMesData.format(formatter);
		return ultimoDiaDoMes;
	}
	
	public String primeiroDiaDoAnoString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime primeiroDiaDoAnoData = data.with(TemporalAdjusters.firstDayOfYear());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String primeiroDiaDoAno = primeiroDiaDoAnoData.format(formatter);
		return primeiroDiaDoAno;
	}

	public String UltimoDiaDoAnoString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime ultimoDiaDoAnoData = data.with(TemporalAdjusters.lastDayOfYear());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ultimoDiaDoAno = ultimoDiaDoAnoData.format(formatter);
		return ultimoDiaDoAno;
	}
	
	public String primeiroDiaDoMes_90diasString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime noventaDiasAtrasData = data.with(TemporalAdjusters.firstDayOfMonth()).minusMonths(3);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String noventaDiasAtras = noventaDiasAtrasData.format(formatter);
		return noventaDiasAtras;
	}
	
	public String UltimoDiaDoMes_90diasString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime noventaDiasAtrasData = data.with(TemporalAdjusters.lastDayOfMonth()).minusMonths(3);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String noventaDiasAtras = noventaDiasAtrasData.format(formatter);
		return noventaDiasAtras;
	}
	
	public String primeiroDiaDoMes_60diasString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime sessentaDiasAtrasData = data.with(TemporalAdjusters.firstDayOfMonth()).minusMonths(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String sessentaDiasAtras = sessentaDiasAtrasData.format(formatter);
		return sessentaDiasAtras;
	}
	
	public String UltimoDiaDoMes_60diasString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime sessentaDiasAtrasData = data.with(TemporalAdjusters.lastDayOfMonth()).minusMonths(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String sessentaDiasAtras = sessentaDiasAtrasData.format(formatter);
		return sessentaDiasAtras;
	}
	
	public String primeiroDiaDoMes_30diasString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime trintaDiasAtrasData = data.with(TemporalAdjusters.firstDayOfMonth()).minusMonths(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String trintaDiasAtras = trintaDiasAtrasData.format(formatter);
		return trintaDiasAtras;
	}
	
	public String UltimoDiaDoMes_30diasString() {

		LocalDateTime data = LocalDateTime.now();
		LocalDateTime trintaDiasAtrasData = data.with(TemporalAdjusters.lastDayOfMonth()).minusMonths(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String trintaDiasAtras = trintaDiasAtrasData.format(formatter);
		return trintaDiasAtras;
	}

	public Timestamp conversordeTimeStamp(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataconvertida = formato.parse(data);
		Timestamp timestamp = new Timestamp(dataconvertida.getTime());
	
		return timestamp;
	}

	public Timestamp SysDataDeHoje() {
		LocalDate now = LocalDate.now();
		return Timestamp.valueOf(now.atStartOfDay());
	}
	
	public Timestamp SysDataPrimeiroDiaDoMesAtual(){
		Timestamp primeiroDiaDoMesAtual = null;
		try {
			primeiroDiaDoMesAtual = conversordeTimeStamp(primeiroDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return primeiroDiaDoMesAtual;
	}
	
	public Timestamp SysDataUltimoDiaDoMesAtual(){
		Timestamp ultimoDiaDoMesAtual = null;
		try {
			ultimoDiaDoMesAtual = conversordeTimeStamp(UltimoDiaDoMesString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ultimoDiaDoMesAtual;
	}
	
	public Timestamp SysDataPrimeiroDiaDoAnoAtual(){
		Timestamp primeiroDiaDoAnoAtual = null;
		try {
			primeiroDiaDoAnoAtual = conversordeTimeStamp(primeiroDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return primeiroDiaDoAnoAtual;
	}
	
	public Timestamp SysDataUltimoDiaDoAnoAtual(){
		Timestamp ultimoDiaDoAnoAtual = null;
		try {
			ultimoDiaDoAnoAtual = conversordeTimeStamp(UltimoDiaDoAnoString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ultimoDiaDoAnoAtual;
	}
	
	public Timestamp SysData(String dataString){
		Timestamp data = null;
		try {
			data = conversordeTimeStamp(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
		
}
