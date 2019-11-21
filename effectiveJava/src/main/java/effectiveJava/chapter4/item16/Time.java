package effectiveJava.chapter4.item16;

/**
 * 
 * 类 @code(Time)
 *
 * <p>功能简介：
 *
 * <p>虽然直接暴露公开类的域从来都不是一个好主意，但是当域是不可变时它有较低危害。你不能改变这种类的表示而没有改变它的API，而且当域是可读的时候，你不可以采取辅助行动，但是你可以实施不可变性。比如，下面的类保证每个实例代表一个有效的时间
 *
 * <p>创建时间：2019年4月1日
 *
 * @author chenxj
 */
public final class Time {
 private static final int HOURS_PER_DAY = 24; 
 private static final int MINUTES_PER_HOUR = 60;

 public final int hour; 
 public final int minute;

 public Time(int hour, int minute) { 
     if (hour < 0 || hour >= HOURS_PER_DAY) 
         throw new IllegalArgumentException("Hour: " + hour); 
     if (minute < 0 || minute >= MINUTES_PER_HOUR) 
         throw new IllegalArgumentException("Min: " + minute); 
     this.hour = hour; 
     this.minute = minute; 
 } 
 
}
