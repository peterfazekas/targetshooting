package eu.nsjg.targetshooting.model.service.parse;

import java.util.ArrayList;
import java.util.List;

import eu.nsjg.targetshooting.model.domain.Competitor;

public class DataParser {
	
	private final PointCalculator pointCalculator;
	
	public DataParser(final PointCalculator pointCalculator) {
		this.pointCalculator = pointCalculator;
	}

	public List<Competitor> parser(final List<String> lines) {
		lines.remove(0);
		List<Competitor> competitors = new ArrayList<>();
		int id = 0;
		for (String line : lines) {
			competitors.add(createCompetitor(++id, line));
		}
		return competitors;
	}
	
	private Competitor createCompetitor(final int id, final String line) {
		return new Competitor(id, line, pointCalculator.loErtek(line));
	}
}
