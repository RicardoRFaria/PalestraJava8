package br.com.ricardo.faria.exemplopratico;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.ricardo.faria.modelos.Carro;

public class ImportacaoArquivo {
	
	private static final String LOCALIZACAO_ARQUIVO = "resource/carros.json";
	private static final Charset CHARSET = Charset.defaultCharset();
	
	public int importarArquivoSemLambda() throws IOException {
		int quantidadeDeLinhas = 0;
		for (String line : Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET)) {
			if (line.isEmpty()) {
				continue;
			}
			System.out.println(line);
			quantidadeDeLinhas ++;
		}
		return quantidadeDeLinhas;
	}
	
	public int importarArquivoComLambda() throws IOException {
		// Isso não funciona
		// final int quantidadeDeLinhas = 0;
		
		// Isso tambem não
		// int quantidadeDeLinhas = 0;
		
		Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET).stream().filter(line -> !line.isEmpty()).forEach(line -> {
			System.out.println(line);
		});
		Long count = Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET).stream().filter(line -> !line.isEmpty()).count();
		return count.intValue();
	}
	
	public List<Carro> getCarros() {
		try {
			String conteudo = Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET).stream().collect(Collectors.joining());
			
			Gson gson = new Gson();
			Type type = new TypeToken<List<Carro>>(){}.getType();
			List<Carro> carros = gson.fromJson(conteudo, type);
			carros.addAll(gson.fromJson(conteudo, type));
			
			int ano = 1990;
			for (int i = 0; i < carros.size(); i ++) {
				if (i % 100 == 0) {
					ano ++;
				}
				carros.get(i).setAno(ano);
			}
			return carros;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		ImportacaoArquivo arquivos = new ImportacaoArquivo();
		int qntLinhasSemLambda = arquivos.importarArquivoSemLambda();
		int qntLinhasComLambda = arquivos.importarArquivoComLambda();
		
		System.out.println("Linhas sem lambda: " + qntLinhasSemLambda);
		System.out.println("Linhas com lambda: " + qntLinhasComLambda);
		System.out.println("Quantidade de objetos: " + arquivos.getCarros().size());
	}

}
