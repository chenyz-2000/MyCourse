import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E01 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("read from(k/f):");
		String from = scan.next();

		boolean state[][] = new boolean[15][15];
		if (from.equals("k")) {
			
		} 
		else if (from.equals("f")) {
			try {scan = new Scanner(new File("original.txt"));} 
			catch (FileNotFoundException e) {
				System.out.println("File not found. Turn to read from the keyboard.");
			}
		}		
		System.out.print("original state:\n");
		int row = 5;
		scan.nextLine();
		while (scan.hasNextLine()) {
			String s = scan.nextLine();
			if (s.equals(""))
				break;
			for (int i = 0; i < s.length(); i++) {
				state[row][7 + i] = s.charAt(i) == ' ' ? false : true;
			}
			row++;
		}
		System.out.println("original state:");
		for(int i = 0;i<15;i++) {
			for(int j = 0;j<15;j++) {
				System.out.print(state[i][j] == true ? 'x' : ' ');
			}
			System.out.println();
		}
		for (int step = 0; step < 05; step++) {
			System.out.println("step" + (step + 1));
			boolean nextgen[][] = new boolean[15][15];
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					int live = 0;
					for (int di = -1; di <= 1; di++)
						for (int dj = -1; dj <= 1; dj++)
							if (di != 0 || dj != 0)
								if (i + di >= 0 && i + di < 15 && j + dj >= 0 && j + dj < 15) {
									if (state[i + di][j + dj] == true)
										live++;
								}
					if (state[i][j] == true) {
						if (live == 2 || live == 3)
							nextgen[i][j] = true;
						else
							nextgen[i][j] = false;
					} 
					else {
						if (live == 3)
							nextgen[i][j] = true;
						else
							nextgen[i][j] = false;
					}
				}
				for (int j = 0; j < 15; j++)
					System.out.print(nextgen[i][j] == true ? 'x' : ' ');
				System.out.println();
			}
			state = nextgen;
		}
	}
}