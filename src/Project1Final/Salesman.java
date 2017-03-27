//Philip Schumaker
//CMIS242 Project 1 - Read a text file and display employee information and
//                    average salaries for each year
//26Mar2017
//filename: employees.txt

package Project1Final;

public class Salesman extends Employee
{//get salesman information including commission and annual sales
	private double anSales;
	
	public Salesman(String name, double moSalary, double anSales)
	{
		super(name, moSalary);
		this.anSales = anSales;
	}
	public double annualSalary(double moSalary, double anSales)
	{//take salary and add commission
		double commission = anSales * .02;
		if (commission < 20000)
		{//if commission is less than 20K
			return super.annualSalary(moSalary, 12) + commission;
		}
		else
		{//if commission is more than 20K
			return super.annualSalary(moSalary, 12) + 20000;
		}
	}
	@Override
	public String toString()
	{//return main string and add annual sales to it
		return super.toString() + String.format(" - Annual Sales: $%,.2f", anSales);
	}
}
