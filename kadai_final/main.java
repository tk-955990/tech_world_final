package kadai_final;

import java.util.Random;
import java.util.Scanner;

public class main {

	static int[][] board = new int[8][8];

	static InputValueJudgment ivj = new InputValueJudgment();
	static Tool tool = new Tool();
	public static void main (String[] args) {

		board[3][3] = 1;
		board[4][3] = -1;
		board[3][4] = -1;
		board[4][4] = 1;

		tool.printBoard(board);
		tool.count(board);

		game(board);

	}

	public static void game(int[][] board) {

		System.out.println("********** Game Start!! **********");

		Scanner scanner = new Scanner(System.in);

		int checkValue = 0; // 入力値のチェック[ 0:エラー　1:先攻　2:後攻 ]
		int stoneColor = 0 ; 
		int turnFlag = 0;
		int turnCount = 0;
		int passCount = 0;
		int exitDecisionValue = 0;

		while(checkValue ==0) {
			System.out.println("【　先攻、後攻を決定してください　】");
			System.out.println("【　先攻：1　　後攻：2　】");

			String turnInput = scanner.next();

			checkValue = ivj.convertInputTurn(turnInput);

			switch (checkValue) {
			case 1: 
				turnFlag = 1;
				break;
			case 2:
				turnFlag = 2;
				break;
			}
		}
		// 後攻の場合
		while (true) {
			int a = 0;
			int b = 0;

			exitDecisionValue =  tool.count(board);

			if(turnFlag %2 == 0) {
				int count = 0 ; 

				for(b = 0;b < 8;b++) {
					count = 0 ; 
					for(a = 0;a < 8;a++) {

						if(checkValue == 1) {  // 後攻
							stoneColor  = 1;   // コマの色　黒
						}else {
							stoneColor  = -1;  //           白
						}

						// 盤外だった場合
						if (a > 7 || b > 7) 
							break;

						// Comが置こうとしてるマスが空であるかの条件分岐
						if((main.board[a][b] != 1)&&(main.board[a][b] !=-1)) {
							count += tool.turnLeftUp   (a, b, stoneColor);
							count += tool.turnUp       (a, b, stoneColor);
							count += tool.turnRightUp  (a, b, stoneColor);
							count += tool.turnRight    (a, b, stoneColor);
							count += tool.turnRightDown(a, b, stoneColor);
							count += tool.turnDown     (a, b, stoneColor);
							count += tool.turnLeftDown (a, b, stoneColor);
							count += tool.turnLeft     (a, b, stoneColor);

						}
						// ターン終了判定
						if(count > 0) {
							break;
						}
					}
					if(count > 0) {
						passCount = 0;
						break;
					}
				}
				if(count == 0) {
					System.out.println("------- Com はパスしました --------");
					passCount++;
				}
				
				// 両者ともパスした場合
				if(passCount == 2) {

					if((stoneColor  == -1)&&(exitDecisionValue == 1)) {
						System.out.println("------------ Game Over ------------");
					}else if((stoneColor  == 1)&&(exitDecisionValue == 1)) {
						System.out.println("------------ You Win !! -----------");
					}else if((stoneColor  == -1)&&(exitDecisionValue == 2)) {
						System.out.println("------------ You Win !! -----------");
					}else if((stoneColor  == 1)&&(exitDecisionValue == 2)) {
						System.out.println("------------ Game Over ------------");
					}

					break;
				}
				tool.printBoard(board);



				turnFlag++;
			}else {

				// 入力値のチェック[ (0は正常値),X軸,Y軸 ]
				int[] returnValue;

				while(true) {
					System.out.println("【コマの置く位置を決定してください】");
					System.out.println("【　Ａ１～Ｈ８　？】");
					System.out.println("【ｅｘ) Ｂ３　　　】");
					System.out.println("【パスする場合はℤℤを入力してください】");
					String userInput = scanner.next();

					returnValue = ivj.convertInputStone(userInput);


					int count = 0;
					a = returnValue[1];
					b = returnValue[2];

					if(checkValue == 1) {
						stoneColor  = -1;
					}else {
						stoneColor  = 1;
					}

					// パスが選択された場合
					if(returnValue[0] == 4) {
						passCount++;
						if(passCount == 2) {

							if((stoneColor  == -1)&&(exitDecisionValue == 1)) {
								System.out.println("------------ You Win !! -----------");
							}else if((stoneColor  == 1)&&(exitDecisionValue == 1)) {
								System.out.println("------------ Game Over ------------");
							}else if((stoneColor  == -1)&&(exitDecisionValue == 2)) {
								System.out.println("------------ Game Over ------------");
							}else if((stoneColor  == 1)&&(exitDecisionValue == 2)) {
								System.out.println("------------ You Win !! -----------");
							}
							break;
						}
						break;
					}
					count += tool.turnLeftUp   (a, b, stoneColor);
					count += tool.turnUp       (a, b, stoneColor);
					count += tool.turnRightUp  (a, b, stoneColor);
					count += tool.turnRight    (a, b, stoneColor);
					count += tool.turnRightDown(a, b, stoneColor);
					count += tool.turnDown     (a, b, stoneColor);
					count += tool.turnLeftDown (a, b, stoneColor);
					count += tool.turnLeft     (a, b, stoneColor);

					// ひっくり返せないマスを指定した場合
					if(count == 0) {
						returnValue[0] = 3; 
						System.out.println("指定したマスには置けません!!!");
					}
					if(returnValue[0] == 0) {
						break;
					}
					passCount = 0;
				}
				if(passCount == 2) {
					break;
				}
				tool.printBoard(board);

				turnFlag++;
			}
		}
	}
}
