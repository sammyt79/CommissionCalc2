/**
* This class holds user's name and values, and  
* calculates total commission and total compensation
*/

public class Compensation
{
    private String 
            firstName,
            lastName;
    private double 
            salary,
            annualSales; 
    private final double 
            salesTarget = 120000,
            incentStart = 0.8;
    
    /**
    * The constructor initializes the salary and
    * annualSales fields to 0.0
    */
    public Compensation()
    {
        salary = 0.0;
        annualSales = 0.0;
    }
    
    /**Accepts arguments that are 
    * stored in the firstName field
    * @param first
    */
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    /**Returns the value stored in
    * the firstName field
    * @return 
    */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**Accepts arguments that are 
    * stored in the lastName field
    * @param last
    */
    public void setLastName(String last)
    {
        lastName = last;
    }
    
    /**Returns the value stored in
    * the lastName field
    * @return 
    */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
    * The setSalary method accepts an argument
    * that is stored in the salary field
    * @param sal
    */
    public void setSalary(double sal)
    {
        salary = sal;
    }
    
    /**Returns the value stored in
    * the salary field
    * @return 
    */
    public double getSalary()
    {
        return salary;
    }

    /**
    * The setAnnualSales method accepts an argument that
    * is stored in the annualSales field
    * @param annSals
    */
    public void setAnnualSales(double annSals)
    {
        annualSales = annSals;
    }

    /**Returns the value stored in
    * the annualSales field
    * @return 
    */
    public double getAnnualSales()
    {
        return annualSales;
    }
    
    /**Returns the value stored in
    * the salesTarget field
    * @return 
    */
    public double getSalesTarget()
    {
        return salesTarget;
    }
    
    /**Returns the value stored in
    * the incentStart field
    * @return 
    */
    public double getIncentStart()
    {
        return incentStart;
    }

    /**
    * The getTotalCommis method calculates and returns the
    * commission based on the applicable commission 
    * and acceleration factor. Used only to display 
    * total commission to the user
    */
    public double getTotalCommis()
    {
        double 
        commission, // Holds the commission
        accelFactor; // Holds the acceleration factor

        if (annualSales >= salesTarget)       
        { 
            commission = 0.09;
            accelFactor = 1.25;
        }  
        else if (annualSales >= salesTarget * incentStart)
        { 
            commission = 0.09;
            accelFactor = 1;
        }
        
        else
        {
            commission = 0;
            accelFactor = 1;
        }

        return (commission * annualSales) * accelFactor;
    }
    
    /**
    * The getTotalComp method calculates and returns
    * total compensation based on the applicable commission 
    * and acceleration factor
    */
    public double getTotalComp()
    {
        double 
        commission, // Holds the gross paycommission
        accelFactor; // Holds acceleration factor

        if (annualSales >= salesTarget)       
        { 
            commission = 0.09;
            accelFactor = 1.25;
        }  
        else if (annualSales >= salesTarget * incentStart)
        { 
            commission = 0.09;
            accelFactor = 1;
        }
        
        else
        {
            commission = 0;
            accelFactor = 1;
        }

        return ((commission * annualSales) * accelFactor) + salary;
    }
}
