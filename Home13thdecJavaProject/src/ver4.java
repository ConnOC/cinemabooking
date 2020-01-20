import java.text.DecimalFormat;
import java.util.Scanner;

public class ver4 
{
		/*movie */
		
	static double adult = 10.50;
	static double student = 9.50;		
	static double child = 7.50;
	static double  transactionPrice = 0;
	static double totalCash = 0;
		
	static int numAdultTickets = 0;
	static int numStudentTickets = 0;
	static int numChildTickets = 0;
	static int numTotalTickets = numAdultTickets+numStudentTickets+numChildTickets;
		
		
	static int time;
	static String ticket;
	static int qtyJoker1500 = 5;
	static int qtyToyStory41500 = 6;
	static int qtyTheIrishMan1500 = 3;
	static int qtyJoker1730 = 4;
	static int qtyToyStory41730 = 5;
	static int qtyTheIrishMan1730 = 3;
	static int qtyJoker2000 = 9;
	static int qtyToyStory42000 = 7;
	static int qtyTheIrishMan2000 = 3;
		
		
	static int numTransactions = 0;
	static Scanner input = new Scanner(System.in);
	static DecimalFormat currency = new DecimalFormat("0.00");
	static double totalTicketsSold;
	static double totalRevenue;
	static int totalTransactions;
	static double averageRevenuePerTransaction = totalRevenue/totalTransactions;
		
	public static void main(String[] args)
	{
		
		chooseTime();
			
	}
		
	public static void chooseTime()
	{
		System.out.println(" select your time");
		System.out.println("**********************************");
		System.out.println("Press 1 for 15:00");
		System.out.println("Press 2 for 17:30");
		System.out.println("Press 3 for 20:00");
		System.out.println("press a for admin");
		System.out.println("**********************************");
			
        String choice = input.next();
			
		switch(choice)
		{
			case "1":
			{	
				time = 1500;
				chooseMovie();
				break;
			}
			case "2":
			{
				time = 1730;
				chooseMovie();
				break;
			}
			case "3":
			{
				time = 2000;
				chooseMovie();
				break;
			}
			case "a":
			{
				admin();
				break;
			}
			case "x":
			{
				System.out.println("System closing down");
				System.exit(0);
			}
				
			default:
			{
				System.out.println("Invalid Choice. Please try again");
				break;
			}
		}
	}
		
	public static void chooseMovie()
	{
		System.out.println(" select your movie");
		System.out.println("**********************************");
		System.out.println("Press 1 for Joker");
		System.out.println("Press 2 for Toy Story 4");
		System.out.println("Press 3 for The Irish man");
		System.out.println("**********************************");
			
		String choice = input.next();
			
		switch(choice)
		{
			case "1":
			{
				if((qtyJoker1500==0 && time == 1500)||(qtyJoker1730==0 && time == 1730)||(qtyJoker2000==0 && time == 2000)) //If quantity of joker is zero, prevent user from continuing
				{
					System.out.println("Sold out. Please choose another movie");
					chooseTime();
				}
				ticket = "Joker";
				chooseTicketType();
				break;
			}
			case "2":
			{
				if((qtyToyStory41500==0 && time == 1500)||(qtyToyStory41730==0 && time == 1730)||(qtyToyStory42000==0 && time == 2000)) //If quantity of toystory4 is zero, prevent user from continuing
				{
					System.out.println("Sold out. Please choose another moviet");
					chooseTime();
				}
				ticket = "Toy Story 4";
				chooseTicketType();
				break;
			}
			case "3":
			{
				if((qtyTheIrishMan1500==0 && time == 1500)||(qtyTheIrishMan1730==0 && time == 1730)||(qtyTheIrishMan2000==0 && time == 2000)) //If quantity of theirishman is zero, prevent user from continuing
				{
					System.out.println("Sold out. Please choose another movie");
					chooseTime();
				}
				ticket = "The Irish Man";
				chooseTicketType();
				break;
			}
			
			case "x":
			{
				System.out.println("System closing down");
				System.exit(0);
			}
			default:
			{
					System.out.println("Invalid Choice. Please try again");
					break;
			}
		}
			
		chooseMovie();
	}
		
	private static void admin()
	{
		System.out.println("total tickets sold is "+totalTicketsSold);
		System.out.println("total revenue is €"+totalRevenue);
		System.out.println("average revenue per transaction is €"+averageRevenuePerTransaction);
		System.out.println("total transactions is "+numTransactions);
		chooseTime();
	}



	public static void chooseTicketType()
	{
		System.out.println("Now choose ticket type");
		System.out.println("**********************************");
		System.out.println("Press 1 for adult");
		System.out.println("Press 2 for student");
		System.out.println("Press 3 for child");
		System.out.println("Press 4 for Multiple Tickets");
		System.out.println("Press 'C' to Cancel");		
		System.out.println("**********************************");
		String choice = input.next();
			
		switch(choice)
		{
			case "1":
			{
				System.out.println("You have chosen Adult");
				numAdultTickets++;
				break;
			}
			case "2":
			{
				System.out.println("You have chosen Student");
				numStudentTickets++;
				break;
			}
			case "3":
			{
				System.out.println("You have chosen Child");
				numChildTickets++;
				break;
			}
			
			case "4":
			{
				addTickets();
				break;
			}
			case "c":
			{
				break;
			}
			default:
			{
				System.out.println("Invalid Choice. Please try again");
				chooseTicketType();
			}
			
			
		}
		calcCost();	
	}

