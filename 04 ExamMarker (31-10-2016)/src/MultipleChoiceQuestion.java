public class MultipleChoiceQuestion {
	private boolean option1;
	private boolean option2;
	private boolean option3;
	private int mark;

	public MultipleChoiceQuestion(boolean option1, boolean option2, boolean option3, int mark) {
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.mark = mark;
	}

	public boolean getFirstOption() {
		return option1;
	}

	public boolean getSecondOption() {
		return option2;
	}

	public boolean getThirdOption() {
		return option3;
	}

	public int getMcqMark() {
		return mark;
	}
}