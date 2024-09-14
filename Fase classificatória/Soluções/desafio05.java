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
            System.exit(1);
        }
        if (!num.matches("[01]+")) {
            System.err.println("O numero informado nao e binario!");
            System.exit(1);
        }
    }

    public static String subtracaoBinariaComComplementoDe2(String n1, String n2) {

        String complementoDe2 = calcularComplementoDe2(n2);


        String resultado = somarBinarios(n1, complementoDe2);


        return resultado.substring(resultado.length() - 8);
    }

    public static String calcularComplementoDe2(String binario) {
        StringBuilder complemento = new StringBuilder();


        for (char bit : binario.toCharArray()) {
            complemento.append(bit == '0' ? '1' : '0');
        }


        return somarBinarios(complemento.toString(), "00000001");
    }

    public static String somarBinarios(String a, String b) {
        StringBuilder resultado = new StringBuilder();
        int carry = 0;


        for (int i = 7; i >= 0; i--) {
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';
            int soma = bitA + bitB + carry;

            resultado.append(soma % 2);
            carry = soma / 2;
        }


        if (carry != 0) {
            resultado.append(carry);
        }

        return resultado.reverse().toString();
    }
}