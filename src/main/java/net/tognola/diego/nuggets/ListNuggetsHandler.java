package net.tognola.diego.nuggets;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ListNuggetsHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        try {
            List<Nugget> nuggets = new Nugget().list();
            return ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setObjectBody(nuggets)
                    .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & Serverless"))
                    .build();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
