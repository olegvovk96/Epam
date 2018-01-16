package main;

import java.util.Random;

public class Wrapper {

	private final int lengthMatrix = 4;
	private Integer[][] matrix;
	
	public Wrapper(){
		this.matrix = new Integer[this.lengthMatrix][this.lengthMatrix];
		createMatrix();
	}
	
	private void createMatrix(){
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(j > i){
					matrix[i][j] = rand.nextInt(10) + 1;
				} else if(i > j){
					matrix[i][j] = rand.nextInt(11) + 10;
				} else{
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	private void amountAboveMainDiagonal(){
		Integer amountAboveDiagonal = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(j > i){
					amountAboveDiagonal += matrix[i][j];
				}
			}
		}
		System.out.println("Amount above main diagonal: " + amountAboveDiagonal);
	}
	
	private void amountUnderMainDiagonal(){
		Integer amountUnderDiagonal = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(i > j){
					amountUnderDiagonal += matrix[i][j];
				}
			}
		}
		System.out.println("Amount under main diagonal: " + amountUnderDiagonal);
	}
	
	public void printMatrix(){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		amountAboveMainDiagonal();
		amountUnderMainDiagonal();
	}
	

	public static void main(String[] args) {
		Wrapper matrix = new Wrapper();
		matrix.printMatrix();
	}

}
