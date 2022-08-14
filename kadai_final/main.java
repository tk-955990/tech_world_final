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

		System.out.println("********** Ga me Start!! **********");

		Scanner scanner = new Scanner(System.in);

		int checkValue = 0; // 入力値のチェック[ 0:エラー　1:先攻　2:後攻 ]
		int stoneColor = 0 ; 
		int turnFlag = 0;
		int turnCount = 0;

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
			System.out.println("checkValue="+checkValue);
			System.out.println("turnFlag 1="+turnFlag);

		}
			// 後攻の場合
		while (true) {
			int a = 0;
			int b = 0;

			if(turnFlag %2 == 0) {

				for(int i = 0;i < 64;i++) {
					int count = 0 ; 

					Random random1  = new Random();
					int randomValue = random1.nextInt(7);
					Random random2  = new Random();
					randomValue     = random2.nextInt(7);

					a = random1.nextInt(7);
					b = random2.nextInt(7);  

					if(checkValue == 1) {  // 後攻
						stoneColor  = 1;   // コマの色　黒
					}else {
						stoneColor  = -1;  //           白
					}

					// デバッグコード
					System.out.println("乱数X = "+i+"回目"+ a);
					System.out.println("乱数Y = "+i+"回目"+ b);

					// 盤外だった場合
					if (a > 7 || b > 7) 
						break;
					System.out.println("main.board[a][b]="+main.board[a][b]);

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

						System.out.println("Count = "+count);

						// ターン終了判定
						if(count > 0) {
							break;
						}
					}
				}

				tool.printBoard(board);
				tool.count(board);

				turnFlag++;
				System.out.println("turnFlag"+turnFlag);
			}else {

			// 入力値のチェック[ (0は正常値),X軸,Y軸 ]
			int[] returnValue;

			while(true) {
				System.out.println("【コマの置く位置を決定してください】");
				System.out.println("【　Ａ１～Ｈ８　？】");
				System.out.println("【ｅｘ) Ｂ３　　　】");

				String userInput = scanner.next();

				returnValue = ivj.convertInputStone(userInput);
				if(returnValue[0] == 0) 
					break;
			}

			a = returnValue[1];
			b = returnValue[2];


			if(checkValue == 1) {
				stoneColor  = -1;
			}else {
				stoneColor  = 1;
			}
			tool.turnStone(a, b, stoneColor);
			tool.printBoard(board);
			tool.count(board);
			System.out.println("board[a][b]"+board[a][b]);

			turnFlag++;
			System.out.println("turnFlag"+turnFlag);	
		}

		}
	}
}
