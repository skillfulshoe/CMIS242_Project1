//Philip Schumaker
//CMIS242 Project 1 - Read a text file and display employee information and
//                    average salaries for each year
//26Mar2017
//filename: employees.txt

package Project1Final;

public class Employee 
{//main employee class
	private String name;
	private double moSalary;
	
	public Employee(String name, double moSalary)
	{
		this.name = name;
		this.moSalary = moSalary;
	}
	
	public double annualSalary(double moSalary, double months)
	{//multiply monthly salary by 12 to get annual salary
		return moSalary * months;
	}
	@Override
	public String toString()
	{//main string method
		return String.format("Employee: %s - Monthly Salary: $%,.2f", name, moSalary);
	}
}
