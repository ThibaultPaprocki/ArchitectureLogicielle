package apaprocki.cc2;

import apaprocki.cc2.domain.services.MembershipService;
import apaprocki.cc2.domain.services.PaymentService;
import apaprocki.cc2.domain.services.SubscriptionService;
import apaprocki.cc2.domain.services.UserService;
import apaprocki.cc2.infra.defaultRepositoryImpl.InMemoryPaymentRepository;
import apaprocki.cc2.infra.defaultRepositoryImpl.InMemorySubscriptionContractRepository;
import apaprocki.cc2.infra.defaultRepositoryImpl.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {

    @Bean
    public UserService userService() {
        return new UserService(new InMemoryUserRepository());
    }

    @Bean
    public SubscriptionService subscriptionService() {
        return new SubscriptionService(new InMemorySubscriptionContractRepository());
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(new InMemoryPaymentRepository());
    }

    @Bean
    public MembershipService membershipService(){
        return new MembershipService(paymentService(),userService(),new InMemorySubscriptionContractRepository());
    }
}