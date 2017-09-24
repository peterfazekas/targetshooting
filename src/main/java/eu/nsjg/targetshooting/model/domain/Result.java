package eu.nsjg.targetshooting.model.domain;

public class Result {

	private static final String NEW_LINE = "\r\n";
	private static final String TAB = "\t";

	private final int rank;
	private final int competitorId;
	private final Integer point;

	public Result(int rank, int competitorId, Integer point) {
		this.rank = rank;
		this.competitorId = competitorId;
		this.point = point;
	}

	@Override
	public String toString() {
		return rank + TAB + competitorId + TAB + point + NEW_LINE;
	}
	
	
	
}
