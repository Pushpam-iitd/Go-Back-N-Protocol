import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class server{

int errprob=0.01;
public static void main(String args[]){

	try{
		ServerSocket server =new ServerSocket(3000);
		Socket s=server.accept();
		System.out.println("Conneted Succesfully!");
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(s.getInputStream());
		PrintStream p=new PrintStream(s.getOutputStream());

		String[] datatosend=new String[]{"frame0","frame1","frame0","frame3","frame4","frame5","frame6","frame7","frame8","frame9","frame10","frame11","frame12","frame13","frame14","frame15"};
		int ack_expected=0;

		//double start_time = time.millis();
		int windowSize=0;

for(int i=0;i<16;i++){


Random rand = new Random();
int  n = rand.nextInt(100)+1;
if(n<=errprob*100)datatosend[i]=datatosend[i]+"0";
else datatosend[i]=datatosend[i]+"1";

	p.println(datatosend[i]);
	
	TimeUnit.SECONDS.sleep(2);
	String str=sc1.next();
	String ack_str="ack"+Integer.toString(ack_expected);
	System.out.println("Data received from Client: "+str);
	if(str.equals(ack_str)){
		ack_expected++;
		//start_time=time.millis();
	}
	else{
		windowSize++;
		datatosend[i]="frame"+Integer.toString(i);
	}

	//double end_time=time.millis();

	if(windowSize==4 ){
		System.out.println("TIMEOUT:");
		for(int j=ack_expected;j<ack_expected+windowSize;j++){
			p.println(datatosend[j]+"1");
			String strreceived=sc1.next();
			System.out.println("Data received from Client: "+strreceived);			
		}
		windowSize=0;
		ack_expected=ack_expected+windowSize;
	}


}

	
}catch(Exception e){

		}


}

}



	// int num1, number; 
		
		// while(true){

		// 	System.out.print("Enter a number server: ");
		// 	num1=sc.nextInt();
		// 	p.println(num1);
		// 	number=sc1.nextInt();
		// 	System.out.println("\nnumber received is: "+number);

		// 	}

// 	int next_frame_to_send;
// 	int ack_expected;
// 	int frame_expected;
// 	frame r;
// 	String buffer[8];
// 	int nbuffered;
// 	int i;
// 	event_type event;

// //	enable_network_layer();
// 	ack_expected =0;
// 	next_frame_to_send =0;
// 	frame_expected =0;
// 	nbuffered=0;

// enum event_type{frame_arrival, cksum_err,timeout, network_layer_ready;}

// class packet{
// public unsigned char[] data=new char[MAX_PKT];
// } 

// int frame_kind; // can be data:1 ack:0 nak: -1
// enum frame_kind{
// 	data, ack, nak;
// }


// class frame{
// frame_kind kind;
// int seq;
// int ack;
// packet info;
// }

// public static boolean between(int a,int b, int c){
// 	if(a<=b&&b<=c||c<=a&&a<=b|| b<=c&&c<=a){return true;}
// 	else {return false;}
// }


// public static void send_data(int frame_nr, int frame_expected, packet buffer[]){
// 	frame s;
// 	s.info= buffer[frame_nr];
// 	s.seq = frame_nr;
// 	s.ack = (frame_expected+MAX_SEQ)%(MAX_SEQ+1);
// 	to_physical_layer(s);
// 	start_timer(frame_nr);
// }










// import java.net.*;
// import java.util.*;
// import java.io.PrintStream;
// class server{
// 	public static void main(String args[]){
// 		try{
// 				ServerSocket server =new ServerSocket(3000);
// 				Socket s=server.accept();
// 				System.out.println("Conneted Succesfully!");
// 				Scanner sc=new Scanner(System.in);
// 				Scanner sc1=new Scanner(s.getInputStream());
// 				PrintStream p=new PrintStream(s.getOutputStream());

// 				int num1, number; 
// 				while(true){
// 					System.out.print("Enter a number server: ");
// 					num1=sc.nextInt();
// 					p.println(num1);
// 					number=sc1.nextInt();
// 					System.out.println("\nnumber received is: "+number);

// 				}

// 		}catch(Exception e){

// 		}
// 	}
// }

// //nikhil11kulkarni@gmail.com