import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CompareTheTriplets {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("output")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt).collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();

	}

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

		int apoint = 0;
		int bpoint = 0;

		for(int i = 0; i < 3; i ++) {
			if(a.get(i) > b.get(i)) {
				apoint ++;
			}else if(a.get(i) < b.get(i)) {
				bpoint ++;
			}
		}

		List<Integer> ans = new ArrayList<>(Arrays.asList(apoint,bpoint));

		return ans;
    }

}
