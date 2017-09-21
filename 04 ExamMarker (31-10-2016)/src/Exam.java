public class Exam {
	private NumericalQuestion question1;
	private BooleanQuestion question2;
	private MultipleChoiceQuestion question3;
	private int totalMark;

	public Exam(NumericalQuestion question1, BooleanQuestion question2, MultipleChoiceQuestion question3, int totalMark) {
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.totalMark = totalMark;
	}

	public void setTotalMarks(int addMarks) {
		totalMark += addMarks;
	}

	public int getTotalMarks() {
		return totalMark;
	}

	public NumericalQuestion getQuestionOne() {
		return question1;
	}

	public BooleanQuestion getQuestionTwo() {
		return question2;
	}

	public MultipleChoiceQuestion getQuestionThree() {
		return question3;
	}
}