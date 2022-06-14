package inheritance;

public class SavingsAccount extends BankAccount{
  private double interestRate;
  //private double balance;//shadow variable
  public SavingsAccount(double balance, double interestRate){
    super(balance);//calls the parent's constructor...
    //super.balance = balance;
    this.interestRate = interestRate;
    System.out.println("SavingsAccount");
  }
  public void addInterest(){
    double interest = getBalance() * interestRate / 100;
    deposit(interest);
  }
}