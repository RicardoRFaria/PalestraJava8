package br.com.ricardo.faria.modelos;

public class CarroNullObject extends Carro {
	
	@Override
	public int getAno() {
		return 0;
	}
	
	@Override
	public String getMarca() {
		return "Inexistente";
	}
	
	@Override
	public int getId() {
		return 0;
	}
	
	@Override
	public int getIdade() {
		return 0;
	}
	
	@Override
	public String getKey() {
		return "Inexistente";
	}
	
	@Override
	public String getNome() {
		return "Inexistente";
	}

	@Override
	public String toString() {
		return "CarroNullObject [getAno()=" + getAno() + ", getMarca()=" + getMarca() + ", getId()=" + getId()
				+ ", getIdade()=" + getIdade() + ", getKey()=" + getKey() + ", getNome()=" + getNome() + "]";
	}

}
