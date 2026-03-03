package game.engine.exceptions;

public class OutOfEnergyException {

    static final String MSG = "Not Enough Energy for Power Up";
public class OutOfEnergyException extends GameActionException{
    public static final String MSG = "Not Enough Energy for Power Up";
    
    OutOfEnergyException(){
    public OutOfEnergyException(){
        super(MSG);
    }
    
    OutOfEnergyException(String message){
    public OutOfEnergyException(String message){
         super(message);
    }
}}
}
