package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
