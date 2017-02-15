package com.innovatis.lynx.document.service;

import com.amazonaws.services.s3.AmazonS3;
import com.innovatis.lynx.document.service.dto.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Ramakrishna Chalasani 02/14/2017.
 */
public class S3ServiceImpl implements S3Service {

    @Autowired
    @Qualifier("s3Client")
    AmazonS3 s3client;


    @Override
    public void uploadDocument(DocumentDto documentDto) {
        
    }
}
