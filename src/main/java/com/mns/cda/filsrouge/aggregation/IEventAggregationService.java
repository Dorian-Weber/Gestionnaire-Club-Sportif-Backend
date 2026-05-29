package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.dto.EventFull;

public interface IEventAggregationService {

    public EventFull getEventFull(int idEvent);
}
