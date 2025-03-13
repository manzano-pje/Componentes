
public class ValidacaoCPF {
    public static void main(String[] args){
        ValidacaoCPF ValidacaoCPF = new ValidacaoCPF();

        String teste = "06326651810"; // cpf para teste
        ValidacaoCPF.obterNumeracaoCPF(teste);

        ValidacaoCPF.obterDiv(ValidacaoCPF.obterSomatorio1(), 9);
        ValidacaoCPF.obterDiv(ValidacaoCPF.obterSomatorio2(), 10);
        Boolean verificacao = ValidacaoCPF.verificarCpf(ValidacaoCPF.numeracao[9], ValidacaoCPF.numeracao[10]);
        //System.out.print("Div: " + ValidacaoCPF.numeracao[9] + ValidacaoCPF.numeracao[10]);

        if (verificacao == true)
            System.out.println(" verdadeiro");
        else
            System.out.println(" falso");
    }

    //*************************************
    private int numeracao[] = new int[11];
    private String digito;
    
    private String obterNumeracaoCPF(String cpfBruto){

        if(cpfBruto == "11111111111" || cpfBruto == "22222222222" || cpfBruto == "33333333333"
                                     || cpfBruto == "44444444444" || cpfBruto == "55555555555"
                                     || cpfBruto == "66666666666" || cpfBruto == "77777777777"
                                     || cpfBruto == "88888888888" || cpfBruto == "99999999999") {
            return "CPF inválido";
        }
        String cpf = cpfBruto.substring(0,9); // 9 digitos cpfbruto
        digito = cpfBruto.substring(9,11); // 2 ultimos digitos cpfbruto
        short contador = 0; // contador = 0

        for(short i = 0; i < cpf.length(); i++){ // enquanto i < cpf (9)
            if(Character.isDigit(cpf.charAt(i))){ // verifica se caractr e numerico
                numeracao[contador++] = Character.digit(cpf.charAt(i), 10); // se sim,adiciona na array numeração
            }
        }
        return cpf;
    }

        //***********************************************
    private int obterSomatorio1(){
        int somatorio = 0;
        int[] multiplicadores = {10, 9, 8, 7, 6, 5, 4, 3, 2};

        for(short i = 0; i < multiplicadores.length; i++){
            somatorio += (numeracao[i] * multiplicadores[i]);
        }
        return somatorio;
    }

        //*****************************************
    private int obterSomatorio2(){
        int somatorio = 0;
        int[] multiplicadores = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        for(short i = 0; i < multiplicadores.length; i++){
            somatorio += (numeracao[i] * multiplicadores[i]);
        }

        return somatorio;
    }

        //*****************************************
    private void obterDiv(int soma, int t){
        int modulo;
        int resto;
        modulo = soma % 11;
        resto = 11 - modulo;
        if(resto > 9){
            if(t == 9)
                numeracao[9] = 0;
            else if(t == 10)
                numeracao[10] = 0;
        }else{
            if(t == 9)
                numeracao[9] = resto;
            else if(t == 10)
                numeracao[10] = resto;
        }
    }

        //********************************************
    private boolean verificarCpf(int dv1,  int dv2){
        String verificador = Integer.toString(dv1) + Integer.toString(dv2);
        boolean retorno;

        System.out.println("Digito para verificação do CPF: " + digito);
        System.out.println("Verificador " + verificador);

        if (verificador.equals(digito))
            retorno = true;
        else
            retorno = false;
        return retorno;
    }
}