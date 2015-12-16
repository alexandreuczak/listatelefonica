package br.com.listatelefonica;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OperadorasRepositorio {

	public static Operadora OI = new Operadora(14, "OI", "Celular", new BigDecimal(2));
	public static Operadora VIVO = new Operadora(15, "VIVO", "Celular", new BigDecimal(1));
	public static Operadora TIM = new Operadora(41, "TIM", "Celular", new BigDecimal(3));
	public static Operadora GVT = new Operadora(25, "GVT", "FIXO", new BigDecimal(4));
	public static Operadora EMBRATEL = new Operadora(21, "EMBRATEL", "FIXO", new BigDecimal(2));

	
	
	public static List<Operadora>getOperadoras(){
		return Arrays.asList(OI, VIVO, TIM, GVT, EMBRATEL);
	}
}
