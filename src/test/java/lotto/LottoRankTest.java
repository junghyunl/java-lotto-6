package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void testCheckRank() {
        LottoRank testLotto = new LottoRank();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int result = testLotto.getMatchNumberCount(numbers, winningNumbers);

        assertEquals(6, result);
    }

    @Test
    void testGetMatchNumberCount() {
        LottoRank testLotto = new LottoRank();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        boolean result = testLotto.isBonusMatch(numbers, bonusNumber);

        assertTrue(result);
    }

    @Test
    void testGetRank() {
        LottoRank lottoRank = new LottoRank();
        int matchNumberCount = 6;
        boolean bonusMatch = false;

        Rank result = lottoRank.getRank(matchNumberCount, bonusMatch);

        assertEquals(Rank.FIRST, result);
    }

    @Test
    void testIsBonusMatch() {
        LottoRank lottoRank = new LottoRank();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int result = lottoRank.checkRank(numbers, winningNumbers, bonusNumber);

        assertEquals(2_000_000_000, result);
    }
}
