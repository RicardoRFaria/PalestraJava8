package lambdas;

import java.util.Calendar;
import java.util.List;

import exemplopratico.ImportacaoArquivo;
import modelos.Carro;
import modelos.CarrosIdadeProcessor;

public class CalculadoraIdadeCarro {
	
	private static ImportacaoArquivo importacao;

	static {
		importacao = new ImportacaoArquivo();
	}

	public static void main(String... args) {
		List<Carro> carros = importacao.getCarros();
		processarCarros(carros, carro -> {
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			carro.setIdade(year - carro.getAno());
		});
		
		carros.forEach(c -> System.out.println("Modelo do carro: " + c.getNome() + ", idade: " + c.getIdade()));
		
		System.out.println("Quantidade de idades: " + carros.stream().mapToInt(c -> c.getIdade()).distinct().count());
		System.out.println("Idade m�nima: " + carros.stream().mapToInt(c -> c.getIdade()).min().getAsInt());
		System.out.println("Idade m�xima: " + carros.stream().mapToInt(c -> c.getIdade()).max().getAsInt());
		System.out.println("Idade m�dia: " + carros.stream().mapToInt(c -> c.getIdade()).average().getAsDouble());
	}
	
	public static void processarCarros(List<Carro> carros, CarrosIdadeProcessor processador) {
		processador.calcularIdades(carros);
	}
	
}
