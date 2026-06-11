package com.mns.cda.filsrouge.mockAggregation;

import com.mns.cda.filsrouge.aggregation.UserPublicAggregation;
import com.mns.cda.filsrouge.dto.UserPublicProfil;

// Mock implementation of UserPublicAggregation for testing
public class MockUserPublicAggregation extends UserPublicAggregation {

    public MockUserPublicAggregation() {
        super(null, null, null, null);
    }

    @Override
    public UserPublicProfil getMyPublicProfile(int userId) {
        return null;
    }

    @Override
    public UserPublicProfil getPublicProfileOfUser(Integer targetId, Integer visitorId) {
        return null;
    }
}


