package covid.tracker.stats;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
// import org.springframework.web.servlet.resource.HttpResource;

// import ch.qos.logback.core.net.server.Client;
// import covid.tracker.models.LocationStats;

@Service
public class coronaVirusDataServices {
    private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationStats> allStats = new ArrayList<>();
    public List<LocationStats> getAllStats() {
        return allStats;
    } 
    
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException{
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(VIRUS_DATA_URL))
            .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvbodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvbodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats ();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            locationStat.setLatestTotalCases(record.get(record.size()- 1));
            System.out.println(locationStat);
            newStats.add(locationStat);
        }
        this.allStats=newStats;
}



    }

    
