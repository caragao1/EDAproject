package entities;

import java.io.Serializable;

public class CovidDados implements Serializable {
	private String cidade;
	private int casos,obitos;
	public CovidDados() {
	}

	public CovidDados(String cidade, int casos, int obitos){
		super();
		this.cidade = cidade;
		this.casos = casos;
		this.obitos = obitos;
	}

	public String getCidade() {
		return cidade;
	}

	public Integer getCasos() {
		return casos;
	}

	public Integer getObitos() {
		return obitos;
	}


	@Override
	public String toString() {
		return "CovidDados [cidade= " + cidade + ", casos= " + casos + ", obitos= " + obitos + "]";
	}
}
