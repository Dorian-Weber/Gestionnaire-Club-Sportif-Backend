package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.dto.SeatDTO;

import java.util.List;

public interface ISeatAggregationService {

    public List<SeatDTO> getSeatsForEvent(int eventId,
                                          int currentUserId,
                                          String platform,
                                          String level);

    
}
