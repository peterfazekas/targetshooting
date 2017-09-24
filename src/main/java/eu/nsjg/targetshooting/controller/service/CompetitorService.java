package eu.nsjg.targetshooting.controller.service;

import eu.nsjg.targetshooting.model.domain.Competitor;

public class CompetitorService {

	private static final String SUCESSFUL_SHOTS = "++";
	private static final char SUCESSFUL_SHOT = '+';
	private static final String UNSUCESSFUL_SHOT = "-";
	private static final String SPACE = " ";

	private final Competitor competitor;

	public CompetitorService(final Competitor shot) {
		this.competitor = shot;
	}

	public int getPoint() {
		return competitor.getPoint();
	}
	
	public boolean isSuccessful(final int index) {
		return getResult().charAt(index) == SUCESSFUL_SHOT;
	}
	
	public boolean hasMoreSuccessful() {
		return getResult().indexOf(SUCESSFUL_SHOTS) > 0;
	}


	public int getSuccessfulShotCount() {
		int count = 0;
		for (int i = 0; i < shotCount(); i++) {
			if (isSuccessful(i))
				count++;
		}
		return count;
	}

	public String getSuccessfulShot() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < shotCount(); i++) {
			if (isSuccessful(i))
				sb.append(i + 1).append(SPACE);
		}
		return sb.toString();
	}
	
	public int getLongetstSuccessfulShotFlow() {
		int count = 0, longest = 0;
		for (int i = 0; i < shotCount(); i++) {
			if (isSuccessful(i)) {
				count++;
			} else {
				if(count > longest)
					longest = count;
				count = 0;
			}
		}
		return longest;
	}

	public int getLongetstSuccessfulShotFlow2() {
		int longest = 0;
		String[] results = getResult().split(UNSUCESSFUL_SHOT);
		for (String result : results) {
			if (result.length() > longest) 
				longest = result.length();
		}
		return longest;
	}

	
	private String getResult() {
		return competitor.getResult();
	}
	
	private int shotCount() {
		return getResult().length();
	}
}
