package com.file.processor.fileprocessor.service;

import com.file.processor.fileprocessor.model.FileEntity;
import com.file.processor.fileprocessor.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageService {
    private final Logger logger = LoggerFactory.getLogger(FileStorageService.class);
    @Value("${file.upload.path}")
    private String filePath;
    @Autowired
    private FileRepository fileRepository;

    public void uploadFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setContentType(file.getContentType());
        fileEntity.setSize(file.getSize());
        fileEntity.setFile(file.getBytes());
        this.fileRepository.save(fileEntity);
    }

    public void downloadFile(Long fileId) throws IOException {
        Optional<FileEntity> fileEntity =this.fileRepository.findById(fileId);
        //save this file entity to the any location
        byte[] file = fileEntity.get().getFile();
        // Open output stream to write to the destination file
        File newFile = new File("image.jpeg");
        if(newFile.exists())
        {
            newFile.delete();
        }
        FileOutputStream outputStream = new FileOutputStream("image.jpeg");

        // Write the image data to the output stream
        outputStream.write(file);

        // Close the output stream
        outputStream.close();
    }
}
