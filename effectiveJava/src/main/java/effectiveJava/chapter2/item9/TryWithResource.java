package effectiveJava.chapter2.item9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * 类 @code(TryWithResource)
 *
 * <p>
 * 功能简介：
 * 
 * <p>释放资源 try-with-resource块演示（try-finally避免使用）
 * 需要关闭的资源务必实现{@code AutoCloseable}接口，以保证可通过
 * try-with-resource来处理，确保代码的可读性，简洁性
 * 
 * <p>注：不仅仅是简洁可读的问题，更重要的确保了你可以看到你自己调用方法
 * 抛出的异常，try-finally有可能会因为同样的原因抛出一异常后覆盖你本想看到
 * 的异常。在try-with-resource中这些抑制的异常没有被丢弃，它们打印在在一个
 * 堆栈信息里面，用一个注释说明它们被抑制了。你也可以用getSuppressed方法以
 * 编程方式获取它们，在Java 7 中这个方法添加到了Throwable。
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class TryWithResource {

	static final int BUFFER_SIZE = 16;

	// tyr-with-resource with a catch clause
	static String firstLineOfFile(String path, String defaultVal) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		} catch (IOException e) {
			return defaultVal;
		}
	}

	// 当用于多于一个资源时，try-finally 是丑陋的!
	static void copy(String src, String dst) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		} finally {
			in.close();
			out.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		copy("hello","hello");
	} 
}
