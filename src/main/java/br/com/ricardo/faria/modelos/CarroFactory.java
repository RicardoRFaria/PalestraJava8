package br.com.ricardo.faria.modelos;

import java.util.function.Supplier;

public class CarroFactory {
	
	private static final Supplier<Carro> nullObjectFactory;
	
	static {
		nullObjectFactory = () -> new CarroNullObject();
	}

	public static Supplier<Carro> getCarroConstructor() {
		return nullObjectFactory;
	}
	
}
