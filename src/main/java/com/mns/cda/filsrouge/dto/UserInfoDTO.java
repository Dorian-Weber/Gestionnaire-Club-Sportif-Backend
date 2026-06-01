package com.mns.cda.filsrouge.dto;

import com.mns.cda.filsrouge.enumerate.UserVisibility;

public record UserInfoDTO(
        String appUserName,
        String appUserFirstName,
        String appUserEmail,
        String appUserPhone,
        UserVisibility appUserVisibility
) {
}
