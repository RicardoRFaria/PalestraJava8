package br.com.ricardo.faria.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ricardo.faria.exemplopratico.ImportacaoArquivo;
import br.com.ricardo.faria.modelos.Carro;

public class NovidadesMap {
	
	private static final String MARCA_INEXISTENTE = "MarcaInexistente";
	private static ImportacaoArquivo importacao;

	static {
		importacao = new ImportacaoArquivo();
	}

	// Total de linhas para a operação - 6
	public static void main(String... args) {
		List<Carro> carros = importacao.getCarros();
		
		// Preenchendo mapa
		Map<String, List<Carro>> carrosPorMarca = new HashMap<>();
		carros.forEach(carro -> carrosPorMarca.computeIfAbsent(carro.getMarca(), elemento -> new ArrayList<>()).add(carro));
		System.out.println(carros);
		
		// Retorno caso não exista
		carrosPorMarca.getOrDefault(MARCA_INEXISTENTE, new ArrayList<>());
		
		// Remova item se chave e valor forem iguais a
		carrosPorMarca.remove(MARCA_INEXISTENTE, new ArrayList<>());
	}
	
	// Total de linhas para a operação - 16
	public static void mainNoModoAntigo() {
		List<Carro> carros = importacao.getCarros();
		
		// Preenchendo mapa
		Map<String, List<Carro>> carrosPorMarca = new HashMap<>();
		for (Carro carro : carros) {
			if (!carrosPorMarca.containsKey(carro.getMarca())) {
				carrosPorMarca.put(carro.getMarca(), new ArrayList<Carro>());
			}
			carrosPorMarca.get(carro.getMarca()).add(carro);
		}
		
		// Retorno caso não exista
		if (carrosPorMarca.containsKey(MARCA_INEXISTENTE)) {
			carrosPorMarca.get(MARCA_INEXISTENTE);
		} else {
			new ArrayList<Carro>();
		}
		
		// Remova item se chave e valor forem iguais a
		if (carrosPorMarca.containsKey(MARCA_INEXISTENTE) && carrosPorMarca.get(MARCA_INEXISTENTE).equals(new ArrayList<Carro>())) {
			carrosPorMarca.remove(MARCA_INEXISTENTE);
		}
	}

}
