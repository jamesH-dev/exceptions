package model.exceptions;

public class DomainException extends Exception{
    private final static long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }
}
