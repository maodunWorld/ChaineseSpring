package MicroMeter;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.config.NamingConvention;

/**
 * @author tongjian
 * @date 2020/5/29 9:47
 */
public class UDFNameConvertion implements NamingConvention {
    @Override
    public String name(String name, Meter.Type type) {
        return null;
    }

    @Override
    public String name(String s, Meter.Type type, String s1) {
        return null;
    }

    @Override
    public String tagKey(String key) {
        return null;
    }

    @Override
    public String tagValue(String value) {
        return null;
    }
}
