package com.file.processor.fileprocessor.service;

import com.file.processor.fileprocessor.model.FileUser;
import com.file.processor.fileprocessor.repository.FileUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FileUserService implements UserDetailsService {
    private final FileUserRepository fileUserRepository;
    private final PasswordEncoder passwordEncoder;
    public FileUserService(FileUserRepository fileUserRepository, PasswordEncoder passwordEncoder) {
        this.fileUserRepository = fileUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FileUser fileUser = this.fileUserRepository.findByUserName(username);
        String encodedPassword = passwordEncoder.encode(fileUser.getPassWord());
        return User.withUsername(fileUser.getUserName())
                .password(encodedPassword)
                .accountExpired(false)
                .accountExpired(false)
                .build();
    }
}
