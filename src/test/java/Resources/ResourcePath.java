package Resources;

public class ResourcePath {
    private String addPlaceAPI = "/maps/api/place/add/json";
    private String updatePlaceAPI = "/maps/api/place/update/json";
    private String deletePlaceAPI = "/maps/api/place/delete/json";

    public String getAddPlaceAPI() {
        return addPlaceAPI;
    }

    public String getUpdatePlaceAPI() {
        return updatePlaceAPI;
    }

    public String getDeletePlaceAPI() {
        return deletePlaceAPI;
    }
}
