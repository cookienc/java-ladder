package laddergame.domain.prize;

import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.List;

public class ResultFixture {
    protected static Players players;
    protected static Prizes prizes;
    protected static Result result;
    protected static Player ethan;
    protected static Player coil;
    protected static Player junPk;

    public ResultFixture() {
        ethan = Player.of("ethan", 0);
        coil = Player.of("coil", 1);
        junPk = Player.of("junPk", 2);
        players = new Players(List.of(ethan, coil, junPk));

        prizes = new Prizes(List.of("1000", "5000", "10000"), players.getPlayerSize());
        result = new Result(players, prizes);
    }
}
