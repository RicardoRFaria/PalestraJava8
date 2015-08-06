package lambdas;

import java.util.List;
import java.util.function.Predicate;

import exemplopratico.ImportacaoArquivo;
import modelos.Carro;

public class VariasManeirasDeSeEscreverLambda {

	private static ImportacaoArquivo importacao;

	static {
		importacao = new ImportacaoArquivo();
	}

	public static void main(String[] args) {
		List<Carro> carros = importacao.getCarros();

		// Método antigo, com classe anônima
		long tamanho = carros.stream().filter(new Predicate<Carro>() {
			@Override
			public boolean test(Carro t) {
				return false;
			}
		}).count();
		System.out.println("Classe anônima, tamanho: " + tamanho);
		
		
		// Lambda completa
		carros.stream().filter((Carro carro) -> {
			return !carro.getMarca().equals("teste");
		});

		// Lambda com tipo omitido
		carros.stream().filter((carro) -> {
			return !carro.getMarca().equals("teste");
		});

		// Lambda com única variável
		carros.stream().filter(a -> {
			return !a.getMarca().equals("teste");
		});

		// Lambda sem chaves e sem retorno
		carros.stream().filter(a -> !a.getMarca().equals("teste"));
		
		// Não compila - lambda trabalhando com tipo simples
		// carros.stream().filter(carro -> !carro.getId() == 0);
	}

}
