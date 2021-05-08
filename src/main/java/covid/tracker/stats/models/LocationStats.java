package covid.tracker.stats.models;

public class LocationStats {
    
    private String country;
    private String state;
    private int latestTotalCases;
    private int diffFromPrevDay;
    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }
    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getState() {
        return state;
    }
    @Override
    public String toString() {
        return "LocationStats [country=" + country + ", state=" + state +",  latestTotalCases=" + latestTotalCases +  "]";
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getLatestTotalCases() {
        return latestTotalCases;
    }
    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }
    


}
