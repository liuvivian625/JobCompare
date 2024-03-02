package edu.gatech.seclass.jobcompare6300;

public class NoJobException extends RuntimeException{

    public NoJobException(String message) {
        super(message);
    }

    public NoJobException() {
        super();
    }
}
