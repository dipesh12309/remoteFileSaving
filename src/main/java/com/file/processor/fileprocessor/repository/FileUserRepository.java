package com.file.processor.fileprocessor.repository;

import com.file.processor.fileprocessor.model.FileUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUserRepository extends JpaRepository<FileUser,Long> {
    public FileUser findByUserName(String userName);
}
