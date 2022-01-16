package exercise02.application;

import exercise02.model.entities.Account;
import exercise02.model.exceptions.DomainException;

import java.util.Scanner;

/**
 * Fazer um programa para ler os dados de uma conta bancária e depois realizar um
 * saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
 * ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
 * saque da conta.
 */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nInforme os dados da conta: ");
        System.out.print("Número da conta: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: R$ ");
        double initialBalance = sc.nextDouble();
        System.out.print("Limite de saque: R$ ");
        double withdrawLimit = sc.nextDouble();
        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        try {
            System.out.print("\nInforme o valor do saque: R$ ");
            double withdraw = sc.nextDouble();
            account.withdraw(withdraw);
        } catch (DomainException e){
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Saldo atual: R$ " + String.format("%.2f", account.getBalance()));

        sc.close();
    }
}
