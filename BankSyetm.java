import java.util.ArrayList;

class BankAccount {
    private String accholder;
    String accnumber;
    private double balance;
    BankAccount(String accholder,String accnumber,double balance)
    {
        this.accholder=accholder;
        this.accnumber=accnumber;
        this.balance=balance;
    }
    public void getDetails()
    {
        System.out.println("Account Holder : " + accholder);
        System.out.println("Account Number : " + accnumber);
        System.out.println("Balance : " + balance);
    }
    public void setBalance(String action,double amount)
    {
        if(action.equalsIgnoreCase("credit"))
           { this.balance+=amount;
            System.out.println("Current Balance : " + balance);
           }

        else if(this.balance >= amount && action.equalsIgnoreCase("debit"))
           { this.balance-=amount;
        System.out.println("Current Balance : " + balance);
           }
           else 
            System.out.println("Insufficient Balance ");
    }

}
class Customer
{ 
    ArrayList<BankAccount> account = new ArrayList<BankAccount>();
    public static void main(String[] args) {
        Customer c = new Customer();
        c.addAccount(new BankAccount("Sonam Kapoor", "YCYC0023", 25000));
        c.addAccount(new BankAccount("Anil kapoor", "YCYC0045",50000));
        c.showDetails();
        c.withdraw("YCYC0023",10000);
        c.deposit("YCYC0045",5000);
    }
    public void addAccount(BankAccount b)
    {
        account.add(b);
    }
    public void showDetails()
    {
        for(BankAccount b : account)
            b.getDetails();
    }
    public void withdraw(String accnum,double amount)
    { for(BankAccount b : account)
    {
        if(b.accnumber.equals(accnum))
      {  b.setBalance("debit",amount);
        return;}
    }
       
    }
    public void deposit(String accnum,double amount)
    { for(BankAccount b : account)
    {
        if(b.accnumber.equals(accnum))
      {  b.setBalance("credit",amount);
        return;}
    }
       
    }
}
