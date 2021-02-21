//import com.example.workflow.serviceDelegates.CreatePaymentApprovalGroupDelegate;
//import com.example.workflow.serviceDelegates.DetermineInitiatorGroups;
//import com.example.workflow.serviceDelegates.FirstSignOffDelegate;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringTestConfig {
//
//    public SpringTestConfig() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @InjectMocks
//    private CreatePaymentApprovalGroupDelegate createPaymentApprovalGroupDelegate;
//
//    @InjectMocks
//    private DetermineInitiatorGroups determineInitiatorGroups;
//
//    @InjectMocks
//    private FirstSignOffDelegate firstSignOffDelegate;
//
//    @Bean
//    public CreatePaymentApprovalGroupDelegate createPaymentApprovalGroupDelegate() {
//        return createPaymentApprovalGroupDelegate;
//    }
//
//    @Bean
//    public DetermineInitiatorGroups determineInitiatorGroups() {
//        return determineInitiatorGroups;
//    }
//
//    @Bean
//    public FirstSignOffDelegate firstSignOffDelegate() {
//        return firstSignOffDelegate;
//    }
//
//}