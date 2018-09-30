import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class client{

public static void main(String args[]){

		try{
			Socket s=new Socket("127.0.0.1",3000);
			System.out.println("Conneted client Succesfully!");
			Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(s.getInputStream());
			PrintStream p=new PrintStream(s.getOutputStream());


		String[] datatosend=new String[]{"ack0","ack1","ack2","ack3","ack4","ack5","ack6","ack7","ack8","ack9","ack10","ack11","ack12","ack13","ack14","ack15"};
		int ack_expected=0;

		//double start_time = time.millis();
		int windowSize=4;
		boolean nackNeccesary=false; 
for(int i=0;i<16;i++){

	String str=sc1.next();
	String ack_str="frame"+Integer.toString(ack_expected); //if(nackNeccesary==false)
	TimeUnit.SECONDS.sleep(2);
	System.out.println("Data received from Server: "+str);
	if(str.charAt(str.length)=="1"){
//		nackNeccesary=false;
		ack_expected++;
		p.println(datatosend[i]);
		//start_time=time.millis();
	}
	else{
//		nackNeccesary=true;
		for(int j=0;j<windowSize;j++){
			p.println("n"+datatosend[i]);			
			String str1=sc1.next();
			System.out.println("Data received from Server: "+str1);			
		}

			p.println(datatosend[i]);			
ack_expected++;
	}


//	if(windowSize>3 ){
	// 	System.out.println("TIMEOUT:");
	// 	for(int j=ack_expected;j<ack_expected+windowSize;j++){
	// 		p.println(datatosend[j]);
	// 		String strreceived=sc1.next();
	// 		System.out.println("Data received from Client: "+strreceived);			
	// 	}
	// 	windowSize=0;
	// }


}





		}catch(Exception e){

		}

	}
}

