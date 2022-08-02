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
	public void turnStone(int x, int y) {
		turnLeftUp   (x, y);     //左上
		turnUp       (x, y);
		turnRightUp  (x, y);
		turnRight    (x, y);
		turnRightDown(x, y);
		turnDown     (x, y);
		turnLeftDown (x, y);
		turnLeft     (x, y);
	}
	
	// ひっくり返したコマの有無
	public int turnCheck(int countLup, int countUp, int countRup, int countR, 
			             int countRdown, int countDown, int countLdown, int countL) {
		int turnCheckValue = 0;
		int[] turnCheckArray = {countLup,countUp,countRup,countR,
				                countRdown,countDown,countLdown,countL};
		
		for(int i=0; i<turnCheckArray.length;i++) {
			if(turnCheckArray[i] > 0) {
				turnCheckValue = 1;
				break;
			}
		
		}
		
		// デバッグコード
		System.out.println("countLup"+countLup);
		System.out.println("countUp"+countUp);
		System.out.println("countRup"+countRup);
		System.out.println("countR"+countR);
		System.out.println("countRdown"+countRdown);
		System.out.println("countDown"+countDown);
		System.out.println("countLdown"+countLdown);
		System.out.println("countL"+countL);


		// ひっくり返したコマがあれば１、無ければ０を返す
		return turnCheckValue;
	}

	public int turnLeftUp(int x, int y) {
		int countLup = 0;
		
		if (y > 1 && x > 1) {

			//隣のコマ
			int  next = main.board[x-1][y-1];
			//隣のコマが相手の色だった場合
			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {

					if (x - i < 0 || y - i < 0 || main.board[x - i][y - i]== 0) {
						//コマが無かった場合終了
						break;
					} else if (main.board[x - i][y - i]== main.board[x][y]) {
						//コマが自分の色だった場合
						//間のコマをひっくり返す
						for (int t = 1; t < i; t++) {
							// 配列の要素を上書き
							main.board[x - t][y - t] *= -1;
							countLup++;
						}
						break;
					}
				}
			}
		}
		return countLup;
	}

	public int turnUp(int x, int y) {
		int countUp = 0;

		if (y > 1) {

			int  next = main.board[x][y-1];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if(y - i < 0 || main.board[x][y-i] == 0) {
						break;
					}else if(main.board[x][y - i] == main.board[x][y]) {
						for (int t = 1; t < i; t++) {
							main.board[x][y - t] *= -1;
							countUp++;
						}
						break;
					}
				}
			}
		}
		return countUp;
	}

	public int turnRightUp(int x, int y) {
		int countRup = 0;

		if (y > 1 && x < 6) {

			int  next = main.board[x+1][y-1];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if(x + i < 0 || y - i < 0 || main.board[x+i][y-i] == 0) {
						break;
					}else if(main.board[x + i][y - i] == main.board[x][y]) {
						for(int t = 1; t < i;t++) {
							main.board[x+t][y-t] *= -1;
							countRup++;
						}
						break;
					}
				}
			}
		}
		return countRup;
	}

	public int turnRight(int x, int y) {
		int countR = 0;
		
		if (x < 6) {

			int  next = main.board[x+1][y];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if (x + i < 0 || main.board[x + i][y]== 0) {
						break;
					} else if (main.board[x + i][y]== main.board[x][y]) {
						for (int t = 1; t < i; t++) {
							main.board[x + t][y] *= -1;
							countR++;
						}
						break;
					}
				}
			}
		}
		return countR;
	}

	public int turnRightDown(int x, int y) {
		int countRdown = 0;
		
		if (y < 6 && x < 6) {

			int  next = main.board[x+1][y+1];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if(x + i < 0 || y + i < 0 || main.board[x+i][y+i] == 0) {
						break;
					}else if(main.board[x + i][y + i] == main.board[x][y]) {
						for(int t = 1; t < i;t++) {
							main.board[x+t][y+t] *= -1;
							countRdown++;
						}
						break;
					}
				}
			}
		}
		return countRdown;
	}

	public int turnDown(int x, int y) {
		int countDown  = 0; 
		
		if (y < 6) {

			int  next = main.board[x][y+1];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if(y + i < 0 || main.board[x][y+i] == 0) {
						break;
					}else if(main.board[x][y + i] == main.board[x][y]) {
						for (int t = 1; t < i; t++) {
							main.board[x][y + t] *= -1;
							countDown++;
						}
						break;
					}
				}
			}
		}
		return countDown;
	}

	public int turnLeftDown(int x, int y) {
		int countLdown = 0;
		
		if (y < 6 && x > 1) {

			int  next = main.board[x-1][y+1];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if(x - i < 0 || y + i < 0 || main.board[x-i][y+i] == 0) {
						break;
					}else if(main.board[x - i][y + i] == main.board[x][y]) {
						for(int t = 1; t < i;t++) {
							main.board[x-t][y+t] *= -1;
							countLdown++;
						}
						break;
					}
				}
			}
		}
		return countLdown;
	}

	public int turnLeft(int x, int y) {
		int countL = 0;
		
		if (x > 1) {

			int  next = main.board[x-1][y];

			if(next != main.board[x][y]) {
				for(int i = 2;true;i++) {
					if (x - i < 0 || main.board[x - i][y]== 0) {
						break;
					} else if (main.board[x - i][y]== main.board[x][y]) {
						for (int t = 1; t < i; t++) {
							main.board[x - t][y] *= -1;
							countL++;
						}
						break;
					}
				}
			}
		}
		return countL;
	}
}
