package kadai_final;

public class Tool {

	public void printBoard(int[][] board){

		System.out.println("   A   B   C   D   E   F   G   H");
		System.out.println(" ┏━┳━┳━┳━┳━┳━┳━┳━┓");

		for(int j = 0;j<board.length;j++) {
			System.out.print((j+1)+"┃");
			for(int i = 0;i<8;i++) {
				if (board[i][j] == -1) {
					System.out.print("〇");
				}else if(board[i][j] == 1) {
					System.out.print("●");	
				}else if(board[i][j] == 0) {
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

	// コマのカウント
	public void count (int[][] board) {

		int countB = 0;
		int countW = 0;
		int count0 = 0;

		for(int i=0;i<board.length;i++) {
			for(int j = 0;j<8;j++) {
				if (board[i][j] == -1) {
					countB++;
				}else if(board[i][j] == 1) {
					countW++;
				}else if(board[i][j] == 0) {
					count0++;
				}
			}
		}
		System.out.println("黒: "+countB+"個");
		System.out.println("白: "+countW+"個");
	}

	// コマをひっくり返す処理
	public void turnStone(int a, int b, int stoneColor) {
		turnLeftUp   (a, b, stoneColor);     //左上
		turnUp       (a, b, stoneColor);
		turnRightUp  (a, b, stoneColor);
		turnRight    (a, b, stoneColor);
		turnRightDown(a, b, stoneColor);
		turnDown     (a, b, stoneColor);
		turnLeftDown (a, b, stoneColor);
		turnLeft     (a, b, stoneColor);
	}

	public int turnLeftUp(int a, int b,int stoneColor) {
		
		int turnCount = 0;
        
		// 隣にコマが二個以上あるかの判定
		if (b > 1 && a > 1) {
			// 隣のコマ
			int  next = main.board[a-1][b-1];
			// 隣のコマが相手の色だった場合
			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {

					if (a - i < 0 || b - i < 0 || main.board[a - i][b - i]== 0) {
						
						// コマが無かった場合終了
						break;
					} else if (main.board[a - i][b - i]== stoneColor) {
						
						// コマが自分の色だった場合
						// 間のコマをひっくり返す
						for (int t = 1; t < i; t++) {
						
							// 配列の要素を上書き
							main.board[a - t][b - t] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;  // ひっくり返したカウント
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnUp(int a, int b, int stoneColor) {
		
		int turnCount = 0;
		
		if (b > 1) {

			int  next = main.board[a][b-1];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if(b - i < 0 || main.board[a][b-i] == 0) {
						break;
					}else if(main.board[a][b - i] == stoneColor) {
						for (int t = 1; t < i; t++) {
							main.board[a][b - t] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnRightUp(int a, int b, int stoneColor) {
		int turnCount = 0;

		if (a < 6 && b> 1) {

			int  next = main.board[a+1][b-1];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if(a + i > 7|| b - i < 0 || main.board[a+i][b-i] == 0) {
						break;
					}else if(main.board[a + i][b - i] == stoneColor) {
						for(int t = 1; t < i;t++) {
							main.board[a+t][b-t] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnRight(int a, int b, int stoneColor) {

		int turnCount = 0;

		if (a < 6) {

			int  next = main.board[a+1][b];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if (a + i > 7 || main.board[a + i][b]== 0) {
						break;
					} else if (main.board[a + i][b]== stoneColor) {
						for (int t = 1; t < i; t++) {
							main.board[a + t][b] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnRightDown(int a, int b, int stoneColor) {

		int turnCount = 0;

		if (b < 6 && a < 6) {

			int  next = main.board[a+1][b+1];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if(a + i > 7 || b + i > 7 || main.board[a+i][b+i] == 0) {
						break;
					}else if(main.board[a + i][b + i] == stoneColor) {
						for(int t = 1; t < i;t++) {
							main.board[a+t][b+t] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnDown(int a, int b, int stoneColor) {

		int turnCount = 0;

		if (b < 6) {

			int  next = main.board[a][b+1];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if(b + i > 7 || main.board[a][b+i] == 0) {
						break;
					}else if(main.board[a][b + i] == stoneColor) {
						for (int t = 1; t < i; t++) {
							main.board[a][b + t] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnLeftDown(int a, int b, int stoneColor) {

		int turnCount = 0;

		if (b < 6 && a > 1) {

			int  next = main.board[a-1][b+1];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if(a - i < 0 || b + i > 7 || main.board[a-i][b+i] == 0) {
						break;
					}else if(main.board[a - i][b + i] == stoneColor) {
						for(int t = 1; t < i;t++) {
							main.board[a-t][b+t] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}

	public int turnLeft(int a, int b, int stoneColor) {

		int turnCount = 0;

		if (a > 1) {

			int  next = main.board[a-1][b];

			if((next != stoneColor)&&(next != 0)) {
				for(int i = 2;true;i++) {
					if (a - i < 0 || main.board[a - i][b]== 0) {
						break;
					} else if (main.board[a - i][b]== stoneColor) {
						for (int t = 1; t < i; t++) {
							main.board[a - t][b] *= -1;
							main.board[a][b] = stoneColor;
							turnCount++;
						}
						break;
					}
				}
			}
		}
		return turnCount;
	}
}
