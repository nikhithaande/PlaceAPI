package Resources;

import Utils.GoogleMapPojo;
import Utils.LocationPojo;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public GoogleMapPojo addPlacePayload(String name, String address, String language){
        LocationPojo l = new LocationPojo();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        List<String> myList = new ArrayList<>();
        myList.add("pink");
        myList.add("blue");

        GoogleMapPojo p = new GoogleMapPojo(l, 50, name, "(+91) 123 456 6789", address, myList, "http://google.com", language);

        return p;
    }

    public String deletePayLoad(String place_id){
        return "{\r\n\"place_id\":\"" +place_id + "\"\r\n}";
    }
}
