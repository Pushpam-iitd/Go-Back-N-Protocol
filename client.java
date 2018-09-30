import java.net.*;
class client{
	public static void main(String args[]){
		try{
				Socket s=new Socket("127.0.0.1",3000);
				System.out.println("Conneted C Succesfully!");

		}catch(Exception e){

		}
	}
}