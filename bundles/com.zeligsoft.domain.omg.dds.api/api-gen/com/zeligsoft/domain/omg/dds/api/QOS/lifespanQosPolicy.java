package com.zeligsoft.domain.omg.dds.api.QOS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface lifespanQosPolicy extends qosPolicy {
	Duration getDuration();

	void setDuration(Duration val);

	<T extends Duration> T createDuration(Class<T> typeToCreate, String concept);

	Duration createDuration();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of lifespanQosPolicy
	 */
	static final TypeSelectPredicate<lifespanQosPolicy> type = new TypeSelectPredicate<lifespanQosPolicy>(
			"DDS::QOS::lifespanQosPolicy", //$NON-NLS-1$
			lifespanQosPolicy.class);
}
