package salesReport_v1;

public class HolidayBonus {

	public static double[] calculateHolidayBonus(double[][] inputArray, double high, double low, double other) {
		double total = 0;
		double[] salesDataInfo = new double[inputArray.length];

		for (int row = 0; row < inputArray.length; row++) {
			total = 0;
			for (int col = 0; col < inputArray[row].length; col++) {
				if (inputArray[row][col] < 0) {
					total += 0;
				} else {
					if (row == TwoDimRaggedArrayUtility.getHighestInColumnIndex(inputArray, col)) {
						{
							total += high;
						}

					} else if (row == TwoDimRaggedArrayUtility.getLowestInColumnIndex(inputArray, col)) {
						{
							total += low;
						}
					} else {
						total += other;
					}
				}
				salesDataInfo[row] = total;

			}

		}

		return salesDataInfo;
	}

	public static double calculateTotalHolidayBonus(double inputArray[][], double high, double low, double other) {
		double holidaySum = 0.0;
		double bonus[] = HolidayBonus.calculateHolidayBonus(inputArray, high, low, other);

		for (int row = 0; row < bonus.length; row++) {
			holidaySum += bonus[row];
		}

		return holidaySum;
	}
}
