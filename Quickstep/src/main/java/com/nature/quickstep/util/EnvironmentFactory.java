package com.nature.quickstep.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages default and custom environments. Environments are used to adapt test
 * runs to a particular environment. This currently involves simply adapting a
 * URL to point to an appropriate location but could grow in future.
 * 
 * @author mark.micallef
 */
public class EnvironmentFactory {

    protected Map<String, Environment> environments = new HashMap<String, Environment>();

    private static EnvironmentFactory instance = null;

    // Default environments
    public static Environment local = new Environment("local", "http://local.");
    public static Environment sandbox = new Environment("sandbox", "http://naturesandbox.");
    public static Environment nftest = new Environment("nf-test", "http://nf-test.");
    public static Environment testwww = new Environment("test-www", "http://test-www.");
    public static Environment stagingwww = new Environment("staging-www", "http://staging-www.");
    public static Environment live = new Environment("live", "http://www.");
    public static Environment vm = new Environment("vm", "http://vm.");

    protected EnvironmentFactory() {
        initDefaultEnvironments();
    }

    public static EnvironmentFactory getInstance() {
        if (instance == null) {
            instance = new EnvironmentFactory();
        }

        return instance;
    }

    public void initDefaultEnvironments() {
        environments.put("local", EnvironmentFactory.local);
        environments.put("sandbox", EnvironmentFactory.sandbox);
        environments.put("nf-test", EnvironmentFactory.nftest);
        environments.put("test-www", EnvironmentFactory.testwww);
        environments.put("staging-www", EnvironmentFactory.stagingwww);
        environments.put("live", EnvironmentFactory.live);
        environments.put("vm", EnvironmentFactory.vm);
    }

    public Collection<Environment> getEnvironments() {
        return environments.values();
    }

    /**
     * Retrieves the environment against which this test run is being executed.
     * 
     * @return Environment instance
     * @throws Exception
     *             if the environment is not recognised.
     */
    public Environment getEnvironment(String id) {
        return environments.get(id);
    }

    public void addEnvironment(Environment env) {
        environments.put(env.getId(), env);
    }

}
