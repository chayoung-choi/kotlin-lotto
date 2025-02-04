package lotto.domain

enum class Rank(val countOfMatch: Int, val matchBonus: Boolean, val winningMoney: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    fun getTotalWinningMoney(count: Int): Int = count * winningMoney

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            if (countOfMatch == SECOND.countOfMatch) {
                return getRankWithBonus(matchBonus)
            }

            return values().find { it.countOfMatch == countOfMatch } ?: MISS
        }

        private fun getRankWithBonus(matchBonus: Boolean): Rank = if (matchBonus) SECOND else THIRD
    }
}
