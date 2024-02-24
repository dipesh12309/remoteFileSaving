package com.file.processor.fileprocessor.controller;

import com.file.processor.file_processor.api.UploadApi;
import com.file.processor.fileprocessor.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController implements UploadApi {
    private final FileStorageService fileStorageService;
    private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Override
    public ResponseEntity<Void> uploadFile(MultipartFile file) {
        try {
            fileStorageService.uploadFile(file);
            return ResponseEntity.ok().build();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
