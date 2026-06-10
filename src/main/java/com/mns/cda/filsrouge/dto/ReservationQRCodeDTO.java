package com.mns.cda.filsrouge.dto;

import java.util.List;

public record ReservationQRCodeDTO(
        Integer reservationId,
        EventLight event,
        List<SeatFull> seats,
        String statusPresence,
        String qrCodeBase64
) {}
