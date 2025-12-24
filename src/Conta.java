public class Conta {
    private double saldo = 0.0;
    private double chequeEspecial = 0.0;

    public double getSaldo(){
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public ResponseDeposito depositar(double valor){
        if(valor <= 0){
            return ResponseDeposito.VALOR_INCORRETO;
        }

        if(valor <= 500.00) {
            saldo += valor;
            chequeEspecial = 50.00;
            return ResponseDeposito.SUCESSO;
        } else {
            saldo += valor;
            chequeEspecial += (saldo / 2);
            return ResponseDeposito.SUCESSO;
        }
    }

    public enum ResponseDeposito {
        SUCESSO,
        VALOR_INCORRETO,
        SALDO_INSUFICIENTE
    }



}
