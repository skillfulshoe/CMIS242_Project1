//Philip Schumaker
//CMIS242 Project 1 - Read a text file and display employee information and
//                    average salaries for each year
//26Mar2017
//filename: employees.txt

package Project1Final;

public class Executive extends Employee
{//get executive information including bonus if applicable
	private double stock;
	
	public Executive(String name, double moSales, double stock)
	{
		super(name, moSales);
		this.stock = stock;
	}
	@Override
	public double annualSalary(double moSales, double stock)
	{//add bonus to annual salary if applicable
		if (stock > 50)
		{//if stock is over $50
			return super.annualSalary(moSales, 12) + 30000;
		}
		else
		{//if stock is $50 or less
			return super.annualSalary(moSales, 12);
		}
	}
	@Override
	public String toString()
	{//return main string and add stock price to it
		return super.toString() + String.format(" - Stock: $%,.2f", stock);
	}
}
