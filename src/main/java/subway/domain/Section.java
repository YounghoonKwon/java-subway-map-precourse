package subway.domain;

import subway.exception.SubwayException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Section {
    List<Station> section;

    public Section(List<Station> stations) {
        validateDuplicate(stations);
        this.section = stations;
    }

    public List<Station> getStations() {
        return section;
    }

    public void validateDuplicate(List<Station> stations){
        Set<Station> setStations= new HashSet<Station>(stations);

        if(setStations.size() < stations.size()){
            throw new SubwayException("상행과 하행은 같을 수 없습니다");
        }
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

    public void deleteStationByName(String stationName) {
        section.removeIf(station -> station.getName().equals(stationName));
    }
}
