package br.com.ricardo.faria.lambdas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.ricardo.faria.exemplopratico.ImportacaoArquivo;
import br.com.ricardo.faria.modelos.Carro;

public class CollectorsNaPratica {

	private static final int IDADE_QUE_CARRO_PAGA_IPVA = 1996;
	private static ImportacaoArquivo importacao;

	static {
		importacao = new ImportacaoArquivo();
	}

	public static void main(String[] args) {
		List<Carro> carros = importacao.getCarros();

		System.out.println(" === Agrupado por marcas === ");
		Map<String, List<Carro>> agrupadoPorMarcas = carros.stream().collect(Collectors.groupingBy(Carro::getMarca));
		System.out.println(agrupadoPorMarcas);

		System.out.println(" === Agrupado por marcas e com valor como soma de anos === ");
		Map<String, Integer> agrupadoPorMarcasEComSomaDeAnos = carros.stream()
				.collect(Collectors.groupingBy(Carro::getMarca, Collectors.summingInt(Carro::getAno)));
		System.out.println(agrupadoPorMarcasEComSomaDeAnos);

		System.out.println(" === Agrupado por marcas e com valor como média de anos === ");
		Map<String, Double> agrupadoPorMarcasEComMediaDeAnos = carros.stream()
				.collect(Collectors.groupingBy(Carro::getMarca, Collectors.averagingInt(Carro::getAno)));
		System.out.println(agrupadoPorMarcasEComMediaDeAnos);

		System.out.println(" === Quantidade de carros que pagam ou não IPVA === ");
		Map<Boolean, Long> carrosQuePagamOuNaoIPVA = carros.stream()
				.collect(Collectors.partitioningBy(carro -> carro.getAno() > IDADE_QUE_CARRO_PAGA_IPVA, Collectors.counting()));
		System.out.println(carrosQuePagamOuNaoIPVA);

	}

}
