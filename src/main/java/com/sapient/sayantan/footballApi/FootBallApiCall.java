package com.sapient.sayantan.footballApi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sapient.sayantan.jsonModel.Country;
import com.sapient.sayantan.jsonModel.League;

public class FootBallApiCall {

	public ResponseEntity<Country[]> getCountry() {

		String url = "https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity = new HttpEntity(httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Country[]> country = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Country[].class);
		return country;

	}

	public ResponseEntity<League[]> getLeagues(String lid) {

		String url = "https://apiv2.apifootball.com/?action=get_standings&league_id="+lid+"&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity = new HttpEntity(httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<League[]> leagues = restTemplate.exchange(url, HttpMethod.GET, requestEntity, League[].class);
		return leagues;

	}

}
