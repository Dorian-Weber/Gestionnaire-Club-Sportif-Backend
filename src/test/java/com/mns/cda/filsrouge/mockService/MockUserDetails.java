package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.model.*;
import com.mns.cda.filsrouge.security.AppUserDetails;

import java.time.LocalDateTime;
import java.util.List;

public class MockUserDetails extends AppUserDetails {

    public MockUserDetails(int id, String role) {
        super(new AppUser(id,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                UserVisibility.PRIVATE,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(1,role),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation())));
    }
}
