package racingcar.validator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 기준_길이_초과하는_이름은_예외_발생() {
        String inputCarName = "다섯글자 넘는 자동차 이름";
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Length must be less or equal than")
        );
    }

    @Test
    void 이름이_비어있거나_공백으로만_이루어져_있는_경우_예외_발생() {
        String inputCarName = " ";
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(inputCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Car name cannot be blank")
        );
    }
}
