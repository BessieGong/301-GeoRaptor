package org.GeoRaptor.SpatialView;

import oracle.dbtools.spatial.mapviewer.MapGeometry;
import oracle.dbtools.spatial.mapviewer.components.MapViewerHelper;
import oracle.dbtools.spatial.mapviewer.MapViewerRenderer;

public class MapViewerController {
    
    MapViewerController mvc;
    MapViewerRenderer   mvr;
    MapViewerHelper     mvh;
    MapGeometry         mg;
    
    public MapViewerController() {
        mvc = new MapViewerController();
        mvr = new MapViewerRenderer();
    }
    
}
