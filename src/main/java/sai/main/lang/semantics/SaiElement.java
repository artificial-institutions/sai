package sai.main.lang.semantics;

public abstract class SaiElement {

	private String metadata = "";

	public SaiElement() {
		super();
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	
}
