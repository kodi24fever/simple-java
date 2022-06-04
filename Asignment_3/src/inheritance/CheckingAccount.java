package inheritance;

public class CheckingAccount extends BankAccount{
  public static final double TRANSACTION_FEE = 3.5;
  public static final int FREE_TRANSACTIONS = 100;
  private int numberOfTrasactions;
  public CheckingAccount(double balance){
    super(balance);
    numberOfTrasactions = 0;
  }
  @Override
  public void deposit(double value){
    numberOfTrasactions++;
    super.deposit(value);//balance += value;
  }
  @Override
  public void withdraw(double value){
    numberOfTrasactions++;
    super.withdraw(value);
  }
  public void deductFees(){
    if(numberOfTrasactions > FREE_TRANSACTIONS){
      double fee = TRANSACTION_FEE * (numberOfTrasactions - FREE_TRANSACTIONS);
      super.withdraw(fee);
    }
  }
}