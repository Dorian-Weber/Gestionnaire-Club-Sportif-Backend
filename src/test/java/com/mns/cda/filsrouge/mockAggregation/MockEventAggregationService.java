package com.mns.cda.filsrouge.mockAggregation;

import com.mns.cda.filsrouge.aggregation.IEventAggregationService;
import com.mns.cda.filsrouge.dto.EventFull;

import java.util.List;

public class MockEventAggregationService implements IEventAggregationService {

    @Override
    public EventFull getEventFull(int idEvent) {
        return new EventFull(
                null,
                List.of(),
                List.of()
        );
    }
}