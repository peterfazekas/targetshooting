package eu.nsjg.targetshooting.view;

import eu.nsjg.targetshooting.controller.service.CompetitorService;
import eu.nsjg.targetshooting.controller.service.FinalResult;
import eu.nsjg.targetshooting.controller.service.TargetShot;
import eu.nsjg.targetshooting.model.domain.Competitor;

import java.util.List;
import java.util.Scanner;

import eu.nsjg.targetshooting.controller.console.Console;
import eu.nsjg.targetshooting.model.service.log.DataLogger;
import eu.nsjg.targetshooting.model.service.log.FileDataLogger;
import eu.nsjg.targetshooting.model.service.parse.DataParser;
import eu.nsjg.targetshooting.model.service.parse.PointCalculator;
import eu.nsjg.targetshooting.model.service.read.DataReader;
import eu.nsjg.targetshooting.model.service.read.FileDataReader;

public class App {

	private final DataReader file;
	private final DataParser data;
	private final Console console;
	private final TargetShot targetShooting;
	private final DataLogger log;
	private final List<Competitor> competitors;

	public App() {
		file = new FileDataReader("verseny.txt");
		data = new DataParser(new PointCalculator());
		console = new Console(new Scanner(System.in));
		competitors = data.parser(file.read());
		targetShooting = new TargetShot(competitors);
		log = new FileDataLogger("eredmeny.txt");
	}

	public static void main(String[] args) {
		App app = new App();
		app.print();
	}

	private void print() {
		System.out.println("2. feladat: Az egymást követõen többször találó versenyzõk: "
				+ targetShooting.getSuccesfulCompetitors());
		System.out.println("3. feladat: A legtöbb lövést leadó versenyzó rajtszáma:"
				+ targetShooting.getMostShotCountCompetitorId());
		System.out.print("5. feladat: Adjon meg egy rajtszámot: ");
		int id = console.reatInt();
		CompetitorService competitor = getCompatitor(id);
		System.out.println("5.a. Célt érõ lövések: " + competitor.getSuccessfulShot());
		System.out.println("5.b. Az eltalált korongok száma: " + competitor.getSuccessfulShotCount());
		System.out.println("5.c. A leghosszabb hibátlan sorozat hossza: " + competitor.getLongetstSuccessfulShotFlow2());
		System.out.println("5.d. A versenyzõ pontszáma: " + competitor.getPoint());
		getFinalResult();
	}

	private CompetitorService getCompatitor(final int id) {
		Competitor competitor = targetShooting.getCompetitorById(id);
		return new CompetitorService(competitor);
	}
	
	private void getFinalResult() {
		FinalResult resultList = new FinalResult(competitors);
		log.printAll(resultList.getFinalResults());
	}
}
