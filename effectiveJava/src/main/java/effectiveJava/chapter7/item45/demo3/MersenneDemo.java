package effectiveJava.chapter7.item45.demo3;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.stream.Stream;
/**
 * 
 * 类 @code(MersenneDemo)
 *
 * <p>
 *  功能简介：
 * <p>
* 
 * <p>
 *  创建时间：2019年4月23日
 *
 * @author chenxj
 */
public class MersenneDemo {	
	public static void main(String[] args) {
	    primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
	        .filter(mersenne -> mersenne.isProbablePrime(50))
	        .limit(20)
	        .forEach(System.out::println);
	}
	
	static Stream<BigInteger> primes() {
	    return Stream.iterate(TWO, BigInteger::nextProbablePrime);

	}
	
}
