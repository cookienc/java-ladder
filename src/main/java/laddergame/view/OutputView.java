package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Names;

import java.util.List;
import java.util.stream.Collectors;

public enum OutputView {
    BLANK(" "),
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-");

    private final String ladderElement;

    OutputView(final String ladderElement) {
        this.ladderElement = ladderElement;
    }

    public static void printPlayerAll(final Names names) {

        System.out.println("실행결과" + System.lineSeparator());
        final String allPlayerName = names.getNames().stream()
                .map(player -> makeNameFormat(names.findMaxNameLength(), player))
                .collect(Collectors.joining(BLANK.ladderElement));

        System.out.println(allPlayerName);
    }

    private static String makeNameFormat(final int maxNameLength, final String name) {
        int count = maxNameLength - name.length();
        final String repeat = BLANK.ladderElement.repeat(count);

        return String.format("%s%s", name, repeat);
    }

    public static void printLadder(final Names names, final Ladder ladder) {
        StringBuilder result = new StringBuilder();
        ladder.getLines().forEach(line -> result.append(makeLadderFormat(line.getStatuses(), names)));
        System.out.println(result);
    }

    private static String makeLadderFormat(final List<Boolean> statuses, final Names names) {
        final StringBuilder result = new StringBuilder();
        result.append(BLANK.ladderElement.repeat(names.getFirstNameLengthDividedByTwoRounded()));
        result.append(VERTICAL_LINE.ladderElement);
        statuses.forEach(status -> result.append(makeLine(status, names.findMaxNameLength())));
        result.append(System.lineSeparator());

        return result.toString();
    }

    private static String makeLine(final Boolean status, final int maxNameLength) {
        if (status) {
            return HORIZONTAL_LINE.ladderElement.repeat(maxNameLength) + VERTICAL_LINE.ladderElement;
        }

        return BLANK.ladderElement.repeat(maxNameLength) + VERTICAL_LINE.ladderElement;
    }

}
