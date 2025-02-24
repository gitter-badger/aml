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
package es.us.isa.aml.translator.builders.iagree.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class IAgreeUtils {
	
	public static Map<String, String> DATATYPES = new HashMap<String, String>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            this.put("int", "integer");
            this.put("float", "float");
            this.put("enumerated", "enum");
        }
    };

}
