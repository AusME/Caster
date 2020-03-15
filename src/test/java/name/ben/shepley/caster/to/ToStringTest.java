package name.ben.shepley.caster.to;

import name.ben.shepley.caster.Caster;
import org.junit.jupiter.api.Test;

public class ToStringTest {
    private Caster caster = new Caster.CasterBuilder().build();

    @Test
    public void testCharacter() {
        System.out.println(this.caster.toStr().setRoundingModeEnum(Caster.CasterConfiguration.RoundingModeEnum.ROUND_UP).cast('C'));
    }
}
