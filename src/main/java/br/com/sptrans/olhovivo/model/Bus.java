package br.com.sptrans.olhovivo.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Bus {
	
	@JsonSetter("p")
	private String prefixo;

	@JsonSetter("a")
	private boolean veiculoAcessivel;

	@JsonSetter("ta")
	private String horario;

	@JsonSetter("py")
	private String latitude;

	@JsonSetter("px")
	private String longitude;

	public String getHorario() {
		return horario;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public boolean isVeiculoAcessivel() {
		return veiculoAcessivel;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public void setVeiculoAcessivel(boolean veiculoAcessivel) {
		this.veiculoAcessivel = veiculoAcessivel;
	}

}
