package cz.mendelu.proj1actual;

public class Countries {
    private String capital;
    private String id;
    private double lng;
    private double lat;

    public Countries(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public double getLng(){
        return lng;
    }

    public double getLat(){
        return lat;
    }
    /*
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return capital;
    }
    public void setName(String capital) {
        this.capital = capital;
    }
*/
    /*
    public double getlat(){
        return lat;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public double getlng(){
        return lng;
    }
    public void setLng(double lng){
        this.lng = lng;
    }
    */
}
