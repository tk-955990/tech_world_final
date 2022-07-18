package fainal_kadai;

import java.util.Scanner;

public class main {

	static int[][] board = {{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,1,-1,0,0,0},
			{0,0,0,-1,1,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}};  
	static Tool tool = new Tool();

	public static void main (String[] args) {

		tool.printBoard(board);
		game();

	}

	public static void game() {

		System.out.println("********** Game Start!! **********");


		Scanner scanner = new Scanner(System.in);

		// 入力値のチェック[ 0:エラー　1:先攻　2:後攻 ]
		int checkValue;

		while(true) {
			System.out.println("【　先攻、後攻を決定してください　】");
			System.out.println("【　先攻：1　　後攻：2　】");

			String turnInput = scanner.next();

			checkValue = tool.convertInputTurn(turnInput);
			if(checkValue != 0) {
				break;
			}
		}

		// 入力値のチェック[ (0は正常値),X軸,Y軸 ]
		int[] returnValue;

		while(true) {
			System.out.println("【コマの置く位置を決定してください】");
			System.out.println("【　Ａ１～Ｈ８　？】");
			System.out.println("【ｅｘ) Ｂ３　　　】");

			String userInput = scanner.next();

			returnValue = tool.convertInputStone(userInput);
			if(returnValue[0] == 0) {
				break;
			}
		}

		// コマの八方向の判定
	}
}
