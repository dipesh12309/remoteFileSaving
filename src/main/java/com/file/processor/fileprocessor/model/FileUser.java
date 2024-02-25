package com.file.processor.fileprocessor.model;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
public class FileUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    @Size(min = 8 , max = 255)
    private String passWord;
    private String role;

    public FileUser(Long userId, String userName, String passWord, String role) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public FileUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
