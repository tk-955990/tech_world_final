package fainal_kadai;

public class Tool {

	public void printBoard(int[][] board){

		System.out.println("   A   B   C   D   E   F   G   H");
		System.out.println(" ┏━┳━┳━┳━┳━┳━┳━┳━┓");


		for(int j=0;j<board.length;j++) {
			System.out.print((j+1)+"┃");
			for(int i=0;i<8;i++) {
				if (board[i][j]==-1) {
					System.out.print("〇");
				}else if(board[i][j]==1){
					System.out.print("●");	
				}else if(board[i][j]==0){
					System.out.print("　");
				}
				System.out.print("┃");
			}
			System.out.println("");
			if(j<board.length-1) {
				System.out.println(" ┣━╋━╋━╋━╋━╋━╋━╋━┫");	
			}else{
				System.out.println(" ┗━┻━┻━┻━┻━┻━┻━┻━┛");
			}
		}
	}

	// 先攻、後攻の入力値チェック
	public int convertInputTurn(String strInputTurn) {

		int checkValue ;

		// 文字数チェック
		if(strInputTurn.length() != 1) {
			System.out.println("入力値が間違っています");
			checkValue = 0;
			return checkValue;
		}

		// 入力値の変換
		char charTurn = strInputTurn.charAt(0);

		switch(charTurn) {
		case '1':
		case '１':
			System.out.println("あなたは先攻です");
			checkValue = 1;
			break;
		case '2':
		case '２':
			System.out.println("あなたは後攻です");
			checkValue = 2;
			break;
		default:
			System.out.println("入力値が間違っています");
			checkValue = 0;
		}
		return checkValue;
	}



	// コマを置く位置の入力値チェック
	public int[] convertInputStone(String strInputStone) {

		int[] returnValue = new int[3];

		// 文字数チェック
		if(strInputStone.length() != 2) {
			System.out.println("入力文字数が間違っています");
			System.out.println("二文字で入力してください");
			returnValue[0] = 1;
			return returnValue;
		}

		// 入力値１文字目のチェック、変換
		char charX = strInputStone.charAt(0);

		switch(charX) {
		case 'A':
		case 'Ａ':
		case 'a':
		case 'ａ':
			returnValue[1] = 0;
			break;
		case 'B':
		case 'Ｂ':
		case 'b':
		case 'ｂ':
			returnValue[1] = 1;
			break;
		case 'C':
		case 'Ｃ':
		case 'c':
		case 'ｃ':
			returnValue[1] = 2;
			break;
		case 'D':
		case 'Ｄ':
		case 'd':
		case 'ｄ':
			returnValue[1] = 3;
			break;
		case 'E':
		case 'Ｅ':
		case 'e':
		case 'ｅ':
			returnValue[1] = 4;
			break;
		case 'F':
		case 'Ｆ':
		case 'f':
		case 'ｆ':
			returnValue[1] = 5;
			break;
		case 'G':
		case 'Ｇ':
		case 'g':
		case 'ｇ':
			returnValue[1] = 6;
			break;
		case 'H':
		case 'Ｈ':
		case 'h':
		case 'ｈ':
			returnValue[1] = 7;
			break;
		default:
			System.out.println("入力値が間違っています");
			returnValue[0] = 2;
			return returnValue;
		}

		// 入力値２文字目のチェック

		char charY = strInputStone.charAt(1);
		try {
			returnValue[2] = Integer.parseInt(String.valueOf(charY))-1;
		}catch(NumberFormatException e) {
			System.out.println("入力値が間違っています");
			returnValue[0] = 2;
			return returnValue;
		}

		//
		if(returnValue[2] < 0 || returnValue[2] > 7) {
			System.out.println("指定したマスには置けません");
			returnValue[0] = 3;
		}
		return returnValue;
	}
	
	// コマのカウント
	public void count (int[][] board) {

		int countB = 0;
		int countW = 0;
		int count0 = 0;

		for(int i=0;i<board.length;i++) {
			for(int j=0;j<8;j++) {
				if (board[i][j]==-1) {
					countB++;
				}else if(board[i][j]==1){
					countW++;
				}else if(board[i][j]==0){
					count0++;
				}
			}
		}
		System.out.println("黒: "+countB+"個");
		System.out.println("白: "+countW+"個");
	}

/*	public void turnStone(int[][] board) {
		turnLeftUp(board);
	    turnUp();
	    turnRightUp();
	    turnLeft();
	    turnRight();
	    turnLeftDown();
	    turnDown();
	    turnRightDown();
	}
	
	public void turnLeftUp(int[][] board) {
		int  next = board[x-1][y-1];
	}
	
	*/
}
