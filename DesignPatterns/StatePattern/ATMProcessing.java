public class ATMProcessing{
    public static void main(String[] args){
      ATMMachine atm = new ATMMachine();
      atm.insertCard();
      atm.ejectCard();
      atm.insertCard();
      atm.insertpin(1234);
      atm.requestCash(2000);
      atm.insertCard();
    }
}
interface State{
    void insertCard();
    void ejectCard();
    void insertPin(int pin);
    void requestCash(int cash);
}
class HasCard implements State{
    ATMMachine atm;
    public HasCard(ATMMachine newatm){
        this.atm = newatm;
    }

    public void insertCard(){
        System.out.println("The card has already been inserted, you can not insert more than one card");
    }
    public void ejectCard(){
        System.out.println("The card has been ejected");
        atm.setATMState(atm.getNoCardState());
    }
    public void insertPin(int pin){
        if(pin == 1234){
            System.out.println("CORRECT PIN");
            atm.correctpin= true;
            atm.setATMState(atm.getHasPin());
        }
        else{
            System.out.println("WRONG PIN");
            atm.correctpin= false;
            System.out.println("Card ejected");
            atm.setATMState(atm.getNoCardState());        }
    }
    public void requestCash(int cash){
        System.out.println("Are you sure you want to request the amount "+ cash);

    }

}
class NoCard implements State{
    ATMMachine atm;
    public NoCard(ATMMachine newatm){
        this.atm = newatm;
    }

    public void insertCard(){
        System.out.println("Enter pin");
        atm.setATMState(atm.getYesCardState());
    }
    public void ejectCard(){
        System.out.println("There is no card inserted in the machine");
        
    }
    public void insertPin(int pin){
            System.out.println("Enter a card first");
            
       
    }
    public void requestCash(int cash){
        System.out.println("Enter a card first");

    }

}
class HasCorrectPin implements State{
    ATMMachine atm;
    public HasCorrectPin(ATMMachine newatm){
        this.atm = newatm;
    }
    public void insertCard(){
        System.out.println("The card has already been inserted, you can not insert more than one card");
    }
    public void ejectCard(){
        System.out.println("The card has been ejected");
        atm.setATMState(atm.getNoCardState());
    }
    public void insertPin(int pin){
            System.out.println("Already entered");
            
       
    }
    public void requestCash(int cash){
      if(cash> atm.cashinmachine){
        System.out.println("Dont have enough cash");
        System.out.println("The card has been ejected");
        atm.setATMState(atm.getNoCardState()); 
      }
      else{
        System.out.println(cash + " is provided by the machine");
        atm.setCashinMachine(atm.cashinmachine - cash);
        System.out.println("The card has been ejected");
        atm.setATMState(atm.getNoCardState()); 

        if(atm.cashinmachine <= 0){
            atm.setATMState(atm.getNoCashState());
        }
      }

    }

}
class OutofMoney implements State{
    ATMMachine atm;
    public OutofMoney(ATMMachine newatm){
        this.atm = newatm;
    }

    public void insertCard(){
        System.out.println("No Money in the ATM Machine");
        
    }
    public void ejectCard(){
           System.out.println("No Money in the ATM Machine, No card entered");
        
    }
    public void insertPin(int pin){
        System.out.println("No Money in the ATM Machine");
    }
    public void requestCash(int cash){
         System.out.println("No Money in the ATM Machine");

    }

}
class ATMMachine{
    State hasCard;
    State noCard;
    State hasCorrectPin;
    State outofMoney;

    State atmState;

    int cashinmachine = 200000;
    boolean correctpin = false;

    public ATMMachine(){
        hasCard = new HasCard(this);
        hasCorrectPin = new HasCorrectPin(this);
        noCard = new NoCard(this);
        outofMoney = new OutofMoney(this);

        atmState = noCard;

        if(cashinmachine<0){
            atmState = outofMoney;
        }
    }

    void setATMState( State newstate){
        atmState = newstate;
    }
    State getState(){
        return atmState;
    }
    public void setCashinMachine(int newcash){
        cashinmachine = newcash;
    }
    public void insertCard(){
        atmState.insertCard();
    }
    public void ejectCard(){
        atmState.ejectCard();
    }
    public void requestCash(int newrequest){
        atmState.requestCash(newrequest);
    }
    public void insertpin(int newpin){
        atmState.requestCash(newpin);
    }
    public State getYesCardState(){
        return hasCard;
    }
    public State getNoCardState(){
        return noCard;
    }
    public State getHasPin(){
        return hasCorrectPin;
    }
    public State getNoCashState(){
        return outofMoney;
    }

}