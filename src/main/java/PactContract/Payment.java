package PactContract;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.jayway.restassured.response.Response;
import org.example.App;
import org.junit.Rule;
import org.junit.Test;

public class Payment {

    @Rule
    public PactProviderRule provider = new PactProviderRule("Payment","localhost",8080, this);

    @Pact(provider = "Payment", consumer = "Merchant")
    public RequestResponsePact PactTest(PactDslWithProvider builder){
        String body ="{\"id\":\"pay_FaR900Ynf4igc2\",\"entity\":\"payment\",\"amount\":1000,\"currency\":\"INR\",\"status\":\"refunded\",\"order_id\":\"order_FaR8zOFuw0nRWP\",\"invoice_id\":null,\"international\":false,\"method\":\"card\",\"amount_refunded\":1000,\"refund_status\":\"full\",\"captured\":true,\"description\":null,\"card_id\":\"card_FaR1TzwzUpMLAD\",\"bank\":null,\"wallet\":null,\"vpa\":null,\"email\":\"a.b@c.com\",\"contact\":\"+919123456789\",\"notes\":[],\"fee\":20,\"tax\":0,\"error_code\":null,\"error_description\":null,\"error_source\":null,\"error_step\":null,\"error_reason\":null,\"acquirer_data\":{\"auth_code\":\"362232\"},\"created_at\":1615026536}";
        return builder
                .given("Get payment detail on the basis of paymentId")
                .uponReceiving("a request for payment detail")
                .path("payments/pay_FaR900Ynf4igc2")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(body)
                .toPact();
    }

    @Test
    @PactVerification(fragment = "PactTest")
    public void consumerTest(){
        System.setProperty("pact.rootDir", "../pacts");
        Response response = App.getPaymentDetails(provider.getUrl());
        System.out.println(response.getBody().asString());
    }

}
