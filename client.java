import java.net.*;
import java.util.*;
import java.io.PrintStream;
class client{
	public static void main(String args[]){
		try{
				Socket s=new Socket("127.0.0.1",3000);
				System.out.println("Conneted client Succesfully!");
				Scanner sc=new Scanner(System.in);
				Scanner sc1=new Scanner(s.getInputStream());
				PrintStream p=new PrintStream(s.getOutputStream());

				int num1, number; 
				while(true){
					number=sc1.nextInt();
					System.out.println("\nnumber received is: "+number);
					System.out.print("Enter a number client: ");
					num1=sc.nextInt();
					p.println(num1);

				}



		}catch(Exception e){

		}
	}
}