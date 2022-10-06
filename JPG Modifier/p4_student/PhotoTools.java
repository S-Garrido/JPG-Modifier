package p4_student;

import cmsc131PhotoLibrary.Photograph;
import cmsc131PhotoLibrary.Pixel;

/**
 * The methods in this class are to be implemented by you.  
 * This class starter file provides various static methods that take 
 * a photograph and produce a new one based on it, but with various 
 * modifications.
 * 
 * See the project description for details of method implementations.
 * 
 * @author PUT YOUR NAME HERE
 *
 */
public class PhotoTools {


	//This method is provided as a starting point.  Please read through
	//  it and think about what it does and why - if you aren't sure of
	//  something, ask us in office hours.  
	//Do not alter this code.  It is used by the GUI.
	public static Photograph copy(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt());
		for (int x=0; x<photo.getWd(); x++) {
			for (int y=0; y<photo.getHt(); y++) {
				newPhoto.setPixel(x, y, photo.getPixel(x, y));
			}
		}
		return newPhoto;
	}






	public static Photograph isolateColor(Photograph photo, int type) {
	Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt());
			if (type == 0) {
				for (int i = 0; i < photo.getWd(); i ++) {
					for (int j =0; j<photo.getHt(); j++) {
					 Pixel oldPixel = photo.getPixel(i, j);
						int red = oldPixel.getRed();
						Pixel newPixel = new Pixel( red, 0, 0);
					newPhoto.setPixel(i, j,	newPixel);
					}
				}
			}
			else if (type == 1) {	//same code as case 0 but with green instead of red
				for (int i = 0; i < photo.getWd(); i ++) {
					for (int j =0; j<photo.getHt(); j++) {
					 Pixel oldPixel = photo.getPixel(i, j);
						int blue = oldPixel.getBlue();
						Pixel newPixel = new Pixel( 0, 0, blue);
					newPhoto.setPixel(i, j,	newPixel);
					}
				}
			}
			else if (type == 2) { //same as other 2 except with green
				for (int i = 0; i < photo.getWd(); i ++) {
					for (int j =0; j<photo.getHt(); j++) {
					 Pixel oldPixel = photo.getPixel(i, j);
						int green = oldPixel.getGreen();
						Pixel newPixel = new Pixel( 0, green, 0);
					newPhoto.setPixel(i, j,	newPixel);
					}
				}
			}
			return newPhoto;
	}





	public static Photograph makeGrayscale(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt()); //Same method as isolateColor except using the grey equation provided for the RGB values
		for (int i = 0; i < photo.getWd(); i ++) {
			for (int j =0; j<photo.getHt(); j++) {
			 Pixel oldPixel = photo.getPixel(i, j);
				int grayscale = (int) (oldPixel.getRed()* 0.6)+(int)(oldPixel.getGreen() * 0.2) + (int)(oldPixel.getBlue() * 0.2);
				Pixel newPixel = new Pixel( grayscale,grayscale,grayscale);
			newPhoto.setPixel(i, j,	newPixel);
			}
		}
		return newPhoto;
	}



	public static Photograph makeArtistic(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt()); // just like previous 2 methods except checking for specific cases to modify colors
		for (int i = 0; i < photo.getWd(); i ++) {
			for (int j =0; j<photo.getHt(); j++) {
			 Pixel oldPixel = photo.getPixel(i, j);
				if (oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() < 192) {
				Pixel newPixel = new Pixel(0,0,0);
			newPhoto.setPixel(i, j,	newPixel);
			}
				else if (oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() < 344 && oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() > 191 ) {
					Pixel newPixel = new Pixel(63, 63, 63);
					newPhoto.setPixel(i, j,	newPixel);
					}
				else if (oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() < 576 && oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() > 343 ) {
					Pixel newPixel = new Pixel(127, 127, 127);
					newPhoto.setPixel(i, j,	newPixel);
					}
				else if (oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() < 766 && oldPixel.getRed() + oldPixel.getGreen()+ oldPixel.getBlue() > 575 ) {
					Pixel newPixel = new Pixel(255, 255, 255);
					newPhoto.setPixel(i, j,	newPixel);
					}
			}
		}
		return newPhoto;
	}
	
	
	public static Photograph gradientFilter(Photograph photo) {
		throw new RuntimeException("Do NOT implement this...");
	}


	public static Photograph censorIt(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt());
		for (int a = 0; a < newPhoto.getWd() ; a = a + 10 ) { //every regular "sensor blur" is 10 pixels, this makes sure the program doesn't check pixels that have been altered already in a "blur"
			for (int b = 0; b < newPhoto.getHt(); b = b + 10) {
				
				if((newPhoto.getWd() - a > 0 && newPhoto.getWd() - a < 10 ) && (newPhoto.getHt() - b > 0 && newPhoto.getHt() - b < 10) ) { // if there is less than 10 available pixels left both horizontally and vertically
					for (int x = 0; x < newPhoto.getWd() - a; x++ ) {
						for (int y =0; y <newPhoto.getHt()-b; y++) {
							int sumRed = 0;
							int sumGreen = 0;
							int sumBlue = 0;
								for (int i = 0; i < newPhoto.getWd() - a; i ++) {
									for (int j =0; j<newPhoto.getHt() - b ; j++) { 
										Pixel oldPixel = photo.getPixel(i, j+b);
										sumRed = sumRed +  oldPixel.getRed();
										sumGreen = sumGreen +  oldPixel.getGreen();
										sumBlue = sumBlue +  oldPixel.getBlue();
						}
					}
								Pixel newPixel = new Pixel(sumRed/((newPhoto.getHt() - b) * (newPhoto.getWd() - a)), sumGreen/((newPhoto.getHt() - b) * (newPhoto.getWd() - a)), sumBlue/((newPhoto.getHt() - b) * (newPhoto.getWd() - a)));
								newPhoto.setPixel(x+a, y+b,	newPixel);
						}
					}
				} 
				else if((newPhoto.getWd() - a > 0 && newPhoto.getWd() - a < 10 )) { // if there is less than 10 available pixels left horizontally
					for (int x = 0; x < newPhoto.getWd() - a; x++ ) {
						for (int y =0; y <newPhoto.getHt()-b; y++) {
							int sumRed = 0;
							int sumGreen = 0;
							int sumBlue = 0;
								for (int i = 0; i < newPhoto.getWd() - a; i ++) {
									for (int j =0; j<10 ; j++) {
										Pixel oldPixel = photo.getPixel(i, j + b);
										sumRed = sumRed +  oldPixel.getRed();
										sumGreen = sumGreen +  oldPixel.getGreen();
										sumBlue = sumBlue +  oldPixel.getBlue();
						}
					}
								Pixel newPixel = new Pixel(sumRed/(10 * (newPhoto.getWd()- a)), sumGreen/(10 * (newPhoto.getWd()- a)), sumBlue/(10 * (newPhoto.getWd()- a)));
								newPhoto.setPixel(x+a, y+b,	newPixel);
						}
					}
				} 
				else if ((newPhoto.getHt() - b > 0 && newPhoto.getHt() - b < 10) ) {//if there are less than 10 available pixels left vertically
					for (int x = 0; x < newPhoto.getWd() - a; x++ ) {
						for (int y =0; y <newPhoto.getHt()-b; y++) {
							int sumRed = 0;
							int sumGreen = 0;
							int sumBlue = 0;
								for (int i = 0; i < 10; i ++) {
									for (int j =0; j<newPhoto.getHt()-b ; j++) {
										Pixel oldPixel = photo.getPixel(i+a, j+b);
										sumRed = sumRed +  oldPixel.getRed();
										sumGreen = sumGreen +  oldPixel.getGreen();
										sumBlue = sumBlue +  oldPixel.getBlue();
						}
					}
								Pixel newPixel = new Pixel(sumRed/(10 * (newPhoto.getHt() - b)), sumGreen/(10 * (newPhoto.getHt() - b)), sumBlue/(10 * (newPhoto.getHt() - b)));
								newPhoto.setPixel(x+a, y+b,	newPixel);
						}
					}
					
					
				}
				else { //There is at least one 10x10 pixels area left
		for (int x = 0; x < 10; x++ ) {
			for (int y =0; y <10; y++) {
				int sumRed = 0;
				int sumGreen = 0;
				int sumBlue = 0;
					for (int i = 0; i < 10; i ++) {
						for (int j =0; j<10; j++) {
							Pixel oldPixel = photo.getPixel(i+a, j+b);
							sumRed = sumRed +  oldPixel.getRed();
							sumGreen = sumGreen +  oldPixel.getGreen();
							sumBlue = sumBlue +  oldPixel.getBlue();
			}
		}
					Pixel newPixel = new Pixel(sumRed/100, sumGreen/100, sumBlue/100);
					newPhoto.setPixel(x+a, y+b,	newPixel);
			}
		}
				}
			}
		}
		return newPhoto;
	}


	public static Photograph stretched(Photograph photo, int type) {
		Photograph newPhoto = null;
		if (type == 0) {
			newPhoto = new Photograph(2 * photo.getWd(), photo.getHt()); // double canvas size
			for (int y=0; y<photo.getHt(); y++) {
				int adjustment = 1;
				for (int x=0; x<photo.getWd(); x++) {
					newPhoto.setPixel(x + adjustment, y, photo.getPixel(x, y)); // every original pixel will have a a copy of that pixel on the same row in the column that is equal to the original column + the adjustment
					newPhoto.setPixel(x*2, y, photo.getPixel(x, y)); // every original pixel will have a copy of that pixel on the same row in the column that is twice the original columns value
					adjustment = adjustment + 1;	
				}
			}
		}
		else if (type == 1){
			int height = 2 * photo.getHt();
			newPhoto = new Photograph(photo.getWd(), height);
			for (int x=0; x<photo.getWd(); x++) {// double canvas size
				int adjustment = 1;
				for (int y=0; y<photo.getHt(); y++) {
					newPhoto.setPixel(x, y + adjustment, photo.getPixel(x, y));// every original pixel will have a a copy of that pixel in the same column on the row that is equal to the original row + the adjustment
					newPhoto.setPixel(x, y * 2, photo.getPixel(x, y));// every original pixel will have a copy of that pixel in the same column on the row that is twice the original rows value
					adjustment = adjustment + 1;	
				}
			}
		}
		return newPhoto;
	}



	public static Photograph mirrorIt(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt());
		for (int x=0; x<photo.getWd(); x++) {
			for (int y=0; y<photo.getHt(); y++) {
				newPhoto.setPixel(x, y, photo.getPixel(photo.getWd() -1 - x, y)); //Just like the copy method except placing the pixels from right to left
			}
		}
		return newPhoto;
	}



	public static Photograph makeDoubleWithMirror(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd() * 2, photo.getHt()); 
		for (int x=0; x<photo.getWd(); x++) {
			for (int y=0; y<photo.getHt(); y++) {
				newPhoto.setPixel(x, y, photo.getPixel(photo.getWd() -1 - x, y)); //mirrored image on left
			}
		}
		for (int x=0; x<photo.getWd(); x++) {
			for (int y=0; y<photo.getHt(); y++) {
				newPhoto.setPixel(x + photo.getWd() , y, photo.getPixel(x, y)); // regular image on right
			}
		}
		return newPhoto;
	}


	public static Photograph rotated(Photograph photo) {
		throw new RuntimeException("Do NOT implement this...");
	}

	public static Photograph upsideDown(Photograph photo) {
		throw new RuntimeException("Do NOT implement this...");

	}
	
	
	

	public static Photograph wacky(Photograph photo) {
		throw new RuntimeException("Do NOT implement this...");

		
	}



}
