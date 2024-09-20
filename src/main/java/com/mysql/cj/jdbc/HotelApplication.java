package com.mysql.cj.jdbc;

import com.example.demo.logic.DefaultHotel;
import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.services.RoomService;
import com.mysql.cj.jdbc.sql.Hotel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
public class HotelApplication implements Hotel {
	public static DefaultHotel hotel ;

	public static void main(String[] args) {

		SpringApplication.run(HotelApplication.class, args);

		//if did not generate
		ArrayList<Room> Hotel = hotel.generateRooms();

		System.out.println(Arrays.toString(args));

		//invite guest
		int id = Integer.parseInt(args[0]);
		RoomRepository repository = null;//pytanie
		RoomService service = new RoomService(repository);
		service.reserve(id);
		service.pay(id);


		//input data:
		//capacity room
		//number of days

		//getRoomByCapasity
	}



}
