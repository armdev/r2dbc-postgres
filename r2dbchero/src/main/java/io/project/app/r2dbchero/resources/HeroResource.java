package io.project.app.r2dbchero.resources;

import io.project.app.r2dbchero.domain.User;
import io.project.app.r2dbchero.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/users")
public class HeroResource {

    @Autowired
    private UserService userService;

    @GetMapping
    @CrossOrigin
    public Flux<User> find() {
        return userService.findAll();
    }

    @GetMapping("/user")
    @CrossOrigin
    public Mono<User> get(@RequestParam(required = true, name = "id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    @CrossOrigin
    public Mono<User> post(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/user")
    @CrossOrigin
    public Mono<User> put(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/user")
    @CrossOrigin
    public Mono<Void> delete(@RequestParam(required = true, name = "id") Long id) {
        return userService.deleteById(id);
    }

}
