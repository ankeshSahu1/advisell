/*
 * Copyright (C) 2017 Metazone Infotech Pvt Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mz.advisell.services.extra;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author parii
 */
public class TestUtils {

    static int counter;

    public static Component getChildNamed(Component parent, String name) {
        if (name.equals(parent.getName())) {
            return parent;
        }

        if (parent instanceof Container) {
            Component[] children = (parent instanceof JMenu)
                    ? ((JMenu) parent).getMenuComponents() : ((Container) parent).getComponents();

            for (int i = 0; i < children.length; ++i) {
                Component child = getChildNamed(children[i], name);
                if (child != null) {
                    return child;
                }
            }
        }

        return null;
    }

    public static Component getChildIndexed(Component parent, String name, int index) {
        counter = 0;
        //Step in only owned windows and ignore its components in Jframe
        if (parent instanceof Window) {
            Component[] children = ((Window) parent).getOwnedWindows();

            for (int i = 0; i < children.length; ++i) {
                // take only active windows
                if (children[i] instanceof Window && !((Window) children[i]).isActive()) {
                    continue;
                }
                Component child = getChildIndexedInternal(children[i], name, index);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }

    private static Component getChildIndexedInternal(Component parent, String name, int index) {
        if (parent.getClass().toString().endsWith(name)) {
            if (counter == index) {
                return parent;
            }
            ++counter;
        }

        if (parent instanceof Container) {
            Component[] children = (parent instanceof JMenu) ? ((JMenu) parent).getMenuComponents() : ((Container) parent).getComponents();
            for (int i = 0; i < children.length; ++i) {
                Component child = getChildIndexedInternal(children[i], name, index);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}
