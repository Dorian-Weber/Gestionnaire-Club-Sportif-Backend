package com.mns.cda.filsrouge.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mns.cda.filsrouge.Iservice.IQRCodeService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.UUID;

@Service
public class QRCodeService implements IQRCodeService {

    @Override
    public String generateQRCodeBase64(String content) {
        try {
            int width = 300;
            int height = 300;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

            byte[] pngData = pngOutputStream.toByteArray();

            return Base64.getEncoder().encodeToString(pngData);

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la génération du QR Code", e);
        }
    }
    @Override
    public String generateSecureToken() {
        return UUID.randomUUID().toString();
    }
}
