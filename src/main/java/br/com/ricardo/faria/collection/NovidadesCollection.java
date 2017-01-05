package br.com.ricardo.faria.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.com.ricardo.faria.exemplopratico.ImportacaoArquivo;
import br.com.ricardo.faria.modelos.Carro;

public class NovidadesCollection {

    private static ImportacaoArquivo importacao;

    static {
        importacao = new ImportacaoArquivo();
    }

    // Total de 4 Linhas para a operação
    public static void main(String... args) {
        List<Carro> carros = importacao.getCarros();

        // Removendo carros com ano = 1995
        carros.removeIf(u -> u.getAno() == 1995);

        // Ordenando pelo nome
        carros.sort((c1, c2) -> c1.getNome().compareTo(c2.getNome()));
        carros.sort(Comparator.comparing(Carro::getNome));

        // Printando todos os carros
        carros.forEach(System.out::println);
    }

    // Total de 16 Linhas para a opera??o
    public static void mainNoModoAntigo() {
        List<Carro> carros = importacao.getCarros();

        // Removendo carros com ano = 1995
        Iterator<Carro> carrosIt = carros.iterator();
        while (carrosIt.hasNext()) {
            Carro carro = carrosIt.next();
            if (carro.getAno() == 1995) {
                carrosIt.remove();
            }
        }

        // Ordenando pelo nome
        Collections.sort(carros, new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        // Printando todos os carros
        for (Carro carro : carros) {
            System.out.println(carro);
        }
    }

}
