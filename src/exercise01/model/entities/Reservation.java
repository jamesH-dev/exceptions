package exercise01.model.entities;

import exercise01.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static Date now = new Date();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final String ERR_FUTURE_CHECKOUT = "O check-out deverá ocorrer somente após o check-in";
    private static final String ERR_FUTURE_DATE = "A atualização de reserva somente poderá ocorrer com datas futuras";

    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException{
        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainException(ERR_FUTURE_DATE);
        }
        if (checkin.after(checkout)){
            throw new DomainException(ERR_FUTURE_CHECKOUT);
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) throws DomainException {

        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainException(ERR_FUTURE_DATE);
        }
        if (checkin.after(checkout)){
            throw new DomainException(ERR_FUTURE_CHECKOUT);
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Quarto " + roomNumber
                + ", check-in: " + sdf.format(checkin)
                + ", check-out: " + sdf.format(checkout)
                + ", " + duration() + " dias";
    }
}
