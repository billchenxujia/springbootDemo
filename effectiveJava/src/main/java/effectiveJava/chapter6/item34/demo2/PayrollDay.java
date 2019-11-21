package effectiveJava.chapter6.item34.demo2;

/**
 * 
 * 类 @code(PayrollDay)
 *
 * <p>
 * 功能简介：
 * <p>
 * 策略枚举模式实现代码共享。 这个想法是将加班费计算移入私有嵌套枚举中，并将此策略枚举的实例传递给PayrollDay枚举的构造方法。
 * 然后，PayrollDay枚举将加班工资计算委托给策略枚举，从而无需在PayrollDay中实现switch语句或特定于常量的方法实现。
 * 虽然这种模式不如switch语句简洁，但它更安全，更灵活： 
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
enum PayrollDay {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

	private final PayType payType;

	PayrollDay(PayType payType) {
		this.payType = payType;
	}

	PayrollDay() {
		this(PayType.WEEKDAY);
	} // Default

	int pay(int minutesWorked, int payRate) {
		return payType.pay(minutesWorked, payRate);
	}

	// The strategy enum type
	private enum PayType {
		WEEKDAY {
			int overtimePay(int minsWorked, int payRate) {
				return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND {
			int overtimePay(int minsWorked, int payRate) {
				return minsWorked * payRate / 2;
			}
		};

		abstract int overtimePay(int mins, int payRate);

		private static final int MINS_PER_SHIFT = 8 * 60;

		int pay(int minsWorked, int payRate) {
			int basePay = minsWorked * payRate;
			return basePay + overtimePay(minsWorked, payRate);
		}
	}
}
