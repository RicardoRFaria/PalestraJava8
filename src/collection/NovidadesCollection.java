package collection;

import java.util.List;

import exemplopratico.ImportacaoArquivo;
import modelos.Carro;

public class NovidadesCollection {
	
	private static ImportacaoArquivo importacao;

	static {
		importacao = new ImportacaoArquivo();
	}

	public static void main(String... args) {
		List<Carro> carros = importacao.getCarros();
		
		// Removendo carros com ano = 1995
		carros.removeIf(u -> u.getAno() == 1995);
		
		// Ordenando pelo nome
		carros.sort((c1, c2) -> c1.getNome().compareTo(c2.getNome()));
		
		// Printando todos os carros
		carros.forEach(Carro::toString);
	}

}
