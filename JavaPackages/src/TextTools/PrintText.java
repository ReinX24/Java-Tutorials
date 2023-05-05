package TextTools;

public class PrintText {

	String userText;

	public PrintText(String userText) {
		this.userText = userText;
	}

	public void printUpperCase() {
		System.out.println(this.userText.toUpperCase());
	}

	public void printLowerCase() {
		System.out.println(this.userText.toLowerCase());
	}

}
