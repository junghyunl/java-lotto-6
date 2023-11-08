package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] numbers = Console.readLine().split(",");

        winningNumbers = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력하세요:");

        bonusNumber = Integer.parseInt(Console.readLine());
    }
}
