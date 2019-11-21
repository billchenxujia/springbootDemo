package effectiveJava.chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 类 @code(ForEachDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 总之，for-each循环在清晰度，灵活性和错误预防方面提供了超越传统for循环的令人注目的优势，而且没有性能损失。
 * 尽可能使用for-each循环优先于for循环。
 * <p>
 * 有损过滤、转换、并行迭代这三个需要显示的迭代或者数组索引的无法使用增强for循环
 * 注：有损过滤 通常可以使用在Java 8中添加的Collection类中的removeIf方法，来避免显式遍历。
 *
 * <p>
 * 创建时间：2019年5月12日
 *
 * @author chenxj
 */
public class ForEachDemo {
	enum Suit {
		CLUB, DIAMOND, HEART, SPADE
	}

	enum Rank {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	// Same bug, different symptom!
	enum Face {
		ONE, TWO, THREE, FOUR, FIVE, SIX
	}

	static Collection<Suit> suits = Arrays.asList(Suit.values());
	static Collection<Rank> ranks = Arrays.asList(Rank.values());

	private static class Card {
		@SuppressWarnings("unused")
		private final Suit suit;
		@SuppressWarnings("unused")
		private final Rank rank;

		public Card(Suit suit, Rank rank) {
			this.suit = suit;
			this.rank = rank;
		}

	}

	public static void main(String[] args) {
		// 问题是，对于外部集合(suit)，next方法在迭代器上调用了太多次。它应该从外部循环调用，因此每花色调用一次，但它是从内部循环调用的，因此每一张牌调用一次。在suit用完之后，循环抛出NoSuchElementException异常
		List<Card> deck = new ArrayList<>();
		for (Iterator<Suit> i = suits.iterator(); i.hasNext();)
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext();)
				deck.add(new Card(i.next(), j.next()));

		// 同上面一样的bug
		Collection<Face> faces = EnumSet.allOf(Face.class);

		for (Iterator<Face> i = faces.iterator(); i.hasNext();)
			for (Iterator<Face> j = faces.iterator(); j.hasNext();)
				System.out.println(i.next() + " " + j.next());

		// Preferred idiom for nested iteration on collections and arrays
		for (Suit suit : suits)
			for (Rank rank : ranks)
				deck.add(new Card(suit, rank));

	}

}
