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

	public void turnLeftUp(int a, int b,int stoneColor) {
		// Comが置こうとしてるマスが空であるかの条件分岐
		if(main.board[a][b] == 0) {
			if (b > 1 && a > 1) {

				//隣のコマ
				int  next = main.board[a-1][b-1];
				//隣のコマが相手の色だった場合
				if((next != stoneColor)&&(next != 0)) {
					for(int i = 2;true;i++) {

						if (a - i < 0 || b - i < 0 || main.board[a - i][b - i]== 0) {
							//コマが無かった場合終了
							break;
						} else if (main.board[a - i][b - i]== stoneColor) {
							//コマが自分の色だった場合
							//間のコマをひっくり返す
							for (int t = 1; t < i; t++) {
								// 配列の要素を上書き
								main.board[a - t][b - t] *= -1;
								main.board[a][b] = stoneColor;
							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnUp(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {

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
							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnRightUp(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {

			if (a < 6 && b> 1) {

				int  next = main.board[a+1][b-1];

				if((next != stoneColor)&&(next != 0)) {
					for(int i = 2;true;i++) {
						if(a + i < 0 || b - i < 0 || main.board[a+i][b-i] == 0) {
							break;
						}else if(main.board[a + i][b - i] == stoneColor) {
							for(int t = 1; t < i;t++) {
								main.board[a+t][b-t] *= -1;
								main.board[a][b] = stoneColor;
							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnRight(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {
			if (a < 6) {

				int  next = main.board[a+1][b];

				if((next != stoneColor)&&(next != 0)) {
					for(int i = 2;true;i++) {
						if (a + i < 0 || main.board[a + i][b]== 0) {
							break;
						} else if (main.board[a + i][b]== stoneColor) {
							for (int t = 1; t < i; t++) {
								main.board[a + t][b] *= -1;
								main.board[a][b] = stoneColor;
							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnRightDown(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {
			if (b < 6 && a < 6) {

				int  next = main.board[a+1][b+1];

				if((next != stoneColor)&&(next != 0)) {
					for(int i = 2;true;i++) {
						if(a + i < 0 || b + i < 0 || main.board[a+i][b+i] == 0) {
							break;
						}else if(main.board[a + i][b + i] == stoneColor) {
							for(int t = 1; t < i;t++) {
								main.board[a+t][b+t] *= -1;
								main.board[a][b] = stoneColor;

							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnDown(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {
			if (b < 6) {

				int  next = main.board[a][b+1];

				if((next != stoneColor)&&(next != 0)) {
					for(int i = 2;true;i++) {
						if(b + i < 0 || main.board[a][b+i] == 0) {
							break;
						}else if(main.board[a][b + i] == stoneColor) {
							for (int t = 1; t < i; t++) {
								main.board[a][b + t] *= -1;
								main.board[a][b] = stoneColor;
							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnLeftDown(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {
			if (b < 6 && a > 1) {

				int  next = main.board[a-1][b+1];

				if((next != stoneColor)&&(next != 0)) {
					for(int i = 2;true;i++) {
						if(a - i < 0 || b + i < 0 || main.board[a-i][b+i] == 0) {
							break;
						}else if(main.board[a - i][b + i] == stoneColor) {
							for(int t = 1; t < i;t++) {
								main.board[a-t][b+t] *= -1;
								main.board[a][b] = stoneColor;
							}
							break;
						}
					}
				}
			}
		}
	}

	public void turnLeft(int a, int b, int stoneColor) {
		if(main.board[a][b] == 0) {
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
							}
							break;
						}
					}
				}
			}
		}
	}
}
