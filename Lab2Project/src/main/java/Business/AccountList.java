package Business;


import Business.Account;
import java.util.ArrayList;


/**
 *  Jason Rodriguez
 *  Lab #5
 *  Aug 25, 2022
 *  CIST 2373
 *  I promise I wrote this code
 */ 
public class AccountList {
    public ArrayList<Account> accArr = new ArrayList<>();
    private int count;
    
    public void addAccount(Account a1) {
        accArr.add(a1);
        
    }
    public int getCount() {
        return accArr.size();
    }
    public void displayList() {
        for (int i = 0; i < accArr.size(); i++) {
            accArr.get(i).display();
            System.out.println("");
            
        }
        
    }
}
