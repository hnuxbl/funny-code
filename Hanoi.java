import java.util.LinkedList;

public class Hanoi {
	

	public static void main(String[] args) {
		int n = 3;
		LinkedList<Integer>[] disk = new LinkedList[3];
		for (int i = 0; i < 3; i++) {
			disk[i] = new LinkedList<Integer>();
		}
		for (int i = n; i >= 1; i--) {
			disk[0].add(2 * i - 1);
		}
		hanoi(n, n, 0, 1, 2, disk);
	}
	
	public static void hanoi(int n, char origin, char assist, char destination) {
		if (n == 1) {
			move(origin, destination);
		} else {
			hanoi(n - 1, origin, destination, assist);
			move(origin, destination);
			hanoi(n - 1, assist, origin, destination);
		}
	}
	
	public static void move(char origin, char destination) {
		System.out.println("Direction: " + origin + " ----> " + destination);
	}
	
	public static void hanoi(int n, int size, int origin, int assist, int destination, LinkedList<Integer>[] disk) {
		if (n == 1) {
			move(size, origin, destination, disk);
		} else {
			hanoi(n - 1, size, origin, destination, assist, disk);
			move(size, origin, destination, disk);
			hanoi(n - 1, size, assist, origin, destination, disk);
		}
	}
	
	public static void move(int size, int origin, int destination, LinkedList<Integer>[] disk) {
		System.out.println("Direction: " + origin + " ----> " + destination);
		System.out.println("  ");	
		int originNum = disk[origin].pollLast();
		disk[destination].add(originNum);
		
		printDisk(size, disk);
	}
	
	public static void printDisk(int size, LinkedList<Integer>[] disk) {
		int columnSize = 2 * size + 1;
		Object[] left = disk[0].toArray();
		Object[] middle = disk[1].toArray();
		Object[] right = disk[2].toArray();
		int leftIndex = left.length;
		int middleIndex = middle.length;
		int rightIndex = right.length;
		for (int i = size; i >= 1; i--) {
			//print i-th floor's disk
			//print left
			if (left.length < i) {
				printFloor(columnSize, 0);
			} else {
				printFloor(columnSize, (Integer) left[--leftIndex]);
			}
			
			//print middle
			if (middle.length < i) {
				printFloor(columnSize, 0);
			} else {
				printFloor(columnSize, (Integer) middle[--middleIndex]);
			}
			
			//print right
			if (right.length < i) {
				printFloor(columnSize, 0);
			} else {
				printFloor(columnSize, (Integer) right[--rightIndex]);
			}
			System.out.println();
			System.out.println("  ");		
			
		}
	}
	
	public static void printFloor(int width, int n) {
		if (n == 0) {
			for (int i = 0; i < width; i++) {
				System.out.print(" ");
			}
		} else {
			int spaceNum = (width - n) / 2;
			for (int i = 0; i < spaceNum; i++) {
				System.out.print(" ");
			}
			for (int i = 0; i < n; i++) {
				System.out.print("#");
			}
			for (int i = 0; i < spaceNum; i++) {
				System.out.print(" ");
			}
		}
	}

}
