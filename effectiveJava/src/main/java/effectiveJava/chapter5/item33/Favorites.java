package effectiveJava.chapter5.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * 类 @code(Favorites)
 *
 * <p>
 * 功能简介：
 * <p>
 * 类型安全的异构容器实现演示
 * <p>
 * 创建时间：2019年4月11日
 *
 * @author chenxj
 */
public class Favorites {
	private Map<Class<?>, Object> favorites = new HashMap<>();

	// Typesafe heterogeneous container pattern - client、
	public static void main(String[] args) {

		Favorites f = new Favorites();

		f.putFavorite(String.class, "Java");

		f.putFavorite(Integer.class, 0xcafebabe);

		f.putFavorite(Class.class, Favorites.class);

		String favoriteString = f.getFavorite(String.class);

		int favoriteInteger = f.getFavorite(Integer.class);

		Class<?> favoriteClass = f.getFavorite(Class.class);

		System.out.printf("%s %x %s%n", favoriteString,

				favoriteInteger, favoriteClass.getName());
	}

	public <T> void putFavorite(Class<T> type, T instance) {
		favorites.put(Objects.requireNonNull(type), type.cast(instance));
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}

	// Use of asSubclass to safely cast to a bounded type token
	static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
		Class<?> annotationType = null; // Unbounded type token
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
	}
}
