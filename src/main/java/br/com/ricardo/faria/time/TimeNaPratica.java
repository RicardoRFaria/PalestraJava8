package br.com.ricardo.faria.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeNaPratica {

	public static void main(String... args) throws InterruptedException {
		criacaoDeTempoEmDataEspecifica();
		analisandoDuracaoDeTempo();
		manipulandoTempo();
	}

	private static void criacaoDeTempoEmDataEspecifica() {
		System.out.println("\n === Criação de tempo em data especifica ===");

		// Antes
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, Calendar.FEBRUARY, 1);
		Date data = calendar.getTime();
		System.out.println("Tempo gerado pela api antiga [O tempo foi adicionado sem permissão]: " + data);

		// Depois
		LocalDate novaData = LocalDate.of(2015, Month.FEBRUARY, 1);
		System.out.println("Tempo gerado pela api nova [Como o objeto � de date, tempo não foi incluído]: "
				+ novaData.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}

	private static void analisandoDuracaoDeTempo() throws InterruptedException {
		System.out.println("\n === Analisando duração do tempo ===");

		// Antes
		long inicioAntigo = System.currentTimeMillis();
		Thread.sleep(50);
		long fimAntigo = System.currentTimeMillis();
		long duracaoEmMsAntiga = fimAntigo - inicioAntigo;
		System.out.println("Duração antiga em ms: " + duracaoEmMsAntiga);

		// Nova
		Instant inicioNovo = Instant.now();
		Thread.sleep(50);
		Instant fimNovo = Instant.now();

		Duration duracao = Duration.between(inicioNovo, fimNovo);
		System.out.println("Duração nova em ms: " + duracao.toMillis());
		System.out.println("Duração nova em nano: " + duracao.getNano());
	}

	@SuppressWarnings("deprecation")
	private static void manipulandoTempo() {
		// Antes (Java 1.0)
		Date data = new Date();
		data.setDate(data.getDate() + 2);
		data.setMonth(data.getMonth() - 1);

		// Antes (Java 1.1)
		Calendar calendarioAgora = Calendar.getInstance();
		calendarioAgora.add(Calendar.DAY_OF_MONTH, 2);
		calendarioAgora.add(Calendar.MONTH, -1);

		// Agora Java 8
		LocalDate diaHoje = LocalDate.now();
		diaHoje = diaHoje.plusDays(2);
		diaHoje = diaHoje.minusMonths(1);

	}

}
