package eu.nsjg.targetshooting.model.service.parse;

public class PointCalculator {

	public Integer loErtek(final String sor) {
		int aktPont = 20;
		int ertek = 0;
		for (int i = 0; i < sor.length(); i++) {
			if (aktPont > 0 && sor.charAt(i)=='-') {
				aktPont--;
			} else {
				ertek += aktPont;
			}
		}
		return ertek;
	}
	
}
