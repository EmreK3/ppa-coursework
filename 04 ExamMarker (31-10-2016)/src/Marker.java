public class Marker {
	private int totalMarkForAttempt;
	private int markForAttempt;
	private int markForQuestion;

	public int markAttempt(Exam examAttempt, Exam markScheme) {
		totalMarkForAttempt += compareFirstQuestion(examAttempt.getQuestionOne(), markScheme.getQuestionOne());
		System.out.println("Question 1: " + markForAttempt + " out of " + markForQuestion);
		totalMarkForAttempt += compareSecondQuestion(examAttempt.getQuestionTwo(), markScheme.getQuestionTwo());
		System.out.println("Question 2: " + markForAttempt + " out of " + markForQuestion);
		totalMarkForAttempt += compareThirdQuestion(examAttempt.getQuestionThree(), markScheme.getQuestionThree());
		System.out.println("Question 3: " + markForAttempt + " out of " + markForQuestion);
		return totalMarkForAttempt;
	}

	public int compareFirstQuestion(NumericalQuestion examAttempt, NumericalQuestion markScheme) {
		markForQuestion = markScheme.getNumericalMark();
		if(examAttempt.getNumericalAnswer() == markScheme.getNumericalAnswer()) {
			markForAttempt = markScheme.getNumericalMark();
		} else if((examAttempt.getNumericalAnswer() == (markScheme.getNumericalAnswer() - 1)) || (examAttempt.getNumericalAnswer() == markScheme.getNumericalAnswer() + 1)) {
			markForAttempt = (markScheme.getNumericalMark() - 1);
		} else if((examAttempt.getNumericalAnswer() == (markScheme.getNumericalAnswer() - 5)) || (examAttempt.getNumericalAnswer() == markScheme.getNumericalAnswer() + 5)) {
			markForAttempt = 1;
		} else {
			markForAttempt = 0;
		}
		return markForAttempt;
	}

	public int compareSecondQuestion(BooleanQuestion examAttempt, BooleanQuestion markScheme) {
		markForQuestion = markScheme.getBoolMark();
		if(examAttempt.getBoolAnswer() == markScheme.getBoolAnswer()) {
			markForAttempt = markScheme.getBoolMark();
		} else {
			markForAttempt = 0;
		}
		return markForAttempt;
	}

	public int compareThirdQuestion(MultipleChoiceQuestion examAttempt, MultipleChoiceQuestion markScheme) {
		markForQuestion = markScheme.getMcqMark();
		markForAttempt = 0;
		if(examAttempt.getFirstOption() == markScheme.getFirstOption()) {
			markForAttempt += 1;
		} else if(examAttempt.getSecondOption() == markScheme.getSecondOption()) {
			markForAttempt += 1;
		} else if(examAttempt.getThirdOption() == markScheme.getThirdOption()) {
			markForAttempt += 1;
		}
		return markForAttempt;
	}

	public int getTotalMarkForAttempt() {
		return totalMarkForAttempt;
	}

	public double convertMarksToClassification(int marks) {
		int firstBoundary = 11;
		int upperSecondBoundary = 9;
		int lowerSecondBoundary = 6;
		double classification;

		if(marks >= firstBoundary) {
			classification = 1.1;
		} else if(marks >= upperSecondBoundary) {
			classification = 2.1;
		} else if(marks >= lowerSecondBoundary) {
			classification = 2.2;
		} else {
			classification = 0.0;
		}

		return classification;
	}
}