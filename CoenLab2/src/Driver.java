import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.*;

import com.atul.JavaOpenCV.Imshow;

public class Driver {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		//ArrayList<char[]> GSimage = readTxt("Grayscale Image Data.txt");
		//ArrayList<char[]> Bimage = readTxt("Binary Image Data.txt");
		ArrayList<int[]> S1image = readTxt("Slanted1Image-156x119.txt");
		//ArrayList<char[]> S4image = readTxt("Slanted4Image-199x159.txt");
		//ArrayList<char[]> S7image = readTxt("Slanted7Image-133x106.txt");

		System.out.println();

		printImageCV(S1image);
		System.out.println();
		// printImage(S4image);
		System.out.println();
		// printImage(S7image);
		System.out.println();

		// smootherGS(GSimage);
	}

	private void slantCorrection(ArrayList<char[]> imageOriginal) {
		double m00 = 0, m01 = 0, m10 = 0, Mu11 = 0, Mu02 = 0, xc = 0, yc = 0;
		int imageX = imageOriginal.get(0).length, imageY = imageOriginal.size();

		ArrayList<char[]> imageCorrected = new ArrayList<char[]>();
		ArrayList<char[]> imageInverted = new ArrayList<char[]>();

		imageInverted = invertImage(imageOriginal);

		for (int i = 0; i < imageX; i++) {
			for (int j = 0; j < imageY; j++) {
				m00 = m00 + imageInverted.get(j)[i];
				m01 = m01 + j * imageInverted.get(j)[i];
				m10 = m10 + i * imageInverted.get(j)[i];
			}
		}

		xc = m10 / m00;
		yc = m01 / m00;

		for (int i = 0; i < imageX; i++) {
			for (int j = 0; j < imageY; j++) {
				Mu11 = Mu11 + (i - xc) * (j - yc) * imageInverted.get(j)[i];
				Mu02 = Mu02 + Math.pow(j - yc, 2) * imageInverted.get(j)[i];
			}
		}

	}

	public ArrayList<char[]> invertImage(ArrayList<char[]> imageOriginal) {
		ArrayList<char[]> imageInverted = new ArrayList<char[]>();
		char[] invertedRow = new char[imageOriginal.get(0).length];

		for (int i = 0; i < imageOriginal.size(); i++) {
			for (int j = 0; j < imageOriginal.get(i).length; i++) {
				invertedRow[j] = (char) (1 - imageOriginal.get(i)[j]);
			}
			imageOriginal.add(invertedRow);
		}

		return imageInverted;
	}

	// Smooths grayscale images matrices using 1/16 wighted mask
	private void smootherGS(ArrayList<Integer[]> imageOriginal) {
		ArrayList<Integer[]> imageCleaned = new ArrayList<Integer[]>();

		// Prints original image for reference
		// printImage(imageOriginal);

		System.out.println();

		for (int i = 0; i < imageOriginal.size(); i++) {

			for (int j = 0; j < imageOriginal.get(0).length; j++) {
				Integer[] emptyRow = new Integer[imageOriginal.get(0).length];
				emptyRow[j] = -1;
				imageCleaned.add(emptyRow);
			}

			for (int j = 0; j < imageOriginal.get(i).length; j++) {
				try {
					imageCleaned.get(i - 1)[j - 1] = imageOriginal.get(i - 1)[j - 1] / 16;
					imageCleaned.get(i - 1)[j] = imageOriginal.get(i - 1)[j] / 8;
					imageCleaned.get(i - 1)[j + 1] = imageOriginal.get(i - 1)[j + 1] / 8;
					imageCleaned.get(i)[j - 1] = imageOriginal.get(i)[j - 1] / 16;
					imageCleaned.get(i)[j] = imageOriginal.get(i)[j] / 4;
					imageCleaned.get(i)[j + 1] = imageOriginal.get(i)[j + 1] / 8;
					imageCleaned.get(i + 1)[j - 1] = imageOriginal.get(i + 1)[j - 1] / 16;
					imageCleaned.get(i + 1)[j] = imageOriginal.get(i + 1)[j] / 8;
					imageCleaned.get(i + 1)[j + 1] = imageOriginal.get(i + 1)[j + 1] / 16;
				} catch (Exception e) {
					int row = imageOriginal.get(i)[j];
					imageCleaned.get(i)[j] = row;
				}
				System.out.print(imageCleaned.get(i)[j] + "\t");
			}
			System.out.println();
		}
	}

	private static ArrayList<int[]> readTxt(String filename)
			throws NumberFormatException, IOException {
		ArrayList<char[]> image = new ArrayList<char[]>();
		try {
			FileReader file = new FileReader(filename);
			@SuppressWarnings("resource")
			BufferedReader input = new BufferedReader(file);
			String row = null;

			while ((row = input.readLine()) != null) {
				String[] rowNums = row.split("\t");
				char[] tempArray = new char[rowNums.length];

				for (int i = 0; i < rowNums.length; i++) {
					tempArray[i] = (rowNums[i]).charAt(0);
				}
				image.add(tempArray);
			}
		} catch (java.io.FileNotFoundException e) {
			System.out
					.println("Error opening " + filename + ", ending program");
			System.exit(1);
		}
		
		ArrayList<int[]> intImage = convert_ArrayListofArraysOfChars_To_ArrayListofArraysOfInt(image);
		
		return intImage;
	}

	public static ArrayList<int[]> convert_ArrayListofArraysOfChars_To_ArrayListofArraysOfInt(ArrayList<char[]> originalArray) {

		ArrayList<int[]> convertedArray = new ArrayList<int[]>();

		for (char[] rowOfChars : originalArray) {

			int[] rowOfInts = new int[rowOfChars.length];

			for (int i = 0; i < rowOfChars.length; i++) {

				rowOfInts[i] = Character.getNumericValue(rowOfChars[i]);

			}

			convertedArray.add(rowOfInts);

		}

		return convertedArray;

	}
	
	private static void printImageCV(ArrayList<int[]> imageOriginal) {
		int row = imageOriginal.get(0).length;
		int col = imageOriginal.size();
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat img = Mat.eye(row, col, CvType.CV_8UC1);
		for (int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				img.put(i, j, imageOriginal.get(i)[j]*255);
			}
		}
		
		//debug print matrix
		//System.out.println(img.dump());
		Imshow im = new Imshow("image");
		im.showImage(img);
	
	}
	
	private static void printImage(ArrayList<char[]> imageOriginal) {
		for (int i = 0; i < imageOriginal.size(); i++) {
			for (int j = 0; j < imageOriginal.get(i).length; j++) {
				System.out.print(imageOriginal.get(i)[j] + "\t");
			}
			System.out.println();
		}
	}

}