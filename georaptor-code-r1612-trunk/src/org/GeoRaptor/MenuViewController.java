package org.GeoRaptor;

import java.util.ArrayList;

import javax.ide.model.Element;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import oracle.ide.Context;
import oracle.ide.Ide;
import oracle.ide.IdeMainWindow;
import oracle.ide.controller.MenuManager;
import oracle.ide.controller.Menubar;
import oracle.ide.db.model.DBObjectTypeNode;
import oracle.ide.controller.Controller;
import oracle.ide.controller.IdeAction;


public class MenuViewController{

	private JMenu geoRaptorViewMenu;
	private static MenuViewController instance=null;    
	
	
    private MenuViewController() {
    }
    
    public static MenuViewController getInstance() {
        if (instance == null) {
            instance = new MenuViewController();
        }
        return instance;
    }

    /** 
     * @author Simon Greener, March 31st 2010
     *          Added second parameter to Messages.log
     *          Removed Messages.log to ControlerSV.addToViewMenu()
     **/
    public void addToViewMenu(JMenuItem _addItem) 
    {
        assertGeoRaptorViewMenu();
        geoRaptorViewMenu.add(_addItem);
    }

    private void assertGeoRaptorViewMenu() {
        if (geoRaptorViewMenu == null) {
            final Menubar menubar = Ide.getMenubar();
            ClassLoader cl = getClass().getClassLoader();
            this.geoRaptorViewMenu = menubar.createMenu(MainSettings.MENU_ITEM, 
                                                        new Integer((int)'G'));
            this.geoRaptorViewMenu.setIcon(new ImageIcon(cl.getResource("org/GeoRaptor/images/main_icon_2_18x18.png")));
            MenuManager.getJMenu(IdeMainWindow.MENU_VIEW).add(this.geoRaptorViewMenu);
        }
    }
	
}
