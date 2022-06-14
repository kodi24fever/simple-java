package question_2;
import java.util.*;
class CheckingAccount extends BankAccount{
    private double withdrawFee;
    private double depositFee;
    CheckingAccount(double withdrawFee, double depositFee){
        this.withdrawFee = withdrawFee;
        this.depositFee = depositFee;
    }
    @Override
    public void withdraw (double value){
        balance -= (value + withdrawFee);
    }
    @Override
    public void deposit (double value){
        balance += (value - depositFee);
    }
    @Override
    public String toString(){
        return "CheckingAccount with balance " + balance +
                " and withdraw fee " + withdrawFee + " and deposit fee " + depositFee;
    }
}
class BankAccount{
    protected double balance;
    BankAccount(){
        balance = 0;
    }
    public void withdraw (double value){
        balance -= value;
    }
    public void deposit (double value){
        balance += value;
    }
    @Override
    public String toString(){
        return "Generic Account with balance " + balance;
    }
}
public class Main{
    public static void main(String[] args){
        ArrayList<BankAccount> list = new ArrayList<BankAccount>();
        list.add(new BankAccount());
        list.add(new CheckingAccount(10, 15));
        list.get(0).deposit(100);
        list.get(1).deposit(200);
        list.get(0).withdraw(20);
        list.get(1).withdraw(40);
        for(BankAccount account: list)
            System.out.println(account);
    }
}
