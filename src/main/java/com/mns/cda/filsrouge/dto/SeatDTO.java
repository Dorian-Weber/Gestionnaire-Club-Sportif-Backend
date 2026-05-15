package com.mns.cda.filsrouge.dto;

public record SeatDTO(Integer idSeat,
                      String seatNumber,
                      boolean status,
                      boolean reservedByFriend
                      ) {
}
