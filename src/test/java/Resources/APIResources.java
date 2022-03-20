package Resources;

public enum APIResources {
    addPlaceAPI("/maps/api/place/add/json"),
    updatePlaceAPI("/maps/api/place/update/json"),
    deletePlaceAPI("/maps/api/place/delete/json"),
    getPlaceAPI("/maps/api/place/get/json");

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
