package lotto;

import java.util.List;

enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchNumberCount;
    private final int winningMoney;
    private final boolean matchBonus;

    Rank(int matchNumberCount, int winningMoney, boolean matchBonus) {
        this.matchNumberCount = matchNumberCount;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }
    public static Rank determineRank(int matchNumberCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchNumberCount == matchNumberCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }
    public int getWinningMoney() {
        return winningMoney;
    }
}

public class LottoRank {

    public int getMatchNumberCount(List<Integer> numbers, List<Integer> winningNumbers) {
        int matchNumberCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchNumberCount++;
            }
        }
        return matchNumberCount;
    }
    public boolean isBonusMatch(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
    public Rank getRank(int matchNumberCount, boolean bonusMatch) {
        return Rank.determineRank(matchNumberCount, bonusMatch);
    }
    public int checkRank(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchNumberCount = getMatchNumberCount(numbers, winningNumbers);
        boolean bonusMatch = isBonusMatch(numbers, bonusNumber);
        Rank rank = getRank(matchNumberCount, bonusMatch);
        return rank.getWinningMoney();
    }
}

