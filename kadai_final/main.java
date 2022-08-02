package kadai_final;

import java.util.Random;
import java.util.Scanner;

public class main {

	static int[][] board = new int[8][8];


	/*	{{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,1,-1,0,0,0},
			{0,0,0,-1,1,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}}; */ 
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

		// 入力値のチェック[ 0:エラー　1:先攻　2:後攻 ]
		int checkValue;
		int humanColor;
		int comColor;
        int turnCheckValue = 0;

		while(true) {
			System.out.println("【　先攻、後攻を決定してください　】");
			System.out.println("【　先攻：1　　後攻：2　】");

			String turnInput = scanner.next();

			checkValue = ivj.convertInputTurn(turnInput);
			if(checkValue != 0) {
				break;
			}
			if(checkValue == 1) {
				humanColor = -1;
				comColor   = 1;
			}else {
				humanColor = 1;
				comColor   = -1; 
			}
		}

		while(true) {
			// 後攻の場合
			if(checkValue == 2) {
				for(int i = 0;i < board.length;i++) {
					turnCheckValue = tool.turnCheck(turnCheckValue, turnCheckValue,
							turnCheckValue,turnCheckValue, turnCheckValue,
							turnCheckValue,turnCheckValue, turnCheckValue);

					Random random1  = new Random();
					int randomValue = random1.nextInt(7);
					Random random2  = new Random();
					randomValue     = random2.nextInt(7);

					int x = random1.nextInt(7);
					int y = random2.nextInt(7);

					// デバッグコード
					System.out.println("乱数X = "+ x);
					System.out.println("乱数Y = "+ y);


					// Comが置こうとしてるマスが空であるかの条件分岐
					if(board[x][y] == 0) {
						if(checkValue == 2) {
							board[x][y] = -1;
						}else {
							board[x][y] = 1;
						}

						tool.turnStone(x,  y) ;
						tool.turnCheck(turnCheckValue, turnCheckValue, turnCheckValue,
								turnCheckValue, turnCheckValue, turnCheckValue,
								turnCheckValue, turnCheckValue);
						tool.printBoard(board);

						// デバッグコード

						System.out.println("turnCheckValue"+turnCheckValue);

						// ひっくり返したコマが無かった場合
						if(turnCheckValue == 0) {
							// Com が選択した座標を初期化する
							board[x][y] = 0;
						}else {
							continue;
						}
						// ひっくり返したコマがあった場合
					}else if(turnCheckValue == 1) {
						break;
					}
				}
				tool.printBoard(board);
				tool.count(board);
				break;
			}else {


				// 入力値のチェック[ (0は正常値),X軸,Y軸 ]
				int[] returnValue;

				while(true) {
					System.out.println("【コマの置く位置を決定してください】");
					System.out.println("【　Ａ１～Ｈ８　？】");
					System.out.println("【ｅｘ) Ｂ３　　　】");

					String userInput = scanner.next();

					returnValue = ivj.convertInputStone(userInput);
					if(returnValue[0] == 0) {
						break;
					}
				}

				int x = returnValue[1];
				int y = returnValue[2];


				if(checkValue == 1) {
					board[x][y] = -1;
				}else {
					board[x][y] = 1;
				}

				tool.turnStone(x,  y) ;
				tool.printBoard(board);
				tool.count(board);
			}
			// コマの八方向の判定
		}
	}
}