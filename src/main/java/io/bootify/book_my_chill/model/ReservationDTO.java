package io.bootify.book_my_chill.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationDTO {

    private Long id;

    @NotNull
    private LocalDate reservationDate;

    @Schema(type = "string", example = "14:30")
    private LocalTime startTime;

    @Schema(type = "string", example = "14:30")
    private LocalTime endTime;

    @NotNull
    private Long user;

}
