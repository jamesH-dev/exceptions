package exercise01.application;

import exercise01.model.entities.Reservation;
import exercise01.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
 * de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
 * dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
 * novamente a reserva com os dados atualizados. O programa não deve aceitar dados
 * inválidos para a reserva, conforme as seguintes regras:
 * - Alterações de reserva só podem ocorrer para datas futuras
 * - A data de saída deve ser maior que a data de entrada
 */

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("\nNúmero do Quarto: ");
            int roomNumber = sc.nextInt();
            System.out.print("(DD/MM/AAAA) Data do Check-in: ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("(DD/MM/AAAA) Data do Check-out: ");
            Date checkout = sdf.parse(sc.next());
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nAtualização da Reserva");
            System.out.print("(DD/MM/AAAA) Data do Check-in: ");
            checkin = sdf.parse(sc.next());
            System.out.print("(DD/MM/AAAA) Data do Check-out: ");
            checkout = sdf.parse(sc.next());
            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);

        } catch (ParseException e){
            System.out.println("Formato da data informada é inválido!");
        } catch (DomainException e){
            System.out.println("Erro: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Erro inesperado! Contate o administrador do sistema");
        }
        sc.close();
    }
}
