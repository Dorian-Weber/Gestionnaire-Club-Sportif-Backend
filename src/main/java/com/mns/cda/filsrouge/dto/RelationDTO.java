package com.mns.cda.filsrouge.dto;

import com.mns.cda.filsrouge.enumerate.RelationStatus;

public record RelationDTO(
        Integer firstUserId,
        Integer secondUserId,
        RelationStatus status
) {}

