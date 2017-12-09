package gaussian_blur;

import java.awt.image.BufferedImage;

public class GaussianBlur {
	// The mask used for the blur
	private int[][] mask = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
	// The Picture representation of the image supplied by the user
	private Picture image;
	// The resulting BufferedImage with Gaussian blur applied
	private BufferedImage resultImage;
	
	public GaussianBlur(BufferedImage image) {
		this.image = new Picture(image);
	    resultImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
	}
	
	public int calcWeightedValueCenter(int x, int y) {
	    int div = mask[0][0] + mask[0][1] + mask[0][2] + mask[1][0] + mask[1][1] + mask[1][2] + mask[2][0] + mask[2][1] + mask[2][2];
	    int red = (image.getPixelRedValue(x - 1, y - 1) * mask[0][0]+
		    	image.getPixelRedValue(x, y - 1) * mask[0][1] +
		    image.getPixelRedValue(x + 1, y - 1) * mask[0][2] +
		    image.getPixelRedValue(x - 1, y) * mask[1][0] +
		    image.getPixelRedValue(x, y) * mask[1][1] +
		    image.getPixelRedValue(x + 1, y) * mask[1][2] +
		    image.getPixelRedValue(x - 1, y + 1) * mask[2][0] +
		    image.getPixelRedValue(x, y + 1) * mask[2][1] +
		    image.getPixelRedValue(x + 1, y + 1) * mask[2][2]) / div;
	// TODO: calculate green component
	// TODO: calculate blue component
	int rgbValue = red * 65536 + green * 256 + blue; return rgbValue;
	}
	
	/**
	 * Mode 1: top left corner
	 * Mode 2: top right corner
	 * Mode 3: bottom right corner
	 * Mode 4: bottom left corner
	 */
	public int calcWeightedValueCorner(int x, int y, int mode) { // TODO: implement this method
	}
	
	/**
	 * Mode 1: top edge
	 * Mode 2: right edge
	 * Mode 3: bottom edge
	 * Mode 4: left edge
	 */
	public int calcWeightedValueEdge(int x, int y, int mode) { // TODO: implement this method
	}
	
	public BufferedImage applyFilter() { // TODO: implement this method // for (each row)
	/*
	 * for (each row)
	 * 		for (each col)
	 * 			check where in the matrix we are
	 * 				resultImage.setRGB(column, row, applyMask(column, row))		
	 */
	
	return resultImage;
	}
}
