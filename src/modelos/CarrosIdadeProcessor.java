package modelos;

import java.util.Collection;

@FunctionalInterface
public interface CarrosIdadeProcessor {
	
	void processar(Carro carro);
	
	default void calcularIdades(Collection<Carro> carros) {
		carros.forEach(c -> processar(c));
	}

}
