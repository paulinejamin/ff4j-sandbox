package org.pjamin.ff4j.spring.sandbox.strategy;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

import java.util.Calendar;
import java.util.Map;

public class OfficeHoursStrategy extends AbstractFlipStrategy {

    private int start = 0;

    private int end = 0;

    @Override
    public void init(String featureName, Map<String, String> initValue) {
        super.init(featureName, initValue);
        assertRequiredParameter("startDate");
        assertRequiredParameter("endDate");
        start = new Integer(initValue.get("startDate"));
        end = new Integer(initValue.get("endDate"));
    }

    @Override
    public boolean evaluate(String fName, FeatureStore fStore, FlippingExecutionContext ctx) {

        int currentHour;
        if (ctx != null && ctx.getValue("currentHour", false) != null) {
            currentHour = Integer.parseInt((String) ctx.getValue("currentHour", true));
        } else {
            currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        }

        return (currentHour >= start && currentHour < end);
    }
}