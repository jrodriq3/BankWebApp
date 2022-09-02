package Business;

/**
 * Jason Rodriguez
 * Lab #5 
 * Aug 25, 2022
 * I promise I wrote this code
 * 
 */

import java.sql.*;



public class Customer {
    private int Id;
    private String password;
    private String fName;
    private String lName;
    private String address;
    private String email;
    public AccountList aList = new AccountList();

    public Customer() {
        Id = 0;
        password = "";
        fName = "";
        lName = "";
        address = "";
        email = "";
        
    }

    public Customer(int Id, String password, String fName, String lName, String address, String email) {
        this.Id = Id;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.email = email;
    }
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void getAccounts() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select acctNo from Accounts where Cid = " + getId() + ";";
            ResultSet rs = stmt.executeQuery(sql);
            int accountNumber;
            Account a1;
            while (rs.next()) {
                accountNumber = Integer.parseInt(rs.getString(1));
                a1 = new Account();
                a1.selectDB(accountNumber);
                aList.addAccount(a1);

            }
            con.close();
            
        } catch (Exception e) {
        }
    }
    public void display() {
        System.out.println("ID                  = " + Id);
        System.out.println("Password            = " + password);
        System.out.println("FirstName           = " + fName);
        System.out.println("LastName            = " + lName);
        System.out.println("Address             = " + address);
        System.out.println("Email               = " + email);
        System.out.println("");
        System.out.println("Accounts");
        aList.displayList();
    }
    public void selectDB(int i) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Customers where CustId = " + i;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            Id = Integer.parseInt(rs.getString(1));
            password = rs.getString(2);
            fName = rs.getString(3);
            lName = rs.getString(4);
            address = rs.getString(5);
            email = rs.getString(6);
            getAccounts();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "insert into Customers VALUES (" + getId() + ", " + "'" + getPassword() + "', " + "'" +
                    getfName() + "', " + "'" + getlName() + "', " + "'" + getAddress() + "', " + "'" + getEmail() + "');";
            stmt.executeUpdate(sqlQuery);
            con.close();
        } catch (Exception e) {
        }
    }
    public void insertDB(int id, String pwd, String firstName, String lastName, String adr, String eml) {
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "insert into Customers VALUES (" + id + ", " + "'" + pwd + "', " + "'" +
                    firstName + "', " + "'" + lastName + "', " + "'" + adr + "', " + "'" + eml + "');";
            stmt.executeUpdate(sqlQuery);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteDB() {
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "Delete FROM Customers Where CustID = " + getId() + ";";
            stmt.executeUpdate(sqlQuery);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteDB(int id) {
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            String sqlQuery = "Delete FROM Customers Where CustID = " + id + ";";
            stmt.executeUpdate(sqlQuery);
            con.close();
        } catch (Exception e) {
        }
    }
    // below method used to see the database because i cannot view it on my computer.
    public void showAllRecords() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sqlQuery = "select * from Customers;";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            System.out.print("\t" + "CustID");
            System.out.print("\t" + "CustPassword");
            System.out.print("\t" + "CustFirstName");
            System.out.print("\t" + "CustLastName");
            System.out.print("\t" + "CustAddress");
            System.out.print("\t" + "CustEmail");
            System.out.println("");
            while (rs.next()) {
                System.out.println();
                System.out.print("\t" + rs.getString(1));
                System.out.print("\t" + rs.getString(2));
                System.out.print("\t\t" + rs.getString(3));
                System.out.print("\t\t" + rs.getString(4));
                System.out.print("\t\t" + rs.getString(5));
                System.out.print("\t\t" + rs.getString(6));
                
            }
            System.out.println("");
            con.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.selectDB(3001);
        c1.display();
        /*
        Customer c2 = new Customer(3007, "nosaj", "jason", "Rodriguez", "123 whatever way", "j@r.com");
        c2.insertDB();
        c2.showAllRecords();
        
        Customer c3 = new Customer();
        c3.selectDB(3007);
        c3.deleteDB();
        c3.showAllRecords();
        */
        
    }
}
