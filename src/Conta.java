public class Conta {
    private double saldo = 0.0;
    private double chequeEspecial = 0.0;
    private double limite = 0.0;

    public double getSaldo(){
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getLimite(){
        limite = saldo + chequeEspecial;
        return limite;
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

    public ResponseDeposito sacarDinheiro(double valor) {
        if(valor <= 0) {
            return ResponseDeposito.VALOR_INCORRETO;
        } else if(valor > saldo) {
            return ResponseDeposito.SALDO_INSUFICIENTE;
        } else {
            saldo -= valor;
            return ResponseDeposito.SUCESSO;
        }
    }


    public enum ResponseDeposito {
        SUCESSO,
        VALOR_INCORRETO,
        SALDO_INSUFICIENTE
    }



}
