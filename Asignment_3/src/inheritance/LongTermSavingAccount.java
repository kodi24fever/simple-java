package inheritance;

public class LongTermSavingAccount extends SavingsAccount{
  public LongTermSavingAccount(double balance, double interestRate){
    super(balance, interestRate);
    System.out.println("Long Term Account");
  }
}