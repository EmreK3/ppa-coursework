public class MarkExams {
	public static void main(String[] args) {
		NumericalQuestion nqMarkScheme = new NumericalQuestion(48055, 10);
		BooleanQuestion bqMarkScheme = new BooleanQuestion(true, 1);
		MultipleChoiceQuestion mcqMarkScheme = new MultipleChoiceQuestion(false, false, true, 3);
		Exam markScheme = new Exam(nqMarkScheme, bqMarkScheme, mcqMarkScheme, 14);

		NumericalQuestion nqAttempt = new NumericalQuestion(4022, 0);
		BooleanQuestion bqAttempt = new BooleanQuestion(true, 0);
		MultipleChoiceQuestion mcqAttempt = new MultipleChoiceQuestion(true, false, false, 0);
		Exam examAttempt = new Exam(nqAttempt, bqAttempt, mcqAttempt, 0);

		Marker marker = new Marker();
		marker.markAttempt(examAttempt, markScheme);
		examAttempt.setTotalMarks(marker.getTotalMarkForAttempt());
		System.out.println("Total marks awarded for this attempt: " + examAttempt.getTotalMarks());
		double classification = marker.convertMarksToClassification(marker.getTotalMarkForAttempt());
		System.out.println("Final grade: " + classification);
	}
}