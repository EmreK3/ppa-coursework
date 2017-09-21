public class BooleanQuestion {
	private boolean answer;
	private int mark;

	public BooleanQuestion(boolean answer, int mark) {
		this.answer = answer;
		this.mark = mark;
	}

	public boolean getBoolAnswer() {
		return answer;
	}

	public int getBoolMark() {
		return mark;
	}
}