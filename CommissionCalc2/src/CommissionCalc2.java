import javax.swing.JOptionPane; //For dialog boxes
import java.text.DecimalFormat; //For formatting decimals

/**
* Simple Commission Calculation Program Part 2
* Samuel Tollefson
* PRG/420
* December 22, 2014
* William Davis
*/

public class CommissionCalc2
{
    public static void main(String[] args)
    {
        int reply;
        // To hold string imputs
        String inputString; 
        
        // Dollar and decimal formatters
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        DecimalFormat percent = new DecimalFormat("#0%");

        // Create a Compensation object
        Compensation user = new Compensation();
        
        // Display a greeting
        JOptionPane.showMessageDialog(null, "This program calculates the "
            + "total compensation of a salesperson.\n\nCommission will be"
            + " added to the salesperson's pay if sales reach " 
            + percent.format(user.getIncentStart()) 
            + "\nof the sales target.\n\n" 
            + "When the salesperson reaches the sales goal of $"
            + formatter.format(user.getSalesTarget()) 
            + "\ncommisssion will be multiplied by a set acceleration factor");
        
        do
        {
            //Get the user's firs and last names
        user.setFirstName
            (JOptionPane.showInputDialog("Please enter your first name."));
        user.setLastName
            (JOptionPane.showInputDialog("Please enter your last name."));
        
        // Display name on console
        System.out.println(user.getFirstName() + " " + user.getLastName() 
            + "\n");

        // Get salary and convert input to double
        inputString = JOptionPane.showInputDialog
            ("Please input your annual salary?");
            user.setSalary(Double.parseDouble(inputString));
        
        // Display salary on console
        System.out.println("Salary = $" + formatter.format(user.getSalary()) 
            + "\n");

        // Get annual sales and convert input to double
        inputString = JOptionPane.showInputDialog
            ("Please input your total sales amount for the year?");
            user.setAnnualSales(Double.parseDouble(inputString));
        
        // Display sales and commission on console
        System.out.println("Sales = $" + formatter.format(user.getAnnualSales()) 
            + "\n");
        System.out.println("Commission = $" + formatter.format
            (user.getTotalCommis()) + "\n");
        
        // Display for sales target reached
        if (user.getAnnualSales() >= user.getSalesTarget())
            JOptionPane.showMessageDialog
                (null, "Congratulations!\n\nYou reached the sales target of $" 
                + formatter.format(user.getSalesTarget()) 
                + ".\n\nYour compensation has been multiplied by "
                + "the acceleration factor.");
        
        // Display for 80% of sales target reached
        else if (user.getAnnualSales() >= user.getSalesTarget() 
                    * user.getIncentStart())
            JOptionPane.showMessageDialog
                (null, "You are only $" + formatter.format(user.getSalesTarget() 
                    - user.getAnnualSales()) 
                + " short of the sales target.\n\nCompensation has been added "
                + "to your pay.");  
        
        // Display if no goals reached
        else
            JOptionPane.showMessageDialog
                (null, "You are only $" + formatter.format((user.getSalesTarget() 
                    * user.getIncentStart()) 
                    - user.getAnnualSales()) 
                + " short of the earnig commission.\n\nKeep up the good work.");  
        
        // Display total compensation on console
        System.out.println("Total compensation = $" 
            + formatter.format(user.getTotalComp()) + "\n");

        // Display total compensation in dialog box
        JOptionPane.showMessageDialog
            (null, user.getFirstName() + " " + user.getLastName() 
            + "\n\nYour total compensation "
            + "is $" + formatter.format(user.getTotalComp()));
        
        // Table introduction
        JOptionPane.showMessageDialog
            (null, "The following table represents your potential total "
            + "annual compensation in $5000 increments above annual "
            + "sales,\nuntil it reaches 50% above your total annual sales.");
        
        // Display the table headings
        System.out.println("Total sales\t\t\t\tTotal compensation");
        System.out.println("----------------------------------------"
            + "------------------");
        
        // Declare controlExit variable 
        double controlExit= user.getAnnualSales() * 1.5;
        
        // Innitiate loop for projected compensation table
        while (controlExit >= user.getAnnualSales())
        {
            if (user.getAnnualSales() >= user.getSalesTarget())
            {
                System.out.println("$" + (formatter.format(user.getAnnualSales()) 
                    + "\t\t\t\t$" + (formatter.format(user.getTotalComp()))));
                
                    // increment annual sales
                    user.setAnnualSales(user.getAnnualSales() + 5000);
            }     
            else if (user.getAnnualSales() >= user.getSalesTarget() 
                        * user.getIncentStart()) 
            {
                System.out.println("$" + (formatter.format(user.getAnnualSales()) 
                    + "\t\t\t\t$" + (formatter.format(user.getTotalComp()))));
                
                    // increment annual sales
                    user.setAnnualSales(user.getAnnualSales() + 5000);
                
                // Sales target benchmark declaration
                if (user.getAnnualSales() >= user.getSalesTarget())
                    System.out.println("\nSales target hit, commission is "
                        + "multiplied by set acceleration factor.");
            }        
            else  
            {
                System.out.println("$" + (formatter.format(user.getAnnualSales()) 
                        + "\t\t\t\t$" + (formatter.format(user.getTotalComp()))));
                
                        // increment annual sales
                        user.setAnnualSales(user.getAnnualSales() + 5000);
                 
                // Commission benchmark declaration
                if (user.getAnnualSales() >= user.getSalesTarget() 
                        * user.getIncentStart())
                    System.out.println("\nSales have reached " 
                        + percent.format(user.getIncentStart()) 
                        + " of sales target. Commission is added to pay.");
            }
        }
        
        reply = JOptionPane.showConfirmDialog(null, "Would you like to run the program again?", "", JOptionPane.YES_NO_OPTION);
        }
        while (reply == JOptionPane.YES_OPTION);
    }  
}