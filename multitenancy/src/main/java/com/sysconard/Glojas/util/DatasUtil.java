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

		// Obter o primeiro dia do mês passado
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime firstDayOfLastMonth = now.with(TemporalAdjusters.firstDayOfMonth());

		// Definir o primeiro segundo do dia
		LocalDateTime firstSecondOfDay = firstDayOfLastMonth.withHour(0).withMinute(0).withSecond(0);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return firstSecondOfDay.format(formatter);
	}

	public String UltimoDiaDoMesString() {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime lastDayOfTwoMonthsAgo = now.with(TemporalAdjusters.lastDayOfMonth());

		// Definir o último segundo do dia
		LocalDateTime lastSecondOfDay = lastDayOfTwoMonthsAgo.withHour(23).withMinute(59).withSecond(59);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return lastSecondOfDay.format(formatter);
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

		// Obter o primeiro dia do mês passado
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime firstDayOfLastMonth = now.minusMonths(3).with(TemporalAdjusters.firstDayOfMonth());

		// Definir o primeiro segundo do dia
		LocalDateTime firstSecondOfDay = firstDayOfLastMonth.withHour(0).withMinute(0).withSecond(0);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return firstSecondOfDay.format(formatter);
	}
	
	public String UltimoDiaDoMes_90diasString() {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime lastDayOfTwoMonthsAgo = now.minusMonths(3)
				.with(TemporalAdjusters.lastDayOfMonth());

		// Definir o último segundo do dia
		LocalDateTime lastSecondOfDay = lastDayOfTwoMonthsAgo.withHour(23).withMinute(59).withSecond(59);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return lastSecondOfDay.format(formatter);
	}
	
	public String primeiroDiaDoMes_60diasString() {

		// Obter o primeiro dia do mês passado
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime firstDayOfLastMonth = now.minusMonths(2).with(TemporalAdjusters.firstDayOfMonth());

		// Definir o primeiro segundo do dia
		LocalDateTime firstSecondOfDay = firstDayOfLastMonth.withHour(0).withMinute(0).withSecond(0);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return firstSecondOfDay.format(formatter);
	}
	
	public String UltimoDiaDoMes_60diasString() {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime lastDayOfTwoMonthsAgo = now.minusMonths(2)
				.with(TemporalAdjusters.lastDayOfMonth());

		// Definir o último segundo do dia
		LocalDateTime lastSecondOfDay = lastDayOfTwoMonthsAgo.withHour(23).withMinute(59).withSecond(59);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return lastSecondOfDay.format(formatter);

	}
	
	public String primeiroDiaDoMes_30diasString() {

		// Obter o primeiro dia do mês passado
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime firstDayOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());

		// Definir o primeiro segundo do dia
		LocalDateTime firstSecondOfDay = firstDayOfLastMonth.withHour(0).withMinute(0).withSecond(0);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return firstSecondOfDay.format(formatter);
	}
	
	public String UltimoDiaDoMes_30diasString() {
		// Obter o último dia do mês passado
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime lastDayOfMonth = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

		// Definir o último segundo do dia
		LocalDateTime lastSecondOfDay = lastDayOfMonth.withHour(23).withMinute(59).withSecond(59);

		// Formatar a data e hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return lastSecondOfDay.format(formatter);
	}

	public Timestamp conversordeTimeStamp(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataconvertida = formato.parse(data);
		Timestamp timestamp = new Timestamp(dataconvertida.getTime());
	
		return timestamp;
	}

	public Timestamp SysDataDeHojeS() {
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
