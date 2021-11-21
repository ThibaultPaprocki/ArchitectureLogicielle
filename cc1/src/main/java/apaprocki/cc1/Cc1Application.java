package apaprocki.cc1;

import apaprocki.cc1.models.*;
import apaprocki.cc1.repositories.PaymentRepository;
import apaprocki.cc1.repositories.UserRepository;
import apaprocki.cc1.services.MembershipService;
import apaprocki.cc1.services.PaymentService;
import apaprocki.cc1.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Cc1Application {

	public static void main(String[] args) {
		//ADD SERVICES

		UserService userService = new UserService(new UserRepository());
		PaymentService paymentService= new PaymentService(new PaymentRepository());
		MembershipService membershipService = new MembershipService(paymentService,userService);

		//TEST UserService
		BillingInformations billingInformationsLudo = BillingInformations.of("Ludo Ludo", LocalDateTime.now().plusYears(2),14142484,007);
		MemberStatus memberStatusLudo = MemberStatus.of(MemberType.Contractor,SubscriptionContract.of(3,300));
;		User userAlex = User.of(1,"paprocki","alex","username1","password1");
		Member memberLudo = Member.of(User.of(2,"Ludo","ludo","user1","pass1"),billingInformationsLudo,memberStatusLudo);
		userService.addUser(userAlex);
		System.out.println(userAlex);
		System.out.println(userService.getUserById(1));

		userService.addUser(memberLudo);
		System.out.println(memberLudo);
		System.out.println(userService.getUserById(2));

		//TEST
		BillingInformations billingInformationsAlex = BillingInformations.of("Alex", LocalDateTime.now().plusYears(2),14142484,007);

		Payment payment = Payment.of(1,userAlex,LocalDateTime.now(),300);
		SubscriptionContract newContract = SubscriptionContract.of(4,300);
		membershipService.applyToContract(payment,billingInformationsAlex,newContract);

		System.out.println(userService.getUserById(1));
//		SpringApplication.run(Cc1Application.class, args);
	}
}
