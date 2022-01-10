package apaprocki.cc2.exposition.controllers;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.User;
import apaprocki.cc2.domain.services.UserService;
import apaprocki.cc2.exposition.models.UserDTO;
import apaprocki.cc2.infra.exceptions.NoSuchEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getById(@RequestParam(name = "id") int id) {
        final User userResponseResult =this.userService.getUserById(Id.of(id));
        return ResponseEntity.ok(userResponseResult);
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAll() {
        final List<User> usersResponseResult = this.userService.getAll();
        return ResponseEntity.ok(usersResponseResult);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO request) {
       final User userResponseResult = userService.addUser(request);
        return ResponseEntity.ok(userResponseResult);
    }

    @PatchMapping(value = "/username", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> changeUsername(@RequestBody @Valid UserDTO request) {
        final User userResponseResult = this.userService.changeUsername(Id.of(request.id), request.username);
        return ResponseEntity.ok(userResponseResult);
    }

    @PatchMapping(value = "/password", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> changePassword(@RequestBody @Valid UserDTO request) {
        final User userResponseResult =this.userService.changePassword(Id.of(request.id), request.password);
        return ResponseEntity.ok(userResponseResult);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchEntityException.class)
    public String handleEntityExceptions(
            NoSuchEntityException ex) {
        return ex.getMessage();
    }
}