	public static void addTickets()
	{	
		System.out.println("Press 1 to add Adult Ticket");
		System.out.println("Press 2 to add Student Ticket");
		System.out.println("Press 3 to add Child Ticket");
		System.out.println("Press 'P' to proceed to Payment");
		
		String choice = input.next();
					
		switch(choice)
		{
			case "1":
			{
				numAdultTickets++;
				addTickets();
				break;
			}
			case "2":
			{
				numStudentTickets++;
				addTickets();
				break;
			}
			case "3":
			{
				numChildTickets++;
				addTickets();
				break;
			}
		
			case "p":
			{
				calcCost();
				break;
			}
		}
	}
					
	public static void calcCost()
	{
		transactionPrice =  (numAdultTickets*adult)+(numStudentTickets*student)+(numChildTickets*child);
		payment();
	}
						
	public static void payment()
	{
		System.out.println("Transaction Price is €" + currency.format(transactionPrice));
		System.out.println("Please enter credit card number");
		String creditCardNumber = input.next();
		if(creditCardNumber.length()<16||creditCardNumber.length()>16)
		{
			System.out.println("Invalid card number, try again");
			payment();
		}
		else 
		{
			System.out.println("enter cvv");	
		}
		String cvv = input.next();
						
		if(cvv.length()>3||cvv.length()<3)
		{
			System.out.println("Invalid cvv, try again");
			payment();
		}
		else
		{
			System.out.println("enter expiry date in the format MMYY");			
		}
						
		String expiryDate = input.next();
		if(expiryDate.length()<4||expiryDate.length()>4)
		{
			System.out.println("Invalid expiry date, try again");
			payment();
		}
						
						
							
						
						
		if(ticket.equals("Joker")&&time == 1500)
		{
			qtyJoker1500= qtyJoker1500 - (numAdultTickets+numStudentTickets+numChildTickets);
		}
		else if (ticket.equals("Toy Story 4")&&time == 1500)
		{
			qtyToyStory41500= qtyTheIrishMan1500 - (numAdultTickets+numStudentTickets+numChildTickets);	
		}
		else if (ticket.equals("The Irish Man")&&time == 1500)
		{
			qtyTheIrishMan1500 = qtyTheIrishMan1500 - (numAdultTickets+numStudentTickets+numChildTickets);
		}
		else if(ticket.equals("Joker")&&time == 1730)
		{
			qtyJoker1730 = qtyJoker1730 - (numAdultTickets+numStudentTickets+numChildTickets);
		}
		else if (ticket.equals("Toy Story 4")&&time == 1730)
		{
			qtyToyStory41730= qtyToyStory41730 - (numAdultTickets+numStudentTickets+numChildTickets);				
		}
		else if (ticket.equals("The Irish Man")&&time == 1730)
		{
			qtyTheIrishMan1730= qtyTheIrishMan1730 - (numAdultTickets+numStudentTickets+numChildTickets);		
		}
		else if(ticket.equals("Joker")&&time == 2000)
		{
			qtyJoker2000 = qtyJoker2000 - (numAdultTickets+numStudentTickets+numChildTickets);
		}
		else if (ticket.equals("Toy Story 4")&&time == 2000)
		{
			qtyToyStory42000 = qtyToyStory42000 - (numAdultTickets+numStudentTickets+numChildTickets);
		}
		else if (ticket.equals("The Irish Man")&&time == 2000)
		{
			qtyTheIrishMan2000= qtyTheIrishMan2000 - (numAdultTickets+numStudentTickets+numChildTickets);
		}
						
			
		totalTicketsSold = totalTicketsSold+numAdultTickets+numStudentTickets+numChildTickets;
		totalRevenue = totalRevenue+transactionPrice;
		totalTransactions++;			
						
		System.out.println(qtyTheIrishMan1500);
		System.out.println("******************************");
		System.out.println("your details are as follows:");
		System.out.println("your film starts at: "+time);
		System.out.println("your film is: "+ticket);
		System.out.println("no. of adult tickets: "+numAdultTickets);
		System.out.println("no of student tickets: "+numStudentTickets);
		System.out.println("no of child tickets: "+numChildTickets);
		System.out.println("total transaction price is: €"+transactionPrice);
		System.out.println("enjoy your movie");
		System.out.println("*****************************");
		reset();
	}

	public static void reset()
	{	
		transactionPrice = 0;
		numAdultTickets = 0;
		numChildTickets = 0;
		numStudentTickets = 0;
		chooseTime();
	}
}
	
	
	
	
	



