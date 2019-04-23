package org.GeoRaptor.Snippets;

import java.io.File;

import java.net.MalformedURLException;

import java.net.URL;

import oracle.dbtools.raptor.snippet.SnippetAddin;

import oracle.ide.Addin;

import org.GeoRaptor.Messages;

public class GeoRaptorSnippetsAddin implements Addin {
    public GeoRaptorSnippetsAddin() {
    }

    /** @author : Simon Greener - 14th March 2010 
     *            - Modified code to report when XML file does not exist
     *              Also, changed name of snippets file.
     **/
    public void initialize() 
    {
        URL snippets = getClass().getResource("/org/GeoRaptor/snippets.xml");
        if (snippets != null)  {
            System.out.println("GeoRaptorSnippetsAddin: Registering: " + snippets.toString());
            //  Registering: jar:file:/F:/oracle/sqldeveloper32/sqldeveloper/extensions/org.GeoRaptor.jar!/org/GeoRaptor/snippets.xml
            SnippetAddin.registerSnippet(snippets);
        } else {
            System.out.println("Didn't find snippets.xml, load from file");
            try 
            {
                File geoSnippetsFile = new File("../extensions/GeoRaptorLibs/GeoRaptorSnippets.xml");
                // Does XML document exit?
                if ( ! geoSnippetsFile.exists() ) {
                   Messages.log(geoSnippetsFile.toString() + " does not exist.",true);
                   System.out.println(geoSnippetsFile.toString() + " does not exist.");
                } else {
                    System.out.println("Found: "       + geoSnippetsFile.toString());
                    System.out.println("... Registering: " + geoSnippetsFile.toURI().toURL().toString());
                   // register the snippet url
                   // TODO Update Snippets implementation
                   SnippetAddin.registerSnippet(geoSnippetsFile.toURI().toURL());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
