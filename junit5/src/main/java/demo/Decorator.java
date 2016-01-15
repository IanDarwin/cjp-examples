package demo;

/**
 * This is a very silly Decorator that just prepends and appends
 * a few characters to a string; it makes a good small self-contained
 * demo, though its practicality in the wild has yet to be proven :-).
 * The prefix/suffix is determined by the "theme"; modern and classic
 * are the only supported themes at present.
 * Themes are Strings, not enum, to allow later user-defined themes.
 */
public class Decorator {

	private String modernOrnament = "++";
	private String classicOrnament = "--";

	private static final String THEME_MODERN = "modern";
	private static final String THEME_CLASSIC = "classic";
	private static final String DEFAULT_THEME = THEME_MODERN;

	public Decorator() {
		// defaults
	}

	/** This constructor allows for different strings to be used in
	 * each of the two themes.
	 * @param modern The appendable for the Modern theme.
	 * @param classic The appendable for Classic. 
	 */
	public Decorator(String modern, String classic) {
		modernOrnament = modern;
		classicOrnament = classic;
	}

	public String decorate(String text) {
		return decorate(text, DEFAULT_THEME);
	}

	/**
	 * Decorates the text with the chosen theme.
	 * @param text The text to be decorated
	 * @param theme The theme to use, chosen from THEME_MODERN or THEME_CLASSIC.
	 * @return
	 * @throws IllegalArgumentException if the theme isn't recognized
	 */
	public String decorate(String text, String theme) {
		switch (theme.toLowerCase()) {
			case THEME_MODERN: 
				return modernOrnament + " " + text + " " + modernOrnament;
			case THEME_CLASSIC:
				return classicOrnament + " " + text + " " + classicOrnament;
			default:
				throw new IllegalArgumentException("Unknown theme");
		}
	}

	public String toString() {
		return "Decorator(" + modernOrnament + "," + classicOrnament + ")";
	}
}
