package com.mns.cda.filsrouge.mockAggregation;

import com.mns.cda.filsrouge.aggregation.ISeatAggregationService;
import com.mns.cda.filsrouge.dto.SeatDTO;

import java.util.List;

public class MockSeatAggregationService implements ISeatAggregationService {

    @Override
    public List<SeatDTO> getSeatsForEvent(int eventId, int userId, String platform, String level) {
        return List.of(
                new SeatDTO(1, "A1", false, false, "User1"),
                new SeatDTO(2, "A2", true, false, "User2")
        );
    }
}
