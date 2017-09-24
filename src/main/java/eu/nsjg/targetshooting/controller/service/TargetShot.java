package eu.nsjg.targetshooting.controller.service;

import java.util.List;

import eu.nsjg.targetshooting.model.domain.Competitor;

public class TargetShot {

	private static final String SPACE = " ";

	private final List<Competitor> resultList;

	public TargetShot(final List<Competitor> resultList) {
		this.resultList = resultList;
	}

	public String getSuccesfulCompetitors() {
		StringBuilder sb = new StringBuilder();
		for (Competitor shot : resultList) {
			CompetitorService service = new CompetitorService(shot);
			if (service.hasMoreSuccessful())
				sb.append(shot.getId()).append(SPACE);
		}
		return sb.toString();
	}

	public String getMostShotCountCompetitorId() {
		StringBuilder sb = new StringBuilder();
		for (Competitor shot : resultList) {
			if (shotCount(shot) == getMostShotCount()) {
				sb.append(shot.getId()).append(SPACE);
			}
		}
		return sb.toString();
	}

	public Competitor getCompetitorById(final int id) {
		int i = -1;
		while (resultList.get(++i).getId() != id);
		return resultList.get(i);
	}

	private int getMostShotCount() {
		int count = 0;
		for (Competitor shot : resultList) {
			if (shotCount(shot) > count) {
				count = shotCount(shot);
			}
		}
		return count;
	}

	private int shotCount(Competitor shot) {
		return shot.getResult().length();
	}
}
