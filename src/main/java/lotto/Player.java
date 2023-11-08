package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> winningNumbers;

    public void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = Console.readLine();
        String[] numbers = input.split(",");

        winningNumbers = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
