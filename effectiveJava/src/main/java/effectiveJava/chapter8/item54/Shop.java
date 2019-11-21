package effectiveJava.chapter8.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 类 @code(Shop)
 *
 * <p>
 * 功能简介：
 * <p>
 * 总之，永远不要返回null来代替空数组或集合。它使你的API更难以使用，更容易出错，并且没有性能优势。
 * <p>
 * 创建时间：2019年5月9日
 *
 * @author chenxj
 */
public class Shop {
	// Returns null to indicate an empty collection. Don't do this!
	private final List<Cheese> cheesesInStock = new ArrayList<>();

	/**
	 * @return a list containing all of the cheeses in the shop, or null if no
	 *         cheeses are available for purchase.
	 */
	public List<Cheese> getCheesesError() {
		return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
	}

	// The right way to return a possibly empty collection
	public List<Cheese> getCheeses() {
		return new ArrayList<>(cheesesInStock);
	}

	// Optimization - avoids allocating empty collections
	public List<Cheese> getCheesesImprove() {
		return cheesesInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheesesInStock);
	}

	// The right way to return a possibly empty array
	public Cheese[] getCheesesArray() {
		return cheesesInStock.toArray(new Cheese[0]);
	}
	// Optimization - avoids allocating empty arrays

	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	/**
	 * 在优化的版本中，我们将相同的空数组传递到每个toArray调用中，当cheesesInStock为空时，这个数组将从getCheeses返回。不要为了提高性能而预先分配传递给toArray的数组。研究表明，这样做会适得其反[Shipilev16]
	 * 
	 * @return
	 */
	public Cheese[] getCheesesArrayImprove() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);

	}
}
