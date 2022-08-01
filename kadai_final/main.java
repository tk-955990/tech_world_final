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

		game(board, tool.count(board), tool.count(board) );

	}

	public static void game(int[][] board,int countB,int countW) {

		System.out.println("********** Game Start!! **********");


		Scanner scanner = new Scanner(System.in);

		// 入力値のチェック[ 0:エラー　1:先攻　2:後攻 ]
		int checkValue;
        int humanColor;
        int comColor;
		int lastTimeCountB = countB;
		int lastTimeCountW = countW;

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
			if(checkValue == 2) {
				do {

					
					Random random1 = new Random();
					int randomValue = random1.nextInt(7);
					Random random2 = new Random();
					randomValue = random2.nextInt(7);

					int x = random1.nextInt(7);
					int y = random2.nextInt(7);

					System.out.println("乱数X = "+ x);
					System.out.println("乱数Y = "+ y);

					
					if(checkValue == 2) {
						board[x][y] = -1;
					}else {
						board[x][y] = 1;
					}

					

					tool.turnStone(x,  y) ;
					tool.count(board);

				}while((lastTimeCountB > countB)||(lastTimeCountW > countW));
				tool.printBoard(board);
				tool.count(board);
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