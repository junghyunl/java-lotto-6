package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {

    public List<Integer> generateLottoNumbers() {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(null);
            return numbers;
        }
    
    public List<Lotto> generateLotto(int price) {
        return IntStream.range(0, price / 1000)
            .mapToObj(i -> new Lotto(generateLottoNumbers()))
            .collect(Collectors.toList());
    }
}