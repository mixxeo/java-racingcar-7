package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

public class RaceTrackTest {
    private RaceTrack raceTrack;

    @BeforeEach
    void setUp() {
        RacePolicy racePolicy = new RacePolicy();
        this.raceTrack = new RaceTrack(racePolicy);
    }

    @Test
    @DisplayName("자동차 등록 테스트")
    void testRegisterCars() {
        List<String> names = List.of(new String[]{"test1", "test2", "test3"});
        raceTrack.registerCars(names);
        List<Car> cars = raceTrack.getCars();
        assertThat(cars.size()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("중복된 이름 입력시 예외가 발생한다.")
    void testRegisterDuplicatedNameCars() {
        List<String> names = List.of(new String[]{"test", "test"});
        assertThatThrownBy(() -> raceTrack.registerCars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAMES_DUPLICATE.getMessage());
    }
}