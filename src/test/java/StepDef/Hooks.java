package StepDef;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        GoogleMapSteps sd = new GoogleMapSteps();
        if (sd.placeID == null) {
            sd.having_a_payload_with("House", "123 Parkway", "French");
            sd.user_calls_api_with_http_request("addPlaceAPI", "Post");
            sd.verify_place_id_created_maps_to_using("House", "getPlaceAPI");
        }
    }
}
