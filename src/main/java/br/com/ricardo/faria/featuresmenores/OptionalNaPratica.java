package br.com.ricardo.faria.featuresmenores;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.ricardo.faria.exemplopratico.ImportacaoArquivo;
import br.com.ricardo.faria.modelos.Carro;
import br.com.ricardo.faria.modelos.CarroFactory;
import br.com.ricardo.faria.modelos.CarroNullObject;

public class OptionalNaPratica {

	private static ImportacaoArquivo importacao;

	static {
		importacao = new ImportacaoArquivo();
	}

	public static void main(String... args) {
		OptionalNaPratica.optionalDeCarros();
		OptionalNaPratica.optionalDeInteger();
	}

	private static void optionalDeCarros() {
		List<Carro> carros = importacao.getCarros();

		Optional<Carro> optCarro = carros.stream()
				.max((carro01, carro02) -> carro01.getNome().compareTo(carro02.getNome()));

		Carro carro = optCarro.orElse(new CarroNullObject());
		System.out.println("Primeiro carro n�o nulo: " + carro);

		optCarro = carros.stream().filter(c -> c.getAno() > 10000)
				.max((carro01, carro02) -> carro01.getNome().compareTo(carro02.getNome()));
		
		carro = optCarro.orElseGet(CarroFactory.getCarroConstructor());
		System.out.println("Segundo carro, agora nulo: " + carro);
		
		try {
			carro = optCarro.orElseThrow(() -> new IllegalStateException("Carro n�o encontrado."));			
		} catch (IllegalStateException e) {
			System.out.println("Terceiro carro, exception gerada: " + e.getMessage());
		}
	}

	private static void optionalDeInteger() {
		List<Integer> listaIntegers = Arrays.asList(1, 2, 3);

		Optional<Integer> optInteger = listaIntegers.stream().filter(i -> i > 10).findFirst();

		// Isto gera nullpointer
		// System.out.println(optInteger.get());

		System.out.println("Integer optional: " + optInteger.orElse(0));
	}
}
