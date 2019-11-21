package effectiveJava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * 
 * 类 @code(StreamParallel)
 *
 * <p>
 * 功能简介：
 * <p>
 * 流并行化简单演示：
 * 总之，甚至不要尝试并行化流管道，除非你有充分的理由相信它将保持计算的正确性并提高其速度。不恰当地并行化流的代价可能是程序失败或性能灾难。如果您认为并行性是合理的，那么请确保您的代码在并行运行时保持正确，并在实际情况下进行仔细的性能度量。如果您的代码是正确的，并且这些实验证实了您对性能提高的怀疑，那么并且只有这样才能在生产代码中并行化流。
 * 
 * <p>
 * 创建时间：2019年5月5日
 *
 * @author chenxj
 */
public class StreamParallel {
	public static void main(String[] args) {

	}

	// 作为并行性有效的流管道的简单示例，请考虑此函数来计算π(n)，素数小于或等于n：
	// Prime-counting stream pipeline - benefits from parallelization
	/*
	 * static long pi(long n) { return LongStream.rangeClosed(2, n)
	 * .mapToObj(BigInteger::valueOf) .filter(i -> i.isProbablePrime(50)) .count();
	 * }
	 */
	// Prime-counting stream pipeline - parallel version
	static long pi(long n) {
		return LongStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).filter(i -> i.isProbablePrime(50))
				.count();
	}
}
