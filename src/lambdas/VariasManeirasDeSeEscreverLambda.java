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
			public boolean test(Carro c) {
				return !c.getMarca().equals("teste");
			}
		}).count();
		System.out.println("Classe anônima, tamanho: " + tamanho);

		// Implementação através de lambda
		Predicate<Carro> predicateInstanciadoComLambda = (Carro c) -> {
			return !c.getMarca().equals("teste");
		};
		tamanho = carros.stream().filter(predicateInstanciadoComLambda).count();
		System.out.println("Interface implementada através de lambda, tamanho: " + tamanho);

		// Lambda completa
		tamanho = carros.stream().filter((Carro carro) -> {
			return !carro.getMarca().equals("teste");
		}).count();
		System.out.println("Lambda completa: " + tamanho);

		// Lambda com tipo omitido
		tamanho = carros.stream().filter((carro) -> {
			return !carro.getMarca().equals("teste");
		}).count();
		System.out.println("Lambda com tipo otimido: " + tamanho);

		// Lambda com única variável
		tamanho = carros.stream().filter(a -> {
			return !a.getMarca().equals("teste");
		}).count();
		System.out.println("Lambda com tipo otimido e com nome sem relação (má prática): " + tamanho);

		// Lambda sem chaves e sem retorno
		tamanho = carros.stream().filter(a -> !a.getMarca().equals("teste")).count();
		System.out.println("Lambda sem chaves e sem retorno: " + tamanho);

		// Lambda trabalhando com tipo simples
		carros.stream().filter(carro -> !(carro.getId() == 0));
	}

}
