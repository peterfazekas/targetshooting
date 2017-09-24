package eu.nsjg.targetshooting.controller.service;import java.util.Comparator;

import eu.nsjg.targetshooting.model.domain.Competitor;

public class PointComparator implements Comparator<Competitor>{

	@Override
	public int compare(Competitor o1, Competitor o2) {
		return o2.getPoint().compareTo(o1.getPoint());
	}

}
