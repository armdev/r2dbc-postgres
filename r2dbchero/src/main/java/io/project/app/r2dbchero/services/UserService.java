/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.r2dbchero.services;

import io.project.app.r2dbchero.domain.User;
import io.project.app.r2dbchero.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> update(User user) {

        if (user.getId() == null) {
            log.error("For user update Id must be passed");
            return Mono.just(user);
        }
        Mono<User> currentUser = this.findById(user.getId());

        if (currentUser == null) {
            log.error("Could not find user with given id");
            return Mono.just(user);
        }

        return userRepository.save(user);
    }

    public Mono<User> save(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return userRepository.deleteById(id);
    }

}
