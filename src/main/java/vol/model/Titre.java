package vol.model;

public enum Titre {
	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");

	private final String label;

	private Titre(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
