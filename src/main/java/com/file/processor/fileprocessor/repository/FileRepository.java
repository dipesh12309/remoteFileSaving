package com.file.processor.fileprocessor.repository;

import com.file.processor.fileprocessor.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
}
