package subway.domain;

import subway.exception.SubwayException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line->line.getName().equals(name))
                .findAny()
                .orElseThrow(()->new SubwayException("해당 노선이 없습니다"));
    }

    public static boolean deleteLineByName(String name) {
        lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new SubwayException("삭제할 노선이 없음"));
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static List<String> getLineNames() {
        return lines.stream()
                .map(line -> line.getName())
                .collect(toList());
    }

    public static void deleteLine(Line lineToDelete) {
        lines.remove(lineToDelete);
    }

    public static boolean isExist(String name) {
        return !lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .isEmpty();
    }
}
