package Business;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *  Jason Rodriguez
 *  Lab #4 
 *  Aug 23, 2022
 *  I promise I wrote this code
 */
public class Account {
    private int accountNumber;
    private int customerId;
    private String type;
    private double balance;

    public Account(int accountNumber, int customerId, String type, double balance) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
    }

    public Account() {
        accountNumber = 0;
        customerId = 0;
        type = "";
        balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // Inserting into database a record with arguments provided
    public void insertDB(int actNo, int cid, String type, double balance) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "insert into Accounts VALUES (" + actNo + ", " + cid + ", " + "'" +
                    type + "', " + balance + ");";
            
           stmt.executeUpdate(sqlQuery);
           con.close();
            
        } catch (Exception e) {
        }
    }
    // Selecting from database the record that matches the argument actNo
    public void selectDB(int actNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Accounts where AcctNo = " + actNo;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            accountNumber = Integer.parseInt(rs.getString(1));
            customerId = Integer.parseInt(rs.getString(2));
            type = rs.getString(3);
            balance = Double.parseDouble(rs.getString(4));
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    // Deletes current account from database
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "Delete from Accounts where AcctNo = " + getAccountNumber() + ";";
            
           stmt.executeUpdate(sqlQuery);
           con.close();
            
        } catch (Exception e) {
        }
        
    }
    // Displaying one account objects properties
    public void display() {
        System.out.println("Account Number      = " + accountNumber);
        System.out.println("Customer Id         = " + customerId);
        System.out.println("Type                = " + type);
        System.out.println("Balance             = " + balance);
    }

    // below method used to see the database because i cannot view it on my computer.
    public void showAllRecords() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "select * from Accounts;";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            System.out.print("\t" + "AcctNo");
            System.out.print("\t" + "Cid");
            System.out.print("\t" + "Type");
            System.out.print("\t" + "Balance");
            System.out.println("");
            while (rs.next()) {
                System.out.println();
                System.out.print("\t" + rs.getString(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t" + rs.getString(3));
                System.out.print("\t" + rs.getString(4));
            }
            System.out.println("");
            con.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.selectDB(90000);
        a1.display();
        a1.showAllRecords();
        a1.insertDB(90030, 3033, "CHK", 500.25);
        a1.showAllRecords();
        
        Account a2 = new Account();
        a2.selectDB(90030);
        a2.deleteDB();
        a2.showAllRecords();
    }
}
