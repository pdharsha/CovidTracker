package covid.tracker.stats.models;

public class LocationStats {
    
    private String country;
    private String state;
    private String latestTotalCases;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getLatestTotalCases() {
        return latestTotalCases;
    }
    public void setLatestTotalCases(String latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }


}
