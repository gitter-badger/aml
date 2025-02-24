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
package es.us.isa.aml.translator.builders.wsag.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ServiceProperties are used to define measurable and exposed properties
 * associated with a service, such as response time and throughput. The
 * properties are used in expressing service level objectives.
 *
 * @author jdelafuente
 *
 */
public class ServiceProperties {

    /**
     * This is the name given to this set of service properties.
     */
    private String name;

    /**
     * This attribute identifies a service across multiple service description
     * terms. The purpose of this attribute has been described previously.
     */
    private String serviceName;

    /**
     * This element is a variable set.
     */
    private Set<Variable> variableSet = new HashSet<>();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the variableSet
     */
    public Set<Variable> getVariableSet() {
        return variableSet;
    }

    /**
     * @param variableSet the variableSet to set
     */
    public void setVariableSet(Set<Variable> variableSet) {
        this.variableSet = variableSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t\t" + "<wsag:ServiceProperties wsag:Name=\"").append(getName()).append("\" wsag:ServiceName=\"").append(getServiceName()).append("\">")
                .append("\n");

        sb.append("\t\t\t\t" + "<wsag:VariableSet>").append("\n");
        for (Variable v : getVariableSet()) {
            sb.append("\t\t\t\t\t").append(v.toString()).append("\n");
        }
        sb.append("\t\t\t\t" + "</wsag:VariableSet>").append("\n");

        sb.append("\t\t\t" + "</wsag:ServiceProperties>");

        return sb.toString();
    }

}
