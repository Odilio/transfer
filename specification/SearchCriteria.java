package br.com.b3.pip.gerenciarrecurso.specification;

import java.time.LocalDateTime;

public class SearchCriteria {

	private String key;
    private String operation;
    private Object value;
    private LocalDateTime dataUm;
    private LocalDateTime dataDois;
    
	public SearchCriteria(String key, String operation, Object value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	
	public SearchCriteria(String key, String operation, LocalDateTime dataUm, LocalDateTime dataDois) {
		super();
		this.key = key;
		this.operation = operation;
		this.dataDois = dataDois;
		this.dataUm = dataUm;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	public LocalDateTime getDataUm() {
		return dataUm;
	}

	public void setDataUm(LocalDateTime dataUm) {
		this.dataUm = dataUm;
	}

	public LocalDateTime getDataDois() {
		return dataDois;
	}

	public void setDataDois(LocalDateTime dataDois) {
		this.dataDois = dataDois;
	}
}
