package com.file.processor.fileprocessor.controller;

import com.file.processor.file_processor.api.DownloadApi;
import com.file.processor.fileprocessor.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileDownloadController implements DownloadApi {
    @Autowired
    private FileStorageService fileStorageService;
    private final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);

    @Override
    public ResponseEntity<Resource> downloadFile(Long fileId) {
        try {
            this.fileStorageService.downloadFile(fileId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IOException exception){
            logger.info("unable to download file");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
