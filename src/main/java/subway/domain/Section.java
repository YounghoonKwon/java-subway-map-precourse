package subway.domain;

import subway.exception.SubwayException;

import java.util.List;

public class Section {
    List<Station> section;

    public Section(List<Station> stations) {
        this.section = stations;
    }

    public List<Station> getStations() {
        return section;
    }

    public void add(int where, Station station) {
        if(section.contains(station)){
            throw new SubwayException("이미 등록된 역이 있습니다");
        }

        if (where < 0 || where > section.size()) {
            throw new SubwayException("범위 오류");
        }
        section.add(where, station);
    }

    public void deleteStation(Station station) {
        section.remove(station);
    }
}
