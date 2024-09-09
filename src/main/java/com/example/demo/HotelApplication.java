package com.example.demo;

import com.example.demo.logic.DefaultHotel;
import com.example.demo.models.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class HotelApplication {
	public static ArrayList<Room> hotel;

	public static void main(String[] args) {



		SpringApplication.run(HotelApplication.class, args);



		//input data:
		//capacity room
		//number of days

		//getRoomByCapasity
	}



}
