package io.bootify.book_my_chill.repos;

import io.bootify.book_my_chill.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
