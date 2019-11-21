package myDateUtils.demo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static java.time.format.DateTimeFormatter.*;
/**
 * 
 * 类 @code(NewTimeDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 日常时间操作使用演示
 * <p>
 * 1、构造对应时间对象，使用 .now()  .parse() ;
 * <p>
 * 2、获取相关时间单位，使用 .get()  .lengthOf..() ;
 * <p>
 * 3、判断、比较，使用 .is...()    .compareTo() ;
 * <p>
 * 4、日期加减，使用 .plus() ; 
 * <p>
 * 5、其他计算，使用 .with()    .with(TemporalAdjusters.......()) ;
 * <p>
 * 创建时间：2019年4月4日
 *
 * @author chenxj
 */
public class NewTimeDemo {

	public static void main(String args[]) {
		// 输入 20180101
		CharSequence str = "20040201";
		// BASIC_ISO_DATE -》ISO日期格式化，格式或解析无偏移的日期，如“20111203”。
		LocalDate localDate = LocalDate.parse(str, BASIC_ISO_DATE);

		// ===============================================================================
		// 1、 这个月月末
		// ===============================================================================
		System.out.println("本月月末是：" + localDate.with(TemporalAdjusters.lastDayOfMonth()));
		// 本月月末是：2004-02-29

		// ===============================================================================
		// 2、 下个月月初
		// ===============================================================================
		System.out.println("下月月初是：" + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		// 下月月初是：2004-03-01

		// ===============================================================================
		// 3、 下个月月末
		// ===============================================================================
		System.out.println("下月月末是："
				+ localDate.with(TemporalAdjusters.firstDayOfNextMonth()).with(TemporalAdjusters.lastDayOfMonth()));
		// 下月月末是：2004-03-31

		// ===============================================================================
		// 4、 给年月，计算当月天数
		// ===============================================================================
		CharSequence str2 = "200102";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
		YearMonth ym = YearMonth.parse(str2, dateTimeFormatter);
		System.out.println(ym.lengthOfMonth()); // 28

		// ===============================================================================
		// 5、 日期加减天数
		// ===============================================================================
		System.out.println(localDate.plusDays(-1)); // 2004-01-31

		// ===============================================================================
		// 6、 日期加减月份
		// ===============================================================================
		System.out.println(localDate.plusMonths(-1)); // 2004-01-01
		System.out.println(localDate.plusMonths(1)); // 2004-03-01

		// ===============================================================================
		// 7、 传参月份，日子，输出修改后的
		// ===============================================================================
		try {
			System.out.println(localDate.withMonth(2).withDayOfMonth(2));
			// 2004-02-02
		} catch (DateTimeException exception) {
			System.out.println("输入日期异常！");
		}
		System.out.println(localDate.withDayOfMonth(1));
		// 2004-02-01

		// ===============================================================================
		// 8、 小于15日，输出该月15日，否则输出下月1日
		// ===============================================================================
		System.out.println("--------------------");
		if (localDate.getDayOfMonth() < 15) {
			System.out.println(localDate.withDayOfMonth(15));
		} else {
			System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		}
		// 2004-02-15

	}

}
