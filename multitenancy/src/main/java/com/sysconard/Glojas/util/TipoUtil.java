package com.sysconard.Glojas.util;

import java.util.ArrayList;
import java.util.List;

public class TipoUtil {

	public List<String> tipoTroca() {
		List<String> tipoTroca = new ArrayList<String>();
		tipoTroca.add("051");
		tipoTroca.add("065");
		return tipoTroca;
	}

	public List<String> tipoPDV() {
		List<String> tipoPDV = new ArrayList<String>();
		tipoPDV.add("009");
		return tipoPDV;
	}

	public List<String> tipoDanfe() {
		List<String> tipoDanfe = new ArrayList<String>();
		tipoDanfe.add("015");
		tipoDanfe.add("002");
		return tipoDanfe;
	}
	
	public List<String> tipoPDVEDanfe() {
		List<String> tipoPDVEDanfe = new ArrayList<String>();
		tipoPDVEDanfe.add("009");
		tipoPDVEDanfe.add("015");
		tipoPDVEDanfe.add("002");
		return tipoPDVEDanfe;
	}

}
