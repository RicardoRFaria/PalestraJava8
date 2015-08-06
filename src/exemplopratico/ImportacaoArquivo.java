package exemplopratico;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.Carro;

public class ImportacaoArquivo {
	
	private static final String LOCALIZACAO_ARQUIVO = "resource/carros.json";
	private static final Charset CHARSET = Charset.defaultCharset();
	
	public long importarArquivoSemLambda() throws IOException {
		long tempoInicio = System.currentTimeMillis();
		for (String line : Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET)) {
			if (line.isEmpty()) {
				continue;
			}
			System.out.println(line);
		}
		long tempoFim = System.currentTimeMillis();
		return tempoFim - tempoInicio;
	}
	
	public long importarArquivoComLambda() throws IOException {
		long tempoInicio = System.currentTimeMillis();
		Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET).stream().filter(line -> !line.isEmpty()).forEach(line -> {
			System.out.println(line);
		});
		long tempoFim = System.currentTimeMillis();
		return tempoFim - tempoInicio;
	}
	
	public List<Carro> getCarros() {
		try {
			String conteudo = Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET).stream().map(e -> e.toString()).reduce("", String::concat);
			
			Gson gson = new Gson();
			Type type = new TypeToken<List<Carro>>(){}.getType();
			return gson.fromJson(conteudo, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		ImportacaoArquivo arquivos = new ImportacaoArquivo();
		long duracaoSemLambda = arquivos.importarArquivoSemLambda();
		long duracaoComLambda = arquivos.importarArquivoComLambda();
		
		System.out.println("Leitura sem lambda: " + duracaoSemLambda + "ms");
		System.out.println("Leitura com lambda: " + duracaoComLambda + "ms");
		System.out.println("Quantidade de objetos: " + arquivos.getCarros().size());
	}

}
