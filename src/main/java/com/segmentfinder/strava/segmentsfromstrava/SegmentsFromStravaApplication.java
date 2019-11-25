package com.segmentfinder.strava.segmentsfromstrava;

import com.segmentfinder.strava.segmentsfromstrava.client.StravaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SegmentsFromStravaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SegmentsFromStravaApplication.class, args);

	}

	@Bean
	public StravaClient getStravaClient() {return new StravaClient(); }

}
