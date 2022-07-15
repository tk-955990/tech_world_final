package fainal_kadai;

public class Board_Vew {

	public   void board(){

		int[][] tmp = {{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,1,-1,0,0,0},
				{0,0,0,-1,1,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}};  

	    System.out.println("   A   B   C   D   E   F  G   H");
		System.out.println(" ┏━┳━┳━┳━┳━┳━┳━┳━┓");

		for(int i=0;i<tmp.length;i++) {
			System.out.print((i+1)+"┃");
			for(int j=0;j<8;j++) {
				if (tmp[i][j]==-1) {
					System.out.print("○");
				}else if(tmp[i][j]==1){
					System.out.print("●");	
				}else if(tmp[i][j]==0){
					System.out.print("　");
				}
				System.out.print("┃");
			}
			System.out.println("");
			if(i<tmp.length-1) {
				System.out.println(" ┣━╋━╋━╋━╋━╋━╋━╋━┫");	
			}else{
				System.out.println(" ┗━┻━┻━┻━┻━┻━┻━┻━┛");
			}
		}
	}
}
