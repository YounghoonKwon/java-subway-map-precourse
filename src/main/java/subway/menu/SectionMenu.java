package subway.menu;

import subway.controller.SectionController;
import subway.exception.SubwayException;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public enum SectionMenu {
    REGISTRATION("구간 등록", "1", SectionController::registerSection),
    DELETION("구간 삭제", "2", SectionController::deleteSection),
    BACK("돌아가기", "B", SectionController::back);

    SectionMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static SectionMenu findByCommand(String command) {
        return Arrays.stream(SectionMenu.values())
                .filter(mainMenu -> mainMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new SubwayException("메뉴 잘못 입력");
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(SectionMenu.values())
                .map(mainMenu -> mainMenu.title)
                .collect(toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(SectionMenu.values())
                .map(mainMenu -> mainMenu.command)
                .collect(toList());
    }

    public void run() {
        this.action.run();
    }
}
