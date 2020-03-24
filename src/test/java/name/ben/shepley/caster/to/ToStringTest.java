package name.ben.shepley.caster.to;

import name.ben.shepley.caster.Caster;
import name.ben.shepley.caster.configuration.RoundingModeEnum;
import org.junit.jupiter.api.Test;

public class ToStringTest {
    private Caster caster = Caster.getInstance();

    @Test
    public void testCharacter() {
        System.out.println(this.caster.toStr().setRoundingModeEnum(RoundingModeEnum.ROUND_UP).cast('6'));
    }
}
