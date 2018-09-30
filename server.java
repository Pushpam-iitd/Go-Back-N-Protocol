import java.net.*;
import java.util.*;
import java.io.PrintStream;
class server{
	public static void main(String args[]){
		try{
				ServerSocket server =new ServerSocket(3000);
				Socket s=server.accept();
				System.out.println("Conneted Succesfully!");
				Scanner sc=new Scanner(System.in);
				Scanner sc1=new Scanner(s.getInputStream());
				PrintStream p=new PrintStream(s.getOutputStream());

				int num1, number; 
				while(true){
					System.out.print("Enter a number server: ");
					num1=sc.nextInt();
					p.println(num1);
					number=sc1.nextInt();
					System.out.println("\nnumber received is: "+number);

				}

		}catch(Exception e){

		}
	}
}

//nikhil11kulkarni@gmail.com