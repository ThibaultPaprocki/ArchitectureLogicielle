package apaprocki.cc2.exposition.controllers;


import apaprocki.cc2.domain.models.*;
import apaprocki.cc2.domain.services.MembershipService;
import apaprocki.cc2.domain.services.SubscriptionService;
import apaprocki.cc2.exposition.models.BillingInformationsDTO;
import apaprocki.cc2.exposition.models.SubscriptionContractDTO;
import apaprocki.cc2.infra.exceptions.*;
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
@RequestMapping("contract")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final MembershipService membershipService;

    public SubscriptionController(SubscriptionService subscriptionService, MembershipService membershipService) {
        this.subscriptionService = subscriptionService;
        this.membershipService = membershipService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SubscriptionContract> getById(@RequestParam(name = "id") int id) {
        final SubscriptionContract subscriptionResponseResult = this.subscriptionService.getContractById(Id.of(id));
        return ResponseEntity.ok(subscriptionResponseResult);
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SubscriptionContract>> getAll() {
        final List<SubscriptionContract> contractsResponseResult = this.subscriptionService.getAll();
        return ResponseEntity.ok(contractsResponseResult);
    }

    @PostMapping(value = "/apply", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionContract> applyForMembership(@RequestBody @Valid Payment payment, @RequestBody @Valid BillingInformationsDTO billingInformations, @RequestBody @Valid SubscriptionContractDTO subscriptionContractDTO) {
        this.membershipService.applyToContract(payment,billingInformations,subscriptionContractDTO);
        return ResponseEntity.ok().build();
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidUserException.class)
    public String handleInvalidUserException(
            InvalidUserException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoBillingInformationsException.class)
    public String handleNoSuchBillingIformationException(
            NoBillingInformationsException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotMemberException.class)
    public String handleNotMemberException(
            NotMemberException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    @ExceptionHandler(PaymentException.class)
    public String handlePaymentErrorException(
            PaymentException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidContractDurationException.class)
    public String handleInvalidMembershipDurationException(
            InvalidContractDurationException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    @ExceptionHandler(NegativePriceException.class)
    public String handleNegativePriceException(
            NegativePriceException ex) {
        return ex.getMessage();
    }
}
