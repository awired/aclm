/**
 *
 *     Copyright (C) Awired.net
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package net.awired.aclm.param;

import net.awired.aclm.argument.CliArgumentParseException;

public class CliParamBoolean extends CliParam<Boolean> {

    public CliParamBoolean(String name) {
        super(name);
    }

    @Override
    public Boolean parse(String res) throws CliArgumentParseException {
        if (res == null) {
            return false;
        }
        if (res.equalsIgnoreCase("yes") || res.equalsIgnoreCase("y") || res.equalsIgnoreCase("o")
                || res.equalsIgnoreCase("oui") || res.equalsIgnoreCase("true")) {
            return true;
        }
        return false;
    }

}
