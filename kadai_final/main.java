package kadai_final;

import java.util.Random;
import java.util.Scanner;

public class main {

	static int[][] board = new int[8][8];
    static int stoneColor; 


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

		int checkValue; // 入力値のチェック[ 0:エラー　1:先攻　2:後攻 ]
		
		while(true) {
			System.out.println("【　先攻、後攻を決定してください　】");
			System.out.println("【　先攻：1　　後攻：2　】");

			String turnInput = scanner.next();

			checkValue = ivj.convertInputTurn(turnInput);
			if(checkValue != 0) {
				break;
			}
			
		}

		while(true) {
			// 後攻の場合
			if(checkValue == 2) {
				for(int i = 0;i < 63;i++) {
					
					Random random1  = new Random();
					int randomValue = random1.nextInt(7);
					Random random2  = new Random();
					randomValue     = random2.nextInt(7);

					int a = random1.nextInt(7);
					int b = random2.nextInt(7);  
						
					if(checkValue == 1) {
						stoneColor  = 1;
					}else {
						stoneColor  = -1;
					}

					
					
					// デバッグコード
					System.out.println("乱数X = "+ a);
					System.out.println("乱数Y = "+ b);
					
					// 盤外だった場合
					if (a > 7 || b > 7) {
						break;
					}
						tool.turnStone(a,  b, stoneColor) ;
					if(board[a][b] == stoneColor) {
						break;
					}
				}
				tool.printBoard(board);
				tool.count(board);
			}

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

				int a = returnValue[1];
				int b = returnValue[2];


				if(checkValue == 1) {
					stoneColor  = -1;
				}else {
					stoneColor  = 1;
				}

				tool.turnStone(a,  b,stoneColor) ;
				tool.printBoard(board);
				tool.count(board);
			// コマの八方向の判定
		
			}
	}
}
