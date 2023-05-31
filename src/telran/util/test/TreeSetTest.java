package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.Set;
import telran.util.TreeSet;

class TreeSetTest extends SetTest {

	@Override
	protected <T> Set<T> getSet() {
		return new TreeSet<>();
		// return new TreeSet<>((Comparator<T>) Comparator.naturalOrder());
	}
}
