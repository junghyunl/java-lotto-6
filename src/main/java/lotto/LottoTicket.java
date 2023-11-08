package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {

    public List<Integer> generateLottoNumbers() {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(null);
            return numbers;
        }
    
}