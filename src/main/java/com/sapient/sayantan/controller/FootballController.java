package com.sapient.sayantan.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.sayantan.footballApi.FootBallApiCall;
import com.sapient.sayantan.jsonModel.League;
import com.sapient.sayantan.model.CountryOutput;
import com.sapient.sayantan.model.LeagueOutput;
import com.sapient.sayantan.model.Output;
import com.sapient.sayantan.model.TeamOutput;

@RestController
public class FootballController {	
	
	@RequestMapping(value="/reqTrace", method = RequestMethod.GET, headers="Accept=application/json")
	public String getCountry(@RequestParam String cid, @RequestParam String lid, @RequestParam String tid) {	
		
		FootBallApiCall foot = new FootBallApiCall();
		/*Country[] coun = foot.getCountry().getBody();
		List<Country> country = Arrays.asList(coun);*/
		
		League[] league = foot.getLeagues(lid).getBody();
		List<League> leagueList = Arrays.asList(league);
		
		Iterator<League> itLeague = leagueList.iterator();
		while (itLeague.hasNext()) {
			League le = itLeague.next();
			if(le.getTeamId().equals(tid)) {
				Output o = new Output();
				TeamOutput tO = new TeamOutput();
				LeagueOutput oO = new LeagueOutput();
				CountryOutput cO = new CountryOutput();
				tO.setTeamId(tid);
				tO.setTeamName(le.getTeamName());
				cO.setCountryId(cid);
				cO.setCountryName(le.getCountryName());
				oO.setLeagueId(le.getLeagueId());
				oO.setLeagueName(le.getLeagueName());
				o.setcOut(cO);
				o.setlOut(oO);
				o.settOut(tO);
				o.setLeagueStanding(le.getOverallLeaguePosition());
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					return objectMapper.writeValueAsString(o);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return "error";
	}
}
