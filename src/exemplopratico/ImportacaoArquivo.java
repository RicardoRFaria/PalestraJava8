package exemplopratico;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImportacaoArquivo {
	
	private static final String LOCALIZACAO_ARQUIVO = "/import.sql";
	private static final Charset CHARSET = Charset.defaultCharset();
	
	public void importarArquivoSemLambida() throws IOException {
		for (String line : Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET)) {
			if (line.isEmpty()) {
				continue;
			}
			// Insere no banco
			System.out.println(line);
		}
	}
	
	public void importarArquivoComLambda() throws IOException {
		Files.readAllLines(Paths.get(LOCALIZACAO_ARQUIVO), CHARSET).stream().filter(line -> !line.isEmpty()).forEach(line -> {
			// Insere no banco
			System.out.println(line);
		});
	}

}
