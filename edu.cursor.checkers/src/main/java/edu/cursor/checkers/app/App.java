package edu.cursor.checkers.app;

import servise.DoSomethingInGame;
import servise.PlayerBlack;
import servise.PlayerWhite;
import servise.SystemOut;

/**
 * Checkers game in consoles b - chess Black; qb - queen Black w - chess White;
 * qw - queen White
 * 
 * game is based on two dimensional array
 *
 * @author Yura Hilevich
 * @version 1.1
 */

public class App {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("b - chess Black; qb - queen Black");
		System.out.println("w - chess White; qw - queen White");

		PlayerBlack pb = new PlayerBlack();
		PlayerWhite pw = new PlayerWhite();

		SystemOut so = new SystemOut();
		DoSomethingInGame dsig = new DoSomethingInGame();
		so.newField(dsig.getFildChess());

		// end game condition
		while ((dsig.getNumberOfChessBlack() != 0) || (dsig.getNumberOfChessWhite() != 0)) {

			Thread r1 = new Thread(pw);
			Thread r2 = new Thread(pb);
			r1.start();
			r1.join();
			so.newField(dsig.getFildChess());
			r2.start();
			r2.join();
			so.newField(dsig.getFildChess());

			System.out.println(dsig.getNumberOfChessBlack());
			System.out.println(dsig.getNumberOfChessWhite());

		}

		// who win in game
		if (dsig.getNumberOfChessBlack() == 0) {
			System.out.println("win white");
		} else {
			System.out.println("win black");
		}
	}
}
