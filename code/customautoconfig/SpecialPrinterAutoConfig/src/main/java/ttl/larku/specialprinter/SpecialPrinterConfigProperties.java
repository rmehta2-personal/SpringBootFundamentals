package ttl.larku.specialprinter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("special")
public class SpecialPrinterConfigProperties {

    private String prefix = "%% ";
    private String suffix = " %%";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
