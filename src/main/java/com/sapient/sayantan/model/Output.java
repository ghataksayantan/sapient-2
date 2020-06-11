package com.sapient.sayantan.model;

public class Output {
	
	public CountryOutput cOut;
	public LeagueOutput lOut;
	public TeamOutput tOut;
	public String leagueStanding;
	public CountryOutput getcOut() {
		return cOut;
	}
	public void setcOut(CountryOutput cOut) {
		this.cOut = cOut;
	}
	public LeagueOutput getlOut() {
		return lOut;
	}
	public void setlOut(LeagueOutput lOut) {
		this.lOut = lOut;
	}
	public TeamOutput gettOut() {
		return tOut;
	}
	public void settOut(TeamOutput tOut) {
		this.tOut = tOut;
	}
	public String getLeagueStanding() {
		return leagueStanding;
	}
	public void setLeagueStanding(String leagueStanding) {
		this.leagueStanding = leagueStanding;
	}
	

}
