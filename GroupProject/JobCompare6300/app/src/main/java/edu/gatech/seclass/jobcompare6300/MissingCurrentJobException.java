package edu.gatech.seclass.jobcompare6300;

public class MissingCurrentJobException extends RuntimeException{

    public MissingCurrentJobException(String message) {
        super(message);
    }

    public MissingCurrentJobException() {
        super();
    }
}
