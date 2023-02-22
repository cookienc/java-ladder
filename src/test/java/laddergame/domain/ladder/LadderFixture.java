package laddergame.domain.ladder;

import laddergame.domain.Players;
import laddergame.domain.Prizes;
import laddergame.domain.player.Player;

import java.util.List;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.UNCONNECTED;

public class LadderFixture {

    protected static Player ethan;
    protected static Player coil;
    protected static Player junPark;
    protected static Players players;
    protected static List<Connection> connections;
    protected static Ladder ladder;
    protected static Prizes prizes;

    /**
     * 에단 코일 준팍
     *  |---|   |
     */
    public LadderFixture() {
        ethan = Player.of("에단", 0);
        coil = Player.of("코일", 1);
        junPark = Player.of("준팍", 2);
        players = new Players(List.of(ethan, coil, junPark));

        prizes = new Prizes(List.of("1000", "5000", "10000"), 3);

        connections = List.of(CONNECTED, UNCONNECTED);
        ladder = new Ladder(1, players.getPlayers().size(), new TestConnectionMaker(connections));
    }
}
