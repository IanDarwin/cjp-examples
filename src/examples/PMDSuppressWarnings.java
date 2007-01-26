package badcode;

public abstract class PMDSuppressWarnings { // NOPMD

	public static String MESSAGE1 = "Hello";	// NOPMD

	@SuppressWarnings("PMD.SuspiciousConstantFieldName")
	public static String MESSAGE2 = "Hello";
}
