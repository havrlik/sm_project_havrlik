package main.java.project.havrlik.soft.smlib.other;


/*
 * Application window frame dimensions: width ; height.
 */

public enum GuiFrameDimension {
	
	// Various heights for the width.
	SIZE_640x480(new int[] {640, 480}),  // '4:3 - 1.333'.
	SIZE_640x420(new int[] {640, 420}),  // '1,524'.
	SIZE_640x400(new int[] {640, 400}),  // '8:5 - 1.6'.
	SIZE_640x360(new int[] {640, 360}),  // '16:9 - 1.777'.
	SIZE_960x720(new int[] {960, 720}),  // '4:3 - 1.333'.
	SIZE_960x640(new int[] {960, 640}),  // '3:2 - 1.5'.
	SIZE_640x600(new int[] {960, 600}),  // '8:5 - 1.6'.
	SIZE_960x540(new int[] {960, 540}),  // '16:9 - 1.777'.
	SIZE_1280x960(new int[] {1280, 960}),  // '4:3 - 1.333'.
	SIZE_1280x860(new int[] {1280, 860}),  // '1,488'.
	SIZE_1280x800(new int[] {1280, 800}),  // '8:5 - 1.6'.
	SIZE_1280x720(new int[] {1280, 720}),  // '16:9 - 1.777'.
	SIZE_1920x1440(new int[] {1920, 1440}),  // '4:3 - 1.333'.
	SIZE_1920x1280(new int[] {1920, 1280}),  // '3:2 - 1.5'.
	SIZE_1920x1200(new int[] {1920, 1200}),  // '8:5 - 1.6'.
	SIZE_1920x1080(new int[] {1920, 1080}),  // '16:9 - 1.777'.
	SIZE_2880x2160(new int[] {2880, 2160}),  // '4:3 - 1.333'.
	SIZE_2880x1920(new int[] {2880, 1920}),  // '3:2 - 1.5'.
	SIZE_2880x1800(new int[] {2880, 1800}),  // '8:5 - 1.6'.
	SIZE_2880x1620(new int[] {2880, 1620}),  // '16:9 - 1.777'.
	SIZE_3840x2880(new int[] {3840, 2880}),  // '4:3 - 1.333'.
	SIZE_3840x2560(new int[] {3840, 2560}),  // '3:2 - 1.5'.
	SIZE_3840x2400(new int[] {3840, 2400}),  // '8:5 - 1.6'.
	SIZE_3840x2160(new int[] {3840, 2160}),  // '16:9 - 1.777'.
	
	// Various widths for the height.
//	SIZE_640x360(new int[] {640, 360}),  // '16:9 - 1.777'.
//	SIZE_640x480(new int[] {640, 480}),  // '4:3 - 1.333'.
	SIZE_720x480(new int[] {720, 480}),  // '3:2 - 1.5'.
	SIZE_768x480(new int[] {768, 480}),  // '8:5 - 1.7'.
//	SIZE_960x720(new int[] {960, 720}),  // '4:3 - 1.333'.
	SIZE_1080x720(new int[] {1080, 720}),  // '3:2 - 1.5'.
	SIZE_1152x720(new int[] {1152, 720}),  // '8:5 - 1.7'.
//	SIZE_1280x720(new int[] {1280, 720}),  // '16:9 - 1.777'.
	SIZE_1440x1080(new int[] {1440, 1080}),  // '4:3 - 1.333'.
	SIZE_1620x1080(new int[] {1620, 1080}),  // '3:2 - 1.5'.
	SIZE_1728x1080(new int[] {1728, 1080}),  // '8:5 - 1.7'.
//	SIZE_1920x1080(new int[] {1920, 1080}),  // '16:9 - 1.777'.
	SIZE_2160x1620(new int[] {2160, 1620}),  // '4:3 - 1.333'.
	SIZE_2430x1620(new int[] {2430, 1620}),  // '3:2 - 1.5'.
	SIZE_2592x1620(new int[] {2592, 1620}),  // '8:5 - 1.7'.
//	SIZE_2880x1620(new int[] {2880, 1620}),  // '16:9 - 1.777'.
//	SIZE_2880x2160(new int[] {2880, 2160}),  // '4:3 - 1.333'.
	SIZE_3240x2160(new int[] {3240, 2160}),  // '3:2 - 1.5'.
	SIZE_3456x2160(new int[] {3456, 2160}),  // '8:5 - 1.7'.
//	SIZE_3840x2160(new int[] {3840, 2160}),  // '16:9 - 1.777'.
	
//	// Custom.
	SIZE_1150x680(new int[] {1150, 680});  // Custom '1.691'.
//	
//	public static final int[] SIZE_DEFAULT = SIZE_1280x960;
	
//	public static int[] size_choosed = SIZE_DEFAULT;
	
	private final int[] dimensions;
	
	
	GuiFrameDimension(int[] dimensions) {
		this.dimensions = dimensions;
	}
	
	
	public int[] getDimensions() { return dimensions; }
	public int getWidth() { return dimensions[0]; }
	public int getHeight() { return dimensions[1]; }

}
