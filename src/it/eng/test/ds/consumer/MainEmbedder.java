package it.eng.test.ds.consumer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;


public class MainEmbedder {


    public static void main(String[] args)
    {


        FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
        Map<String, String> config = new HashMap<String, String>();


        //TODO: add some config properties
        Framework framework = frameworkFactory.newFramework(config);
        try {
            framework.start();
        } catch (BundleException e) {

            e.printStackTrace();
        }


        BundleContext context = framework.getBundleContext();
        List<Bundle> installedBundles = new LinkedList<Bundle>();

        try {



//            installedBundles.add(context.installBundle("file:///Users/frank/Documents/workspace43/stackoverflow.test/deploy/plugins/org.eclipse.osgi_3.9.1.v20130814-1242.jar"));

            installedBundles.add(context.installBundle("file:///Users/frank/Documents/workspace43/stackoverflow.test/deploy/plugins/org.eclipse.equinox.util_1.0.500.v20130404-1337.jar"));

            installedBundles.add(context.installBundle("file:///Users/frank/Documents/workspace43/stackoverflow.test/deploy/plugins/org.eclipse.osgi.services_3.3.100.v20130513-1956.jar"));

            installedBundles.add(context.installBundle(
                                 "file:///Users/frank/Documents/workspace43/stackoverflow.test/deploy/plugins/org.eclipse.equinox.ds_1.4.101.v20130813-1853.jar"));


            installedBundles.add(context.installBundle(
                    "file:///Users/frank/Documents/workspace43/stackoverflow.test/deploy/plugins/it.eng.test.ds.consumer_1.0.0.201401070832.jar"));




        } catch (BundleException e) {
            e.printStackTrace();
        }


        for (Bundle bundle : installedBundles) {

            try {
                bundle.start();


            } catch (BundleException e) {

                e.printStackTrace();
            }

        }System.out.println("after starting bundles");





    }
}