// #include <iostream>
// #include <fstream>
// #include <sstream>
// #include <cstdlib>
// #include <string>
// #include<time.h>
// #include <limits>
// #include <bits/stdc++.h>
// #include <ctime>

// using namespace std;

import java.util.*;
import java.io.*;


#define MAX_SEQ 7
#define MAX_PKT 1024

enum event_type{frame_arrival, cksum_err,timeout, network_layer_ready};

class packet{
public unsigned char data[MAX_PKT];
} 


// int frame_kind; // can be data:1 ack:0 nak: -1
enum frame_kind{
	data, ack, nak;
}


class frame{
frame_kind kind;
int seq;
int ack;
packet info;
}

public static boolean between(seq_nr a,seq_nr b, seq_nr c){
	if(a<=b&&b<=c||c<=a&&a<=b|| b<=c&&c<=a)
		return true;
	else return false;
}


public static void send_data(seq_nr frame_nr, seq_nr frame_expected, packet buffer[]){
	frame s;
	s.info= buffer[frame_nr];
	s.seq = frame_nr;
	s.ack = (frame_expected+MAX_SEQ)%(MAX_SEQ+1);
	// to_physical_layer(s);
	// start_timer(frame_nr);
}


/*

public static void funccalled(){
	//frame arrival
	//timeout
	//next frame to send
	//check respective condition and rwturn from the loop

}

public static void protocol5(void)
{
	seq_nr next_frame_to_send;
	seq_nr ack_expected;
	seq_nr frame_expected;
	frame r;
	packet buffer[MAX_SEQ+1];
	seq_nr nbuffered;
	seq_nr i;
	event_type event;

	enable_network_layer();
	ack_expected =0;
	next_frame_to_send =0;
	frame_expected =0;
	nbuffered=0;


	while(true){


funccalled();


		wait_for_event(&event);
		switch (event){
			case network_layer_ready:
			from_network_layer(&buffer[next_frame_to_send]);
			nbuffered=nbuffered+1;
			send_data(next_frame_to_send,frame_expected,buffer);
			inc(next_frame_to_send);
			break;

			case frame_arrival:
			from_physical_layer(&r);
			// as receiver
			if(r.seq == frame_expected){
				to_network_layer(&r.info);
				inc(frame_expected);
			}
			// as sender
			while(between(ack_expected,r.ack,next_frame_to_send)){
				nbuffered = nbuffered -1;
				stop_timer(ack_expected);
				inc(ack_expected);
			}
			break;

			case cksum_err:break;

			case timeout:
			next_frame_to_send = ack_expected;
			for(int i =1;i<=nbuffered;i++){
				send_data(next_frame_to_send,frame_expected,buffer);
				inc(next_frame_to_send);
			}
		}

		if(nbuffered<MAX_SEQ){
			enable_network_layer();
		}
		else{
			disable_network_layer();
		}

			
	}
}







public static void main(String args[]){
	//connecton made
	datalink protocol();

}