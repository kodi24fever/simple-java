package inheritance;

class Main {
  public static void main(String[] args) {
    BankAccount myGenericAccount = new BankAccount(1000.0);
    CheckingAccount myCheckings = new CheckingAccount(200.0);
    BankAccount mySavings = new SavingsAccount(2000.0, 12.0);
    System.out.println(myGenericAccount.getBalance());
    System.out.println(myCheckings.getBalance());
    System.out.println(mySavings.getBalance());

  for(int i = 0; i < 110;i++)
    myCheckings.deposit(1.0);
    
    myCheckings.deductFees();
    System.out.println("After deducting fees, the balance of my checking is " + myCheckings.getBalance());
    LongTermSavingAccount l = new LongTermSavingAccount(100,10);
  }
}