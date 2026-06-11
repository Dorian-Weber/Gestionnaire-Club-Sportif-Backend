package com.mns.cda.filsrouge.mockAggregation;

import com.mns.cda.filsrouge.Iservice.IQRCodeService;
import com.mns.cda.filsrouge.aggregation.ReservationAggregationService;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.dto.ReservationQRCodeDTO;

import java.util.List;

// Mock implementation of ReservationAggregationService for testing
public class MockReservationAggregationService extends ReservationAggregationService {

    public MockReservationAggregationService() {
        super(null, null);
    }

    @Override
    public ReservationQRCodeDTO getReservationQRCode(Integer reservationId) {
        return null;
    }

    @Override
    public List<ReservationQRCodeDTO> getReservationsForUser(Integer userId) {
        return List.of();
    }
}



