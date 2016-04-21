package servise;

/**
 * Write information in console
 *
 * @author Yura hilevich
 * @version 1.1
 */

public class SystemOut {

	/**
	 * Write array in console builds field for game
	 * 
	 * @param [][]
	 *            fildChess The color of the new Piece
	 *
	 */
	public void newField(int[][] fildChess) {
		System.out.println("    a     b    c    d    e    f    g    j");
		System.out.println("   ____ ____ ____ ____ ____ ____ ____ ____");
		for (int i = 0; i < 8; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < 8; j++) {
				switch (fildChess[i][j]) {
				case 0: {
					System.out.print(" | " + "  ");
					break;
				}
				case 1: {
					System.out.print(" | " + "b ");
					break;
				}
				case 2: {
					System.out.print(" | " + "w ");
					break;
				}
				case 10: {
					System.out.print(" | " + "  ");
					break;
				}
				case 3: {
					System.out.print(" | " + "qb");
					break;
				}
				case 4: {
					System.out.print(" | " + "qw");
					break;
				}
				}
			}
			System.out.println(" |");
			System.out.println("   ____ ____ ____ ____ ____ ____ ____ ____");
		}
	}

}
