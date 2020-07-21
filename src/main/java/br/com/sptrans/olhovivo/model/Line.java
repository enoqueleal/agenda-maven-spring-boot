package br.com.sptrans.olhovivo.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Line {
	
	@JsonSetter("cl")
	private Integer codigoIdentificador;
	
	@JsonSetter("lc")
	private Boolean linhaCircular;
	
	@JsonSetter("lt")
	private String letreiroParteUm;
	
	@JsonSetter("tl")
	private Integer letreiroParteDois;
	
	@JsonSetter("sl")
	private Integer sentido;
	
	@JsonSetter("tp")
	private String descritivoIda;
	
	@JsonSetter("ts")
	private String descritivoVolta;

	public Integer getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public String getDescritivoIda() {
		return descritivoIda;
	}

	public String getDescritivoVolta() {
		return descritivoVolta;
	}

	public Integer getLetreiroParteDois() {
		return letreiroParteDois;
	}

	public String getLetreiroParteUm() {
		return letreiroParteUm;
	}

	public Boolean getLinhaCircular() {
		return linhaCircular;
	}

	public Integer getSentido() {
		return sentido;
	}

	public void setCodigoIdentificador(Integer codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}

	public void setDescritivoIda(String descritivoIda) {
		this.descritivoIda = descritivoIda;
	}

	public void setDescritivoVolta(String descritivoVolta) {
		this.descritivoVolta = descritivoVolta;
	}

	public void setLetreiroParteDois(Integer letreiroParteDois) {
		this.letreiroParteDois = letreiroParteDois;
	}

	public void setLetreiroParteUm(String letreiroParteUm) {
		this.letreiroParteUm = letreiroParteUm;
	}

	public void setLinhaCircular(Boolean linhaCircular) {
		this.linhaCircular = linhaCircular;
	}

	public void setSentido(Integer sentido) {
		this.sentido = sentido;
	}

}
