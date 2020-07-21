
package br.com.sptrans.olhovivo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Location {

	@JsonSetter("hr")
	private String horario;

	@JsonSetter("vs")
	private List<Bus> onibus;;

	public String getHorario() {
		return horario;
	}

	public List<Bus> getOnibus() {
		return onibus;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setOnibus(List<Bus> onibus) {
		this.onibus = onibus;
	}

}
