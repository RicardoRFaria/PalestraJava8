package br.com.ricardo.faria.featuresmenores;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class StringJoin {

    private static final String DELIMITER_TRACO = " - ";
    private static final String DELIMITER_VIRGULA = ", ";

    // Execução com 5 linhas
    public static void main(String... args) {
        StringJoiner joiner = new StringJoiner(DELIMITER_VIRGULA);
        joiner.add("01").add("02").add("03");

        System.out.println("Resultado do join: " + joiner.toString());


        String joinedString = String.join(DELIMITER_TRACO, "04", "05", "06");
        System.out.println("Resultado da string criada com join: " + joinedString);

        mainNoModoAntigo();
    }

    // Execução com 15 linhas
    public static void mainNoModoAntigo(String... args) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = Arrays.asList("01", "02", "03").iterator();
        while (iterator.hasNext()) {
            String numero = iterator.next();
            sb.append(numero);
            if (iterator.hasNext()) sb.append(DELIMITER_VIRGULA);
        }
        System.out.println("Resultado do join antigo: " + sb.toString());

        sb = new StringBuilder();
        iterator = Arrays.asList("04", "05", "06").iterator();
        while (iterator.hasNext()) {
            String numero = iterator.next();
            sb.append(numero);
            if (iterator.hasNext()) sb.append(DELIMITER_TRACO);
        }
        System.out.println("Resultado do segundo join antigo: " + sb.toString());
    }

}
