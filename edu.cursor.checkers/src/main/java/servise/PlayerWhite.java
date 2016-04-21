package servise;

/**
 * Class PlayerWhite implements for interface Runnable and have one method run
 * 
 * @author Yura hilevich
 * @version 1.1
 */

public class PlayerWhite implements Runnable {

	/**
	 * This method make one step only white Checkers
	 * 
	 *
	 */
	public void run() {

		System.out.println(" Player One(White)");
		DoSomethingInGame dsb = new DoSomethingInGame();

		int getChess = 0;
		System.out.println("select shape  ");
		do {

			getChess = dsb.getCheked();

			if (dsb.getInScopeForWhite(getChess)) {
				System.out.println("incorrect input try again");
			}

		} while (dsb.getInScopeForWhite(getChess));
		System.out.println("make your course");

		if (dsb.getChessType(getChess)) {
			// chess

			dsb.getPositionForOnlyChess(getChess);
			dsb.changeOnQueen();

		} else {
			// queen

			dsb.getPositionForOnlyQueen(getChess);
		}

	}
}
