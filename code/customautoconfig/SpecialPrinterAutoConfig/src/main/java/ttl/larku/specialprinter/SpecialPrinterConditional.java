package ttl.larku.specialprinter;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SpecialPrinterConditional extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConditionMessage.Builder message
                = ConditionMessage.forCondition("SpecialPrinterSillyBean");
        boolean hasSillyBean  = context.getBeanFactory().containsBean("SillyBean");
        if(hasSillyBean) {
            return ConditionOutcome.match(message.found("Bean").items("SillyBean"));
        }
        else {
            return ConditionOutcome.noMatch(message.didNotFind("Bean").items("SillyBean"));
        }
    }

}
