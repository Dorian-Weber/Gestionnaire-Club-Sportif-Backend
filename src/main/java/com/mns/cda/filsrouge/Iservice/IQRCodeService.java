package com.mns.cda.filsrouge.Iservice;

public interface IQRCodeService {
    String generateQRCodeBase64(String content);

    String generateSecureToken();
}
