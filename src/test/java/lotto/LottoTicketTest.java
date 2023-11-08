package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    void testGenerateLottoNumbers() {
        LottoTicket testLotto = new LottoTicket();
        List<Integer> numbers = testLotto.generateLottoNumbers();

        // 크기가 6인지 검사
        assertEquals(6, numbers.size());

        // 모든 숫자가 1이상 45이하인지 검사
        assertTrue(numbers.stream().allMatch(i -> i >= 1 && i <= 45));

        // 중복 검사
        assertEquals(numbers.stream().distinct().count(), numbers.size());

        // 오름차순 검사
        IntStream.range(0, numbers.size() - 1)
                .allMatch(i -> numbers.get(i) <= numbers.get(i + 1));
    }

    @Test
    void testGenerateLotto() {
        LottoTicket testLotto = new LottoTicket();
        int price = 7000;
        List<Lotto> testLottoTicket = testLotto.generateLotto(price);

        // 로또 발행 개수 확인
        assertEquals(price / 1000, testLottoTicket.size());
    }
}
