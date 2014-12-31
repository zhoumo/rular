package mine.rular.model;

public class Browser {

	public static final String IE = "IE";

	public static final String FIREFOX = "FIREFOX";

	private String type;

	private String path;

	public String getType() {
		return type.trim();
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path.trim();
	}

	public void setPath(String path) {
		this.path = path;
	}
}
