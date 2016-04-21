package servise;

import java.util.Scanner;

/**
 * Class DoSomethingInGame in this class building all methods in program
 *
 * @author Yura hilevich
 * @version 1.1
 * 
 */

public class DoSomethingInGame {
	/** The numberOfChessBlack how many Checkers are on board in Player Black */
	static int numberOfChessBlack = 12;
	/** The numberOfChessBlack how many Checkers are on board in Player White */
	static int numberOfChessWhite = 12;
	/** The array fildChess with this array building board 
	 * 
	 * @param  1 - black Checkers; 
	 * @param  2 - white Checkers;
	 * @param  3 - black Queen;
	 * @param  4 - white Queen;
	 * @param  0 - white field;
	 * @param  10 - black field;
	 * */
	static int[][] fildChess = { { 10, 1, 10, 1, 10, 1, 10, 1 }, { 1, 10, 1, 10, 1, 10, 1, 10 },
			{ 10, 1, 10, 1, 10, 1, 10, 1 }, { 0, 10, 0, 10, 0, 10, 0, 10 }, { 10, 0, 10, 0, 10, 0, 10, 0 },
			{ 2, 10, 2, 10, 2, 10, 2, 10 }, { 10, 2, 10, 2, 10, 2, 10, 2 }, { 2, 10, 2, 10, 2, 10, 2, 10 } };

	/**
	 * Getters for NumberOfChessBlack
	 * 
	 * @return numberOfChessBlack
	 */
	public int getNumberOfChessBlack() {
		return numberOfChessBlack;
	}

	/**
	 * Getters for NumberOfChessWhite
	 * 
	 * @return numberOfChessWhite
	 */
	public int getNumberOfChessWhite() {
		return numberOfChessWhite;
	}

	/**
	 * Getters for FildChess
	 * 
	 * @return fildChess
	 */
	public int[][] getFildChess() {
		return fildChess;
	}

	/**
	 * GetCheked this method get position on board what user choice
	 * 
	 * @return position
	 */

