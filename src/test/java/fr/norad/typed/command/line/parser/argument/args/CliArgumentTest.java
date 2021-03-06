/**
 *
 *     Copyright (C) norad.fr
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
package fr.norad.typed.command.line.parser.argument.args;

import junit.framework.Assert;
import org.junit.Test;
import fr.norad.typed.command.line.parser.argument.CliArgumentDefinitionException;
import fr.norad.typed.command.line.parser.argument.args.CliNoParamArgument;
import fr.norad.typed.command.line.parser.argument.interfaces.CliArgument;

public class CliArgumentTest {

    @Test
    public void testCompareTo() {
        CliArgument arg1 = new CliNoParamArgument('S');
        CliArgument arg2 = new CliNoParamArgument('s');

        Assert.assertEquals(1, arg1.compareTo(arg2));
        Assert.assertEquals(-1, arg2.compareTo(arg1));
    }

    @Test
    @SuppressWarnings("unused")
    public void testCliArgument() {
        CliArgument argument = new CliNoParamArgument('s');
        Assert.assertEquals("-s", argument.getShortName());
        CliArgument argument2 = new CliNoParamArgument('S');
        Assert.assertEquals("-S", argument2.getShortName());

        boolean test = false;
        try {
            new CliNoParamArgument((char) 2);
        } catch (CliArgumentDefinitionException e) {
            test = true;
        }
        Assert.assertTrue(test);
    }

    @Test
    public void testIsMulticall() {
        CliArgument argument = new CliNoParamArgument('s');
        argument.setMultiCallMax(0);
        Assert.assertEquals(true, argument.isMulticall());
        argument.setMultiCallMax(1);
        Assert.assertEquals(false, argument.isMulticall());
    }
}
