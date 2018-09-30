import java.net.*;
class server{
	public static void main(String args[]){
		try{
				ServerSocket server =new ServerSocket(3000);
				Socket s=server.accept();
				System.out.println("Conneted Succesfully!");

		}catch(Exception e){

		}
	}
}

//nikhil11kulkarni@gmail.com