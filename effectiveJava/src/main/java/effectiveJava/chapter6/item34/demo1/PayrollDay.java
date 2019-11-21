package effectiveJava.chapter6.item34.demo1;

/**
 * 
 * 类 @code(PayrollDay)
 *
 * <p>
 * 功能简介：
 * <p>
 * 通过swich实现代码共享：这段代码无可否认是简洁的，但从维护的角度来看是危险的。
 * 假设你给枚举添加了一个元素，可能是一个特殊的值来表示一个假期，但忘记在switch语句中添加一个相应的case条件。
 * 该程序仍然会编译，但付费方法会默默地为工作日支付相同数量的休假日，与普通工作日相同
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
enum PayrollDay {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

	private static final int MINS_PER_SHIFT = 8 * 60;

	int pay(int minutesWorked, int payRate) {
		int basePay = minutesWorked * payRate;

		int overtimePay;
		switch (this) {
		case SATURDAY:
		case SUNDAY: // Weekend
			overtimePay = basePay / 2;
			break;
		default: // Weekday
			overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
		}

		return basePay + overtimePay;
	}
}
