//import de.viadee.bpm.vPAV.ProcessApplicationValidator;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertTrue;
//
//@RunWith(SpringRunner.class)
////@ContextConfiguration(classes = { SpringTestConfig.class })
//public class ModelConsistencyTest{
//
//    @Autowired
//    private ApplicationContext ctx;
//
//    @Test
//    public void validateModel() {
//        assertTrue("Model inconsistency found. Please check target folder for validation output",
//                ProcessApplicationValidator.findModelInconsistencies(ctx).isEmpty());
//    }
//}
//
