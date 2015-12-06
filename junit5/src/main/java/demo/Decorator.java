package demo;

public class Decorator {

	private String modernOrnament = "++";
	private String classicOrnament = "--";

	private static final String THEME_MODERN = "modern";
	private static final String THEME_CLASSIC = "classic";
	private static final String DEFAULT_THEME = THEME_MODERN;

	public Decorator() {
		// defaults
	}

	public Decorator(String mod, String old) {
		modernOrnament = mod;
		classicOrnament = old;
	}

	public String decorate(String text) {
		return decorate(text, DEFAULT_THEME);
	}

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
