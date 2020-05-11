package org.pjamin.ff4j.spring.sandbox.strategy;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrganizationStrategy extends AbstractFlipStrategy {

    private static final String INIT_PARAMNAME_ORGANIZATIONS = "grantedOrganizations";

    public static final String PARAMNAME_USER_ORGANIZATION = "organization";

    private final Set<String> setOfGrantedOrganizations = new HashSet<>();

    @Override
    public void init(String featureName, Map<String, String> initValue) {
        super.init(featureName, initValue);
        assertRequiredParameter(INIT_PARAMNAME_ORGANIZATIONS);
        String[] arrayOfRegions = initValue.get(INIT_PARAMNAME_ORGANIZATIONS).split(",");
        setOfGrantedOrganizations.addAll(Arrays.asList(arrayOfRegions));
    }

    @Override
    public boolean evaluate(String fName, FeatureStore fStore, FlippingExecutionContext ctx) {
        // true means required here
        String userRegion = ctx.getString(PARAMNAME_USER_ORGANIZATION, true);
        return setOfGrantedOrganizations.contains(userRegion);
    }
}
