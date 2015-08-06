package lambdas;

import java.util.List;

import exemplopratico.ImportacaoArquivo;
import modelos.Carro;

public class VariasManeirasDeSeEscreverLambda {

	private static ImportacaoArquivo importacao;
	
	static {
		importacao = new ImportacaoArquivo();
	}
	
	public static void main(String[] args) {
		List<Carro> carros = importacao.getCarros(); 
	}

}
