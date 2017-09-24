package eu.nsjg.targetshooting.controller.service;

import java.util.ArrayList;
import java.util.List;

import eu.nsjg.targetshooting.model.domain.Competitor;
import eu.nsjg.targetshooting.model.domain.Result;

public class FinalResult {

	private final List<Competitor> resultList;
	
	public FinalResult(final List<Competitor> resultList) {
		this.resultList = resultList;
	}

	public String getFinalResults() {
		StringBuilder sb = new StringBuilder();
		for (Result result : createFinalResults()) {
			sb.append(result.toString());
		}
		return sb.toString();
	}
	
	private List<Result> createFinalResults() {
		List<Result> finalResults = new ArrayList<>();
		resultList.sort(new PointComparator());
		int rank = 1, oldRank = 1;
		int index = 1, oldPoint = 0;
		for (Competitor competitor : resultList) {
			rank = competitor.getPoint() == oldPoint ? oldRank : index;
			index++;
			oldRank = rank;
			oldPoint = competitor.getPoint();
			finalResults.add(createResult(rank, competitor));
		}
		return finalResults;
	}

	private Result createResult(int rank, Competitor competitor) {
		return new Result(rank, competitor.getId(), competitor.getPoint());
	}	
}
