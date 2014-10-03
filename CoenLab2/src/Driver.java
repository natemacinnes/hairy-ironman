import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import com.atul.JavaOpenCV.Imshow;

public class Driver {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		ArrayList<int[]> GSimage = readTxt("Grayscale Image Data.txt");
		ArrayList<int[]> Bimage = readTxt("Binary Image Data.txt");
		ArrayList<int[]> S1image = readTxt("Slanted1Image-156x119.txt");
		ArrayList<int[]> S4image = readTxt("Slanted4Image-199x159.txt");
		ArrayList<int[]> S7image = readTxt("Slanted7Image-133x106.txt");

		System.out.println();

		//printImageCV(S1image);
		printImageCV(slantCorrection(S1image));
		System.out.println();
		//printImageCV(S4image);
		//System.out.println();
		//printImageCV(S7image);
		//System.out.println();

		// smootherGS(GSimage);
	}

//	private static ArrayList<int[]> slantCorrection(ArrayList<int[]> imageOriginal) {
//		double m00 = 0, m01 = 0, m10 = 0, Mu11 = 0, Mu02 = 0, xc = 0, yc = 0;
//		double tan = 0, teta = 0;
//		int row = imageOriginal.get(0).length, col = imageOriginal.size();
//		int max = 0;
//		int min = 0;
//		int xNew = 0;
//		
//		ArrayList<int[]> imageCorrected = new ArrayList<int[]>();
//		ArrayList<int[]> imageInverted = new ArrayList<int[]>();
//
//		System.out.println("xc: " + xc);
//		System.out.println("yc: " + yc);
//		
//		imageInverted = invertImage(imageOriginal);
//		System.out.println("row: " + row + "col: " + col);
//		printImageCV(imageInverted);
//
//		
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				m00 = m00 + imageInverted.get(i)[j];
//				m01 = m01 + j * imageInverted.get(i)[j];
//				m10 = m10 + i * imageInverted.get(i)[j];
//			}
//		}
//
//		xc = m10 / m00;
//		yc = m01 / m00;
//		
//		System.out.println("xc: " + xc);
//		System.out.println("yc: " + yc);
//		
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				Mu11 = Mu11 + (i - xc) * (j - yc) * imageInverted.get(i)[j];
//				Mu02 = Mu02 + Math.pow(j - yc, 2) * imageInverted.get(i)[j];
//			}
//		}
//		
//		tan = -Mu11/Mu02;
//		teta = (180/Math.PI)*Math.atan(tan);
//		
//		System.out.println();
//		System.out.println("tan: " + tan);
//		System.out.println("teta: " + teta);
//		
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++){
//				int a = (int) (i - (j - yc)*tan);
//				if (a > max) {
//					max = a;
//				}
//				if (a < min)
//					min = a;
//			}
//		}
//		
//		int row_new = row;
//		int col_new = col;
//		
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				xNew = (int) (i - ((j - yc)*tan));
//				if (xNew >= 0 && xNew < row) {
//					imageCorrected.get((int) xNew)[j] = imageOriginal.get(i)[j];
//				}		
//			}
//		}
//		
//		return imageCorrected;
//	}


	public static ArrayList<int[]> convert_ArrayListofArraysOfChars_To_ArrayListofArraysOfInt(
			ArrayList<char[]> originalArray) {

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
	
//	public static ArrayList<int[]> convert_ArrayListofArraysOfChars_To_ArrayListofArraysOfInt(ArrayList<char[]> originalArray) {
//
//		ArrayList<int[]> convertedArray = new ArrayList<int[]>();
//
//		for (char[] rowOfChars : originalArray) {
//
//			int[] rowOfInts = new int[rowOfChars.length];
//
//			for (int i = 0; i < rowOfChars.length; i++) {
//
//				rowOfInts[i] = Character.getNumericValue(rowOfChars[i]);
//
//			}
//
//			convertedArray.add(rowOfInts);
//
//		}
//
//		return convertedArray;
//
//	}


	private static ArrayList<int[]> slantCorrection(ArrayList<int[]> imageOriginal) {

		double m00 = 0, m01 = 0, m10 = 0, Mu11 = 0, Mu02 = 0, xc = 0, yc = 0;
		int imageY = imageOriginal.get(0).length, imageX = imageOriginal.size();

		ArrayList<int[]> imageCorrected = new ArrayList<int[]>();
		ArrayList<int[]> imageInverted = new ArrayList<int[]>();

		imageInverted = invertImage(imageOriginal);

		for (int i = 0; i < imageX; i++) {
			for (int j = 0; j < imageY; j++) {
				m00 = m00 + imageInverted.get(i)[j];//(j)[i];
				m01 = m01 + j * imageInverted.get(i)[j];//(j)[i];
				m10 = m10 + i * imageInverted.get(i)[j];//(j)[i];
			}
		}

		xc = m10 / m00;
		yc = m01 / m00;

		for (int i = 0; i < imageX; i++) {
			for (int j = 0; j < imageY; j++) {
				Mu11 = Mu11 + (i - xc) * (j - yc) * imageInverted.get(i)[j];//(j)[i];
				Mu02 = Mu02 + Math.pow(j - yc, 2) * imageInverted.get(i)[j];//(j)[i];
			}
		}

		double tan = -Mu11 / Mu02;
		double teta = (180 / Math.PI) * Math.atan(tan);
		// double x_new;

		int max = 0, min = 0;

		for (int i = 0; i < imageX; i++)
			for (int y = 0; y < imageY; y++) {
				int a = (int) (i - (y - yc) * tan);
				if (a > max)
					max = a;
				if (a < min)
					min = a;
			}

		// int row_new = max - min +1;
		// int col_new = col ;

		int row_new = imageX;
		int col_new = imageY;

		ArrayList<int[]> new_image = new ArrayList<int[]>();// row_new was the
															// size of a row in
															// the image (i.e.
															// imageX).
		for (int i = 0; i < row_new; i++)
			// new_image.set(i, new int[col_new]); // we'd have to initialize
			// the array if we do this.
			new_image.add(new int[col_new]);

		for (int i = 0; i < row_new; i++)
			for (int j = 0; j < col_new; j++)
				// new_image[i][j]=1;
				new_image.get(i)[j] = 1;

		for (int x = 0; x < imageX; x++)
			for (int y = 0; y < imageY; y++) {
				int x_new = (int) (x - ((y - yc) * tan));

				if (x_new >= 0 & x_new < imageX) { // imageX?
					// new_image[x_new][y]=matrix[x][y];
					int r = imageOriginal.get(x)[y];//(x)[y];// imageOriginal[x][y];
					new_image.get(x_new)[y] = r;
				// new_image[x_new - min][y]=matrix[x][y];
				}
			}

		// int sum1 = 0, sum2 = 0;
		// for (int x = 0; x < imageX; x++)
		// for (int y = 0; y < imageY; y++) {
		// sum1 = sum1 + imageOriginal.get(x)[y];
		// sum2 = sum2 + imageOriginal.get(x)[y];
		// }

		// cout<<"\n new image : "<<sum1<<" original image : "<<sum2<<endl;
		
		return new_image;

	}

//	public static ArrayList<int[]> invertImage(ArrayList<int[]> imageOriginal) {
//		ArrayList<int[]> imageInverted = new ArrayList<int[]>();
//		int[] invertedRow = new int[imageOriginal.get(0).length];
//
//		for (int i = 0; i < imageOriginal.size(); i++) {
//			for (int j = 0; j < imageOriginal.get(i).length; j++) {
//				invertedRow[j] = (1 - imageOriginal.get(i)[j]);
//			}
//			imageInverted.add(invertedRow);
//		}
//
//		return imageInverted;
//	}
	
	public static ArrayList<int[]> invertImage(ArrayList<int[]> imageOriginal) {
		ArrayList<int[]> imageInverted = new ArrayList<int[]>();
		int[] invertedRow = new int[imageOriginal.get(0).length];
		int row = imageOriginal.get(0).length;
		int col = imageOriginal.size();
		
		
		for (int i = 0; i < imageOriginal.size(); i++) {

			for (int j = 0; j < imageOriginal.get(0).length; j++) {
				int[] emptyRow = new int[row];
				emptyRow[j] = -1;
				imageInverted.add(emptyRow);
			}
		}
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				
				imageInverted.get(i)[j] = (1 - imageOriginal.get(i)[j]);
			}
		}
		
		return imageInverted;
	}

	// Smooths grayscale images matrices using 1/16 wighted mask
	private void smootherGS(ArrayList<int[]> imageOriginal) {
		ArrayList<int[]> imageCleaned = new ArrayList<int[]>();

		// Prints original image for reference
		// printImage(imageOriginal);

		System.out.println();

		for (int i = 0; i < imageOriginal.size(); i++) {

			for (int j = 0; j < imageOriginal.get(0).length; j++) {
				int[] emptyRow = new int[imageOriginal.get(0).length];
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

	
	private static void printImageCV(ArrayList<int[]> imageOriginal) {
		int row = imageOriginal.get(0).length;
		int col = imageOriginal.size();
				System.out.println("row: " + row + "col: " + col);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat img = Mat.eye(row, col, CvType.CV_8UC1);
		for (int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				img.put(i, j, imageOriginal.get(i)[j]*255);
			}
		}
		
		System.out.println("row: " + row + "col: " + col);
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