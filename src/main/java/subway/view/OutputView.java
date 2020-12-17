package subway.view;

import static subway.constants.Constants.*;

import subway.domain.Line;
import subway.domain.Section;
import subway.menu.LineMenu;
import subway.menu.MainMenu;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void showMainMenu() {
        String header = NEW_LINE + MAIN_SCREEN + NEW_LINE;
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println(PLEASE_SELECT_CATEGORY);
    }

    public static void showStationMenu() {
        String header = NEW_LINE + STATION_MANAGEMENT_SCREEN + NEW_LINE;
        List<String> commands = StationMenu.getCommands();
        List<String> titles = StationMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println(PLEASE_SELECT_CATEGORY);
    }

    public static void showLineMenu() {
        String header = NEW_LINE + LINE_MANAGEMENT_SCREEN + NEW_LINE;
        List<String> commands = LineMenu.getCommands();
        List<String> titles = LineMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println(PLEASE_SELECT_CATEGORY);
    }

    public static void showSectionMenu() {
        String header = NEW_LINE + SECTION_MANAGEMENT_SCREEN + NEW_LINE;
        List<String> commands = SectionMenu.getCommands();
        List<String> titles = SectionMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println(PLEASE_SELECT_CATEGORY);
    }

    public static void showPrompt(String subject, String action) {
        System.out.println(String.format(NEW_LINE + PROMPT_MESSAGE, action, subject));
    }

    public static void showCompletionMessage(String subject, String action) {
        System.out.println(String.format(NEW_LINE + INFO + COMPLETION_MESSAGE, subject, action));
    }

    public static void showListTitle(String subject) {
        System.out.println(String.format(NEW_LINE + LIST_TITLE, subject));
    }

    public static void showSectionPrompt(String subject) {
        System.out.println(String.format(NEW_LINE + SECTION_PROMPT_MESSAGE, subject));
    }

    public static void showList(List<String> names) {
        System.out.println(
                names.stream()
                        .map(name -> INFO + name)
                        .collect(Collectors.joining(NEW_LINE))
        );
    }

    public static String generateMenu(String header, List<String> commands, List<String> titles) {
        StringBuilder menu = new StringBuilder(header);
        for (int i = 0; i < commands.size(); i++) {
            menu.append(commands.get(i))
                    .append(DOT)
                    .append(titles.get(i))
                    .append(NEW_LINE);
        }
        return menu.toString();
    }

    public static void showEntireMap(List<Line> lines, List<Section> sections) {
        StringBuilder entireMap = new StringBuilder(NEW_LINE + TRANSIT_MAP);
        for (int i = 0; i < lines.size(); i++) {
            entireMap.append(NEW_LINE + INFO + lines.get(i).getName());
            entireMap.append(NEW_LINE + INFO + DASH);
            entireMap.append(
                    sections.get(i)
                            .getStations()
                            .stream()
                            .map(station -> NEW_LINE + INFO + station.getName())
                            .collect(Collectors.joining())
                            + NEW_LINE);
        }
        entireMap.setLength(entireMap.length() - 1);
        System.out.println(entireMap.toString());
    }
}
