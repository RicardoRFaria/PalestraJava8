package modelos;

import java.util.Calendar;
import java.util.Collection;

@FunctionalInterface
public interface CarroProcessor {
	
	void processar(Carro carro);
	
	default void calcularIdade(Carro carro) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		carro.setIdade(year - carro.getIdade());
	}
	
	default void calcularIdades(Collection<Carro> carros) {
		carros.forEach(c -> calcularIdade(c));
	}

}
