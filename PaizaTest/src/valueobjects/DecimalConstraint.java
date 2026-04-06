package valueobjects;

import java.math.BigDecimal;

public interface DecimalConstraint {
    void validate(final BigDecimal value);
    
}
