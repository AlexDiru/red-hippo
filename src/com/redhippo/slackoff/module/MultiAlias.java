package com.redhippo.slackoff.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25/11/13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public abstract class MultiAlias {
    /**
     * Modules can have a variety of names e.g:
     * Cybernetics and Circuits
     * Cyb and Cir
     * Helps if the user is searching for a particular module
     */
    protected List<String> names;

    /**
     * Store the names in lowercase - more memory, but quicker searching
     */
    protected List<String> lowercaseNames;

    public MultiAlias() {
        names = new ArrayList<String>();
        lowercaseNames = new ArrayList<String>();
    }

    public void addName(String name) {
        names.add(name);
        lowercaseNames.add(name.toLowerCase());
    }

    public String getName(int i) {
        return names.get(i);
    }
}
