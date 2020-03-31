package Logic;

public class UploadException extends Exception{
	private String message;
	public UploadException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
