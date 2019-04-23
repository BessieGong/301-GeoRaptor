package org.GeoRaptor.SpatialView.JDevInt;

import oracle.ide.Addin;

public class AnAddinSV 
  implements Addin 
{
    private ControlerSV     _controler;
    private DockableSVFactory _factory;
    private static AnAddinSV  INSTANCE;

    public AnAddinSV() {
        INSTANCE = this;
    }

    public static AnAddinSV getInstance() {
        return INSTANCE;
    }

    public void initialize() {
        _factory = new DockableSVFactory();
        _controler = new ControlerSV();
    }

    public DockableSVFactory getFactory() {
        return _factory;
    }
    public void deactivate()
    {
        System.out.println("deactivate()");
    }
    
    public void shutdown()
    {
       System.out.println("shutdown()");
    }
    
}
