package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 포매팅될때 오름차순으로 정렬된다.")
    @Test
    void 로또번호가_포매팅될때_오름차순으로_정렬된다() {
        // given
        List<Integer> lottos = new ArrayList<>();
        lottos.add(3);
        lottos.add(2);
        lottos.add(1);
        lottos.add(4);
        lottos.add(6);
        lottos.add(5);
        Lotto lotto = new Lotto(lottos);
        String expectedLottoNumbers = "[1, 2, 3, 4, 5, 6]\n";

        // when
        String actualLottoNumbers = lotto.getLottoNumbers();

        // then
        assertThat(actualLottoNumbers).isEqualTo(expectedLottoNumbers);
    }
}
