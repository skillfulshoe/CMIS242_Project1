//Philip Schumaker
//CMIS242 Project 1 - Read a text file and display employee information and
//                    average salaries for each year
//26Mar2017
//filename: employees.txt

package Project1Final;

import java.io.*;
import java.util.*;

public class Project1 
{
	public static void main(String[] args) 
	{//main method
		final int MAX_EMPLOYEE = 10;
		int count;
		Employee[] year2014 = new Employee[MAX_EMPLOYEE], year2015 = new Employee[MAX_EMPLOYEE];
		int count2014 = 0, count2015 = 0;
		double[] Salaries2014 = new double[MAX_EMPLOYEE], Salaries2015 = new double[MAX_EMPLOYEE];
		Scanner file;
		try 
		{//try opening the file
			file = new Scanner(new File("employees.txt"));
			while (file.hasNext())
			{//go through each line of the text file
				String year = file.next();
				String title = file.next();
				String name = file.next();
				String moSalary = file.next();
				Employee employee = null;
				double yrSalary = 0;
				
				switch (title)
				{//separate by job title and gather employee and salary
					case "Employee":
					{
						employee = new Employee(name, Double.parseDouble(moSalary));
						yrSalary = employee.annualSalary(Double.parseDouble(moSalary), 12);
						break;
					}
					case "Salesman":
					{
						String anSales = file.next();
						employee = new Salesman(name, Double.parseDouble(moSalary), Double.parseDouble(anSales));
						yrSalary = employee.annualSalary(Double.parseDouble(moSalary), Double.parseDouble(anSales));
						break;
					}
					case "Executive":
					{
						String stock = file.next();
						employee = new Executive(name, Double.parseDouble(moSalary), Double.parseDouble(stock));
						yrSalary = employee.annualSalary(Double.parseDouble(moSalary), Double.parseDouble(stock));
						break;
					}
				}
				switch (year)
				{//separate by year and add previous info to appropriate lists
					case "2014":
					{
						year2014[count2014] = employee;
						Salaries2014[count2014] = yrSalary;
						count2014++;
						break;
					}
					case "2015":
					{
						year2015[count2015] = employee;
						Salaries2015[count2015] = yrSalary;
						count2015++;
						break;
					}
				}
			}
			//display all the information using display method
			display("2014", year2014, Salaries2014, count2014);
			display("2015", year2015, Salaries2015, count2015);
		}
		catch (FileNotFoundException e) 
		{//print stack trace if failure to open the file
			e.printStackTrace();
		}
	}//end of main method
	
	public static void display(String year, Employee[] employees, double[] salaries, int count)
	{//display method
		double total = 0, avg = 0;
		//get average salary
		for (double salary : salaries)
		{
			total += salary;
		}
		avg = total / count;
		
		//print each employee information for the year
		System.out.format("\nInformation for the year %s:\n\n", year);
		for (int i = 0 ; i < count ; i++)
		{
			Employee employee = employees[i];
			System.out.println(employee);
		}
		//print average salary for the year
		System.out.format("\n%s's Average Salary: $%,.2f \n\n", year, avg);
	}//end of display method
}






