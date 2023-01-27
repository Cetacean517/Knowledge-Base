package com.cetacean.springbootlearning.util;

import com.cetacean.springbootlearning.data.*;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupEvent implements ApplicationListener<ApplicationStartedEvent> {
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    public ApplicationStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
//        Iterable<Guest> guests = guestRepository.findAll();
//        guests.forEach(System.out::println);
        Iterable<Reservation> res = reservationRepository.findAll();
        res.forEach(System.out::println);

    }
}
