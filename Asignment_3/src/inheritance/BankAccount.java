package inheritance;

public class BankAccount{
  private double balance;
  public double getBalance(){
    return balance;
  }
  public void deposit(double value){
    balance = balance + value;
  }
  public void withdraw(double value){
    balance = balance - value;
  }
  public BankAccount(double balance){
    System.out.println("BankAccount");
    this.balance = balance;
  }
}