import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);


    private Conta conta = new Conta();

    public static void main(String[] args){
        Main app = new Main();
        app.executar();
    }

    public void executar() {

        int option = 0;

        do {
            System.out.println("\n\n------ MENU ------");
            System.out.println("1: Consultar saldo");
            System.out.println("2: Consultar cheque especial");
            System.out.println("3: Depositar");

            System.out.print("Digite a opção que deseja: ");
            option = scanner.nextInt();

            switch(option){
                case 1 -> System.out.println("\nSaldo R$" + consultaSaldo());
                case 2 -> System.out.println("\nCheque especial R$" + consultarChequeEspecial());
                case 3 -> depositar();
            }
        } while (option != 0);

    }

    public double consultaSaldo(){
        return conta.getSaldo();
    }

    public double consultarChequeEspecial() {
        return conta.getChequeEspecial();
    }

    public void depositar(){
        System.out.print("\nValor: R$ ");
        double valor = scanner.nextDouble();
        Conta.ResponseDeposito response = conta.depositar(valor);

        if(response == Conta.ResponseDeposito.VALOR_INCORRETO) {
            System.out.println("Valor informado está incorreto");
        } else {
            System.out.println("Depósito realizado com sucesso!");
            System.out.print("Saldo atual: " + conta.getSaldo());

        }

    }

}
