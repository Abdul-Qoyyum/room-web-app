package com.cloudnqt.roomwebapp;

//import com.cloudnqt.roomwebapp.data.repository.RoomRepository;
//import com.cloudnqt.roomwebapp.data.repository.StaffRepository;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWebAppApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(RoomRepository roomRepository, StaffRepository staffRepository) {
//        return args -> {
//            System.out.println("Printing Room ************* \r\n");
//            roomRepository.findAll().forEach(System.out::println);
//            System.out.println("\r\n Printing Staffs ************* \r\n");
//            staffRepository.findAll().forEach(System.out::println);
//        };
//    }
}
