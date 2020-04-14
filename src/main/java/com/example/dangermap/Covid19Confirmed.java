package com.example.dangermap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;

@Service
public class Covid19Confirmed {

    public static final String LINK ="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private DataRepo dataRepo;

    public Covid19Confirmed(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(LINK, String.class);

        StringReader stringReader = new StringReader(forObject);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);


        for (CSVRecord strings : parser) {
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            String month = String.valueOf(LocalDate.now().getMonthValue());
            String day = String.valueOf(LocalDate.now().getDayOfMonth()-1);
            String year = String.valueOf(LocalDate.now().getYear()-2000);
            String text = strings.get(month+"/"+day+"/"+year);
            System.out.println(text);
            String country = strings.get("Country/Region");
            if (Integer.parseInt(text)==0){continue;}
            dataRepo.addPoint(new Point(lat,lon,text,country));
        }
    }
}
