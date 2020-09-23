package ProviderTest;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
@Provider("Our Provider")
public class PaymentTest {

    @State("Get payment detail on the basis of paymentId")
    public void Test(){
        System.out.println("Mayur");
    }

    @TestTarget
    public final Target target = new HttpTarget();
}
