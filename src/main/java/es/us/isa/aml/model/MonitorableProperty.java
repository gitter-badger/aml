/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class MonitorableProperty extends Property {
	
	public MonitorableProperty(String id) {
		super(id);
	}

    public MonitorableProperty(String id, Metric metric) {
        super(id, metric);
    }

    public MonitorableProperty(String id, Metric metric, Expression expression,
            Scope scope, Feature feature) {
        super(id, metric, expression, scope, feature);
    }

	@Override
    public MonitorableProperty clone() {
    	MonitorableProperty mp = new MonitorableProperty(getId(), getMetric().clone());
    	mp.setExpression(getExpression());
    	if(getFeature() != null)
    		mp.setFeature(getFeature().clone());
    	mp.setScope(getScope());
    	if(getDefinitionReference() != null)
    		mp.setDefinitionReference(getDefinitionReference());
    	if(getMonitorReference() != null)
    		mp.setMonitorReference(getMonitorReference());
    	return mp;
    }

}
