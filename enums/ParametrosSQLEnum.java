package br.com.b3.pip.gerenciarrecurso.enums;

public enum ParametrosSQLEnum {
	IGUAL(":"),
	MAIOR(">"),
	MENOR("<"),
	SOMENTE_NULO("is null"),
	BETWEEN("between");
	
	private String tipo;
	
	ParametrosSQLEnum(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
}
