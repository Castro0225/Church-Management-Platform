package com.churchflow.backend.service;

import com.churchflow.backend.entity.Church;
import com.churchflow.backend.entity.User;
import com.churchflow.backend.repository.ChurchRepository;
import com.churchflow.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ChurchRepository churchRepository;

    public UserService(UserRepository userRepository, ChurchRepository churchRepository) {
        this.userRepository = userRepository;
        this.churchRepository = churchRepository;
    }

    public User create(User user) {

        // 1️⃣ Verifica se email já existe
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado: " + user.getEmail());
        }

        // 2️⃣ Verifica se a church existe (caso venha no JSON)
        if (user.getChurch() != null && user.getChurch().getId() != null) {

            Church church = churchRepository.findById(user.getChurch().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Church não encontrada com id: " + user.getChurch().getId()));

            user.setChurch(church);
        }

        // 3️⃣ Salva usuário
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}