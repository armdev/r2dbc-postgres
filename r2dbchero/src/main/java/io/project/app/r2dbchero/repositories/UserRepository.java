/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.r2dbchero.repositories;

import io.project.app.r2dbchero.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author armena
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
