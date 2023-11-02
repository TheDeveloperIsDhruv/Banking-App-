import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
  
public class unit_test {
    //Account.java page
    // checking if account type matches or not
    void test_accountType()
    {
      int expectedvalue = "Savings";
      setAccount_Type("Savings");
      int x = getAccount_Type();
      if (x == expectedvalue) 
      {
        System.out.println("Passed");
      }
      else 
      {
        System.out.println("Failed");
      }
    }
  
    // checking for the balance when certain amount is deposited 
    void test_depositAccount()
    {
      Account account = new Account();
      float expectedvalue = 1000.0 ;
      account.depositAccount_Balance(1000.0);
      float x = get_balance(); 
      if (x == expectedvalue) 
      {
        System.out.println("Passed");
      }
      else 
      {
        System.out.println("Failed");
      }
    }

    // checking for the balance when certain amount is withdrawn
    void test_withdrawWithSufficientFunds()
    {
      Account account = new Account();
      account.depositAccount_Balance(1000);
      account.withdrawAccount_Balance(500);
      float expectedvalue = 500.0 ;
      float x = get_balance();
      if (x == expectedvalue) 
      {
        System.out.println("Passed");
      }
      else 
      {
        System.out.println("Failed");
      }
    }

    // checking for the error when exceeded amount is withdrawn
    void test_withdrawWithInsufficientFunds()
    {
      Account account = new Account();
      account.depositAccount_Balance(1000);
      account.withdrawAccount_Balance(1500);
      String expectedvalue = "Insufficient funds" ;
      float x = get_balance();
      if (x == expectedvalue) 
      {
        System.out.println("Passed");
      }
      else 
      {
        System.out.println("Failed");
      }
    }

    // Transfer funds page
     void test_dashboard_button() 
    {
        dashboard dashboardObj = new dashboard();
        // Click the button
        dashboardObj.jButton2MouseClicked(null);
        assertTrue(dashboardObj.isVisible());
        assertFalse(dashboardObj.isDisplayable());
    }

    //Make payment page
    void test_makePayment1()
    {
      Account account = new Account();
      float expectedvalue = get_balance() - 500.0 ;
      account.MakePayment(500.0);
      float x = get_balance(); 
      if (x == expectedvalue) 
      {
        System.out.println("Passed");
      }
      else 
      {
        System.out.println("Failed");
      }
    }
    
    // deposit class
    public void testDeposit() {
        // Initialize a BankAccount with a balance of $100
        BankAccount account = new BankAccount(100.00);

        // Deposit $50 into the account
        account.deposit(50.00);

        // Check that the balance is now $150
        assertEquals(150.00, account.getBalance(), 0.01);
    }
   
    // signup page 
    // Test inserting data into the database
    public void testInsertData() {
        String expectedUsername = "testuser";
        String expectedPassword = "testpassword";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Dhruv123");

            // Execute SQL query
            String sql = "INSERT INTO user_data (username, password) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, expectedUsername);
            stmt.setString(2, expectedPassword);
            int rowsInserted = stmt.executeUpdate();

            // Verify data was inserted successfully
            assertEquals(1, rowsInserted);

            // Check if data was actually inserted
            sql = "SELECT * FROM user_data WHERE username=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, expectedUsername);
            rs = stmt.executeQuery();

            // Verify only one row is returned
            assertTrue(rs.next());
            assertFalse(rs.next());

            // Verify data matches what was inserted
            String actualUsername = rs.getString("username");
            String actualPassword = rs.getString("password");
            assertEquals(expectedUsername, actualUsername);
            assertEquals(expectedPassword, actualPassword);

        } catch (SQLException se) {
            se.printStackTrace();
            fail("SQL error: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public void testDepositWithNegativeAmount() {
        Deposite deposite = new Deposite();
        deposite.jRadioButton1.setSelected(true); // Select savings account type
        String x = deposite.DepoAmnt.setText("-100"); // Enter negative amount
        deposite.DepositeBtn.doClick(); // Click deposit button

        if (x == "Negative deposit amount is not valid")
        {
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }
    }

    public void testDepositWithNoAmount() {
        Deposite deposite = new Deposite();
        deposite.jRadioButton1.setSelected(true); // Select savings account type
        String x =  deposite.DepoAmnt.setText(null); // Enter null amount
        deposite.DepositeBtn.doClick();
        if (x == "Enter valid amount")
        {
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }
            
        
    }

    public void testWithdrawNoAmount() {
        Withdraw withdraw = new Withdraw()
        // Attempt to withdraw with no amount specified
        String x = account.withdrawAccount_Balance(null); // Enter null amount
        withdraw.WithdrawBtn.doClick();
        if (x == "Enter valid amount")
        {
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }
        
    }

    public void testWithdrawWithNegativeAmount() {
        Withdraw withdraw = new Withdraw();
        withdraw.jRadioButton1.setSelected(true); // Select savings account type
        String x = withdraw.setText("-100"); // Enter negative amount
        deposite.DepositeBtn.doClick(); // Click deposit button
        if (x == "Negative deposit amount is not valid")
        {
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }
    }


}


