package game.engine.exceptions;

public class OutOfEnergyException {

    static final String MSG = "Not Enough Energy for Power Up";
    
    OutOfEnergyException(){
        super(MSG);
    }
    
    OutOfEnergyException(String message){
         super(message);
    }
}