package eu.nsjg.targetshooting.model.domain;

public class Competitor {

	private final int id;
	private final String result;
	private final Integer point;
	
	public Competitor(final int id, final String result, final Integer point) {
		this.id = id;
		this.result = result;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public String getResult() {
		return result;
	}

	public Integer getPoint() {
		return point;
	}
	
	
	
}
