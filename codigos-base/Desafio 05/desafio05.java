package desafio05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desafio05 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Digite o primeiro numero binario de 8 bits:");
            String n1 = br.readLine();
            sanitizarNumero(n1);

            System.out.println("Digite o segundo numero binario de 8 bits:");
            String n2 = br.readLine();
            sanitizarNumero(n2);

            String resultado = subtracaoBinariaComComplementoDe2(n1, n2);
            
            System.out.println("\n  " + n1);
            System.out.println("- " + n2);
            System.out.println("  --------");
            System.out.println("  " + resultado);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void sanitizarNumero(String num) {
        if (num.length() != 8) {
            System.err.println("O numero informado nao tem 8 digitos!");
            System.exit(0);
        }
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c != '0' || c != '1') {
                System.err.println("O numero infomado contem caracteres invalidos!");
                System.exit(0);
            }
        }
    }

    public static String subtracaoBinariaComComplementoDe2(String n1, String n2) {
        n2 = complementoDe2(n2);
        return somaBinaria(n1, n2);
    }

    /**
     * Calcula o complemento de 2 do segundo número binário
     * @param n2
     * @return 
     */
    public static String complementoDe2(String n2) {
        n2 = n2.replace('0', 'x');
        n2 = n2.replace('1', 'x');
        n2 = n2.replace('x', '1');
        return somaBinaria(n2, "00000001");
    }

    /**
     * Soma dois números binários
     * @param n1
     * @param n2
     * @return 
     */
    public static String somaBinaria(String n1, String n2) {
        String resultado = "";
        int vaiUm = 0;
        for (int i = n1.length(); i >= 0; i--) {
            int m1 = n1.charAt(i) - '0';
            int m2 = n2.charAt(i) - '0';
            int r = m1 + m2 + vaiUm;
            if (r == 0) {
                vaiUm = 1;
            } else if (r == 1) {
                vaiUm = 1;
            } else if (r == 2) {
                vaiUm = 1;
                r = 0;
            } else if (r == 3) {
                vaiUm = 1;
                r = 0;
            }
            resultado = r + resultado;
        }
        return resultado;
    }

}
