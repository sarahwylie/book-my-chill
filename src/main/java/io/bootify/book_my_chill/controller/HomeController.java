package io.bootify.book_my_chill.controller;

import io.bootify.book_my_chill.model.Reservation;
import io.bootify.book_my_chill.model.User;
import io.bootify.book_my_chill.service.ReservationService;
import io.bootify.book_my_chill.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class HomeController {

    final UserService userService;
    final ReservationService reservationService;
    public HomeController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/reservations")
    public String reservations(Model model, HttpSession session) {
        User user = userService.get(10000L);
        session.setAttribute("user", user);
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);

        return "reservations";
    }
    @PostMapping("/reservations-submit")
    public String reservationsSubmit(@ModelAttribute Reservation reservation,
                                     @SessionAttribute("user") User user) {

        // Save to DB after updating
        assert user != null;
        reservation.setUser(user);
        reservationService.create(reservation);
        Set<Reservation> userReservations = user.getReservations();
        userReservations.add(reservation);
        user.setReservations(userReservations);
        userService.update(user.getId(), user);
        return "redirect:/reservations";
    }
}
