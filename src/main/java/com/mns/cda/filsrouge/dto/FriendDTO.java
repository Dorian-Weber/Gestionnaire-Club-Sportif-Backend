package com.mns.cda.filsrouge.dto;

import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.model.Relation;
import com.mns.cda.filsrouge.model.Reservation;

import java.util.List;

public record FriendDTO(Integer idAppUser,
                        String appPseudo,
                        String appUserFirstName,
                        String appUserName,
                        String accountTypeName) { }
