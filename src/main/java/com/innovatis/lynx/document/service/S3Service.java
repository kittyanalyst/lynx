package com.innovatis.lynx.document.service;

import com.innovatis.lynx.document.service.dto.DocumentDto;

/**
 * Created by Ramakrishna Chalasani on 02/14/2017.
 */
public interface S3Service {

      void uploadDocument(DocumentDto documentDto);
}
