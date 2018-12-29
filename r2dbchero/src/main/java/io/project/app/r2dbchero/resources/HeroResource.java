package io.project.app.r2dbchero.resources;

import io.project.app.r2dbchero.domain.User;
import io.project.app.r2dbchero.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.http.ResponseEntity;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

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

    @GetMapping("/user/person/id")
    public Mono<ResponseEntity<User>> load(@RequestParam(required = true, name = "id") Long id) {
        return userService.findById(id)
                .map(savedTweet -> ResponseEntity.ok(savedTweet))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    
    // https://github.com/callicoder/spring-webflux-reactive-rest-api-demo/blob/master/src/main/java/com/example/webfluxdemo/controller/TweetController.java

}
