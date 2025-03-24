/*You are designing an image processing tool that needs a function to convert RGB color values to grayscale using bitwise operations.
Write a method that takes (red, green, blue) values (0-255) and converts them into a single grayscale value using the formula: grayscale=0.3R+0.59G+0.11Bgrayscale = 0.3R + 0.59G + 0.11Bgrayscale=0.3R+0.59G+0.11B 
Ensure efficient calculations using bitwise operations.*/

public class Main {
	public static int toGrayscale(int r, int g, int b) {
		return (r * 77 + g * 150 + b * 29) >> 8;
	}
	public static void main(String[] args) {
		System.out.println("Grayscale: " + toGrayscale(255, 108, 50));
	}

}
