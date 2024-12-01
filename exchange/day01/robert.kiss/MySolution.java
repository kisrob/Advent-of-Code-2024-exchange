import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MySolution extends MySolutionBase {

	public MySolution(String inputFilename) {
        super(inputFilename);
    }

	@Override
	protected void solve1() {
		List<Long> l1 = getInputLinesAsList().stream()
				.map(s->Long.parseLong(s.split(" +")[0]))
				.collect(Collectors.toList());
		List<Long> l2 = getInputLinesAsList().stream()
				.map(s->Long.parseLong(s.split(" +")[1]))
				.collect(Collectors.toList());

		l1.sort(Long::compare);
		l2.sort(Long::compare);

		var sum = IntStream.range(0, l1.size())
				.mapToLong(i -> Math.abs(l1.get(i)-l2.get(i)))
				.sum();
		pln(sum);

	}

	@Override
	protected void solve2() {
		List<Long> l1 = getInputLinesAsList().stream()
				.map(s->Long.parseLong(s.split(" +")[0]))
				.collect(Collectors.toList());

		Map<Long,Integer> m2 = new HashMap<>();
		getInputLinesAsList().stream().forEach(s-> {
			var s2 = Long.parseLong(s.split(" +")[1]);
			m2.put(s2, m2.getOrDefault(s2,0) + 1);
		});

		var sum = l1
				.stream()
				.mapToLong(s1 -> s1 * m2.getOrDefault(s1,0))
				.sum();
		pln(sum);
	}

	public static void main(String args[]) {
		try {
            new MySolution("input-sample.txt").play1().play2();
            new MySolution("input.txt").play1().play2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
