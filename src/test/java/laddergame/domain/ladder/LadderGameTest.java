package laddergame.domain.ladder;

import laddergame.domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderGameTest {

    private Player ethan;
    private Player coil;
    private Player junPark;
    private List<Player> players;
    private List<Connection> connections;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ethan = Player.of("에단", 0);
        coil = Player.of("코일", 1);
        junPark = Player.of("준팍", 2);
        players = List.of(ethan, coil, junPark);

        connections = List.of(CONNECTED, UNCONNECTED);
        ladder = new Ladder(1, players.size(), new TestConnectionMaker(connections));
    }

    @Test
    @DisplayName("사다리와 플레이어들로 사다리 게임을 만들 수 있다.")
    void givenPlayerAndLadder_whenCreateLadder_thenSuccess() {
        // when
        final LadderGame ladderGame = LadderGame.of(ladder, players);

        // then
        assertAll(
                () -> assertThat(ladderGame)
                        .extracting("ladder")
                        .isEqualTo(ladder),
                () -> assertThat(ladderGame)
                        .extracting("players")
                        .isEqualTo(players)
        );
    }

}