	public int getCheked() {
		boolean flag = true, flagIn = true;
		String str = null;
		int position = 0;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			str = sc.nextLine();
			System.out.println(str);
			if (str.length() == 2) {
				flagIn = true;

			} else {

				System.out.println("incorrect input try again");
				flagIn = false;
			}

			while (flagIn) {

				char[] arrayChar = str.toCharArray();
				for (int i = 0; i < arrayChar.length; i++) {
					if (i == 1) {
						position = position * 10;
						flagIn = false;
						flag = false;
					}
					switch (arrayChar[i]) {
					case '1': {
						position += 0;
						break;
					}
					case '2': {
						position += 1;
						break;
					}
					case '3': {
						position += 2;
						break;
					}
					case '4': {
						position += 3;
						break;
					}
					case '5': {
						position += 4;
						break;
					}
					case '6': {
						position += 5;
						break;
					}
					case '7': {
						position += 6;
						break;
					}
					case '8': {
						position += 7;
						break;
					}
					case 'a': {
						position += 0;
						break;
					}
					case 'b': {
						position += 1;
						break;
					}
					case 'c': {
						position += 2;
						break;
					}
					case 'd': {
						position += 3;
						break;
					}
					case 'e': {
						position += 4;
						break;
					}
					case 'f': {
						position += 5;
						break;
					}
					case 'g': {
						position += 6;
						break;
					}
					case 'j': {
						position += 7;
						break;
					}
					default: {
						flagIn = true;
						System.out.println("incorrect input try again");
						continue;
						// break;
					}
					}
				}
			}
		}
		return position;
	}

	/**
	 * This method get choice White Checkers
	 * 
	 * @return true or false
	 */

	public boolean getInScopeForWhite(int getChess) {
		if ((fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 2)
				|| (fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 4)) {
			return false;
		}
		return true;
	}

	/**
	 * This method get choice Black Checkers
	 * 
	 * @return true or false
	 */

	public boolean getInScopeBlack(int getChess) {
		if ((fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 1)
				|| (fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 3)) {
			return false;
		}
		return true;
	}

	/**
	 * This method get Vertical coordinates
	 * 
	 * @param position
	 * 
	 * @return getCoordinatesFirst
	 */

	public int getCoordinatesFirst(int position) {
		int getCoordinatesFirst = position / 10;
		return getCoordinatesFirst;
	}

	/**
	 * This method get Horizontal coordinates
	 * 
	 * @param position
	 * 
	 * @return getCoordinatesFirst
	 */

	public int getCoordinatesSecond(int position) {
		int getCoordinatesSecond = position % 10;
		return getCoordinatesSecond;
	}

	/**
	 * This method get vector of way for positionChess to course
	 * 
	 * @param positionChess
	 * @param course
	 * 
	 * @return true or false
	 */

	public boolean vector(int positionChess, int course) {

		int positionChessFirst, positionChessSecond, courseFirst, courseSecond;
		positionChessFirst = getCoordinatesFirst(positionChess);
		positionChessSecond = getCoordinatesSecond(positionChess);
		courseFirst = getCoordinatesFirst(course);
		courseSecond = getCoordinatesSecond(course);

		if (Math.abs(courseFirst - positionChessFirst) == Math.abs(courseSecond - positionChessSecond)) {

			return true;
		} else
			return false;
	}

	/**
	 * This method change Checkers on Queen
	 * 
	 */

	public void changeOnQueen() {
		for (int i = 0; i < 8; i++) {
			if (fildChess[7][i] == 1) {
				fildChess[7][i] = 3;
			}
			if (fildChess[0][i] == 2) {
				fildChess[0][i] = 4;
			}
		}

	}

	/**
	 * This method get type Checkers or Queen you choice
	 * 
	 * @param getChess
	 * 
	 * @return true or false
	 */

	public boolean getChessType(int getChess) {

		if ((fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 3)
				|| (fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 4)) {
			// false = queen
			return false;
		}

		return true;

	}

	/**
	 * This method get new position your Checker
	 * 
	 * @param getChess
	 * 
	 */

	public void getPositionForOnlyChess(int getChess) {
		boolean flag = true;
		// numbers of step
		int numberOfMoves = 0;

		while (flag) {
			int newPosition = getCheked();
			// if selected Checker Black and a true vector
			if ((fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 1)
					&& vector(getChess, newPosition)) {
				// if not attack our Checker or Queen
				if ((fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 1)
						|| (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 3)) {
					System.out.println("incorrect input try again");
					flag = true;
				}
				// check if new position void
				if (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 0) {
					// if position change to one do
					if ((getCoordinatesFirst(newPosition) - getCoordinatesFirst(getChess)) == 1) {
						flag = false;
						fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(
								newPosition)] = fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(
										getChess)];
						fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] = 0;
						numberOfMoves++;

					}
				}

				// if new position is void

				if (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 0) {
					// if difference between start position and finish position
					// is 2
					if ((Math.abs(getCoordinatesFirst(newPosition) - getCoordinatesFirst(getChess))) == 2) {
						int signVertical = (getCoordinatesFirst(newPosition) - getCoordinatesFirst(getChess))
								/ Math.abs(getCoordinatesFirst(getChess) - getCoordinatesFirst(newPosition));
						int signHorizontal = (getCoordinatesSecond(newPosition) - getCoordinatesSecond(getChess))
								/ Math.abs(getCoordinatesSecond(getChess) - getCoordinatesSecond(newPosition));
						// attack
						if ((fildChess[(getCoordinatesFirst(getChess) + signVertical)][(getCoordinatesSecond(getChess)
								+ signHorizontal)] == 2)
								|| (fildChess[(getCoordinatesFirst(getChess)
										+ signVertical)][(getCoordinatesSecond(getChess) + signHorizontal)] == 4)) {
							fildChess[(getCoordinatesFirst(getChess) + signVertical)][(getCoordinatesSecond(getChess)
									+ signHorizontal)] = 0;
							fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(
									newPosition)] = fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(
											getChess)];
							fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] = 0;
							numberOfChessWhite--;
							flag = false;
							numberOfMoves++;
						}

					}
				}
			}

			// if selected Checker White and a true vector
			if ((fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] == 2)
					&& vector(getChess, newPosition)) {
				// if not attack our Checker or Queen
				if ((fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 2)
						|| (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 4)) {
					System.out.println("incorrect input  try again");
					flag = true;
				}
				// check if new position void
				if (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 0) {
					// if position change to one do
					if ((getCoordinatesFirst(getChess) - getCoordinatesFirst(newPosition)) == 1) {
						fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(
								newPosition)] = fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(
										getChess)];
						fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] = 0;
						flag = false;
						numberOfMoves++;
					} else {

					}
				}
				// check if new position void
				if (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] == 0) {
					// if difference between start position and finish position
					// is 2
					if ((Math.abs(getCoordinatesFirst(newPosition) - getCoordinatesFirst(getChess))) == 2) {
						int signVertical = (getCoordinatesFirst(newPosition) - getCoordinatesFirst(getChess))
								/ Math.abs(getCoordinatesFirst(newPosition) - getCoordinatesFirst(getChess));
						int signHorizontal = (getCoordinatesSecond(newPosition) - getCoordinatesSecond(getChess))
								/ Math.abs(getCoordinatesSecond(newPosition) - getCoordinatesSecond(getChess));
						if ((fildChess[(getCoordinatesFirst(getChess) + signVertical)][(getCoordinatesSecond(getChess)
								+ signHorizontal)] == 1)
								|| (fildChess[(getCoordinatesFirst(getChess)
										+ signVertical)][(getCoordinatesSecond(getChess) + signHorizontal)] == 3)) {
							fildChess[(getCoordinatesFirst(getChess) + signVertical)][(getCoordinatesSecond(getChess)
									+ signHorizontal)] = 0;
							fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(
									newPosition)] = fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(
											getChess)];
							fildChess[getCoordinatesFirst(getChess)][getCoordinatesSecond(getChess)] = 0;
							flag = false;
							numberOfChessBlack--;
							numberOfMoves++;
						}
					}
				}

			}
			// if number Of Moves = we can change our Checker
			if (numberOfMoves == 0) {
				System.out.println("maybe you want to change chess 'y' - yes / other - no ");
				Scanner sc = new Scanner(System.in);

				if (sc.nextLine().contentEquals("y")) {
					System.out.println("enter new chess");
					getChess = getCheked();
					System.out.println("make your course");
				} else {
					System.out.println("make your course");
				}
			}
		}

	}

	/**
	 * This method get new position for Queen
	 * 
	 * @param getQueen
	 * 
	 * @return null
	 * 
	 */

	public String getPositionForOnlyQueen(int getQueen) {
		boolean flag = true;
		int numberOfMoves = 0;
		int numberOfChess = 0;
		while (flag) {
			// boolean flagIn = true;
			int newPosition = 0;
			do {

				newPosition = getCheked();
				// check if new position void
				if (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] != 0) {
					System.out.println("incorrect input");
					// if number Of Moves = we can change our Queen
					if (numberOfMoves == 0) {
						System.out.println("maybe you want to change chess 'y' - yes / other - no ");
						Scanner sc = new Scanner(System.in);
						// if y we made choice
						if (sc.nextLine().contentEquals("y")) {
							System.out.println("you choice is made... select you chess");
							getQueen = getCheked();
							// if new choice not Queen
							if (getChessType(getQueen)) {
								System.out.println("selected chess");
								getPositionForOnlyChess(getQueen);

								numberOfMoves++;
								// return with this method
								return null;
							}
							System.out.println("selected Queen");
						} else {
							System.out.println("select shape");
						}
					}
				}
				// while we don't go to finish
			} while (fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(newPosition)] != 0);
			int quarterVertical = getCoordinatesFirst(getQueen) - getCoordinatesFirst(newPosition);
			int quarterHorizontal = getCoordinatesSecond(getQueen) - getCoordinatesSecond(newPosition);

			int coordinatesAttackChessFirst = -1;
			int coordinatesAttackChessSecond = -1;
			int type = 0;
			if (vector(getQueen, newPosition)) {

				// if you choice Black Queen
				if (fildChess[getCoordinatesFirst(getQueen)][getCoordinatesSecond(getQueen)] == 3) {
					type = 3;
					// --
					if ((quarterVertical > 0) && (quarterHorizontal > 0)) {
						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {
							k--;
							j--;
							if ((fildChess[k][j] == 4) || (fildChess[k][j] == 2)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;
							}
							if ((fildChess[k][j] == 1) || (fildChess[k][j] == 3)) {
								numberOfChess += 2;
							}
						}

					}
					// -+
					if ((quarterVertical > 0) && (quarterHorizontal < 0)) {
						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {
							k--;
							j++;
							if ((fildChess[k][j] == 4) || (fildChess[k][j] == 2)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;
							}
							if ((fildChess[k][j] == 1) || (fildChess[k][j] == 3)) {
								numberOfChess += 2;
							}
						}
					}

					// +-
					if ((quarterVertical < 0) && (quarterHorizontal > 0)) {

						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {

							k++;
							j--;
							if ((fildChess[k][j] == 4) || (fildChess[k][j] == 2)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;

							}
							if ((fildChess[k][j] == 1) || (fildChess[k][j] == 3)) {
								numberOfChess += 2;

							}
						}
					}

					// ++
					if ((quarterVertical < 0) && (quarterHorizontal < 0)) {

						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {

							k++;
							j++;
							if ((fildChess[k][j] == 4) || (fildChess[k][j] == 2)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;

							}
							if ((fildChess[k][j] == 1) || (fildChess[k][j] == 3)) {
								numberOfChess += 2;

							}
						}
					}

				}

				// if you choice White Queen
				if (fildChess[getCoordinatesFirst(getQueen)][getCoordinatesSecond(getQueen)] == 4) {
					type = 4;
					// --
					if ((quarterVertical > 0) && (quarterHorizontal > 0)) {
						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {
							k--;
							j--;
							if ((fildChess[k][j] == 3) || (fildChess[k][j] == 1)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;
							}
							if ((fildChess[k][j] == 2) || (fildChess[k][j] == 4)) {
								numberOfChess += 2;
							}
						}

					}
					// -+
					if ((quarterVertical > 0) && (quarterHorizontal < 0)) {
						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {
							k--;
							j++;
							if ((fildChess[k][j] == 3) || (fildChess[k][j] == 1)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;
							}
							if ((fildChess[k][j] == 2) || (fildChess[k][j] == 4)) {
								numberOfChess += 2;
							}
						}
					}
					// +-
					if ((quarterVertical < 0) && (quarterHorizontal > 0)) {
						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {
							k++;
							j--;
							if ((fildChess[k][j] == 3) || (fildChess[k][j] == 1)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;
							}
							if ((fildChess[k][j] == 2) || (fildChess[k][j] == 4)) {
								numberOfChess += 2;
							}
						}
					}
					// ++
					if ((quarterVertical < 0) && (quarterHorizontal < 0)) {
						int k = getCoordinatesFirst(getQueen);
						int j = getCoordinatesSecond(getQueen);
						while (k != getCoordinatesFirst(newPosition)) {
							k++;
							j++;
							if ((fildChess[k][j] == 3) || (fildChess[k][j] == 1)) {
								numberOfChess += 1;
								coordinatesAttackChessFirst = k;
								coordinatesAttackChessSecond = j;
							}
							if ((fildChess[k][j] == 2) || (fildChess[k][j] == 4)) {
								numberOfChess += 2;
							}
						}
					}
				}
			}

			if (numberOfChess > 1) {
				flag = true;
				System.out.println("incorrect input try again");

			}

			if (numberOfChess == 1) {
				flag = false;
				fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(
						newPosition)] = fildChess[getCoordinatesFirst(getQueen)][getCoordinatesSecond(getQueen)];
				fildChess[coordinatesAttackChessFirst][coordinatesAttackChessSecond] = 0;
				fildChess[getCoordinatesFirst(getQueen)][getCoordinatesSecond(getQueen)] = 0;
				numberOfMoves++;
				if (type == 3) {
					numberOfChessWhite--;

				} else {
					numberOfChessBlack--;
				}
			}
			if (numberOfChess == 0) {
				flag = false;
				fildChess[getCoordinatesFirst(newPosition)][getCoordinatesSecond(
						newPosition)] = fildChess[getCoordinatesFirst(getQueen)][getCoordinatesSecond(getQueen)];
				fildChess[getCoordinatesFirst(getQueen)][getCoordinatesSecond(getQueen)] = 0;
				numberOfMoves++;
			}

		}
		return null;

	}

}
