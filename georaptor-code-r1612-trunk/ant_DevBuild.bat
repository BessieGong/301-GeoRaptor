echo on
SET PATH=C:\Program Files\Java\jdk1.6.0_45\jre\bin;C:\oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\bin;f:\projects\GeoRaptor\trunk32
SET CLASSPATH=C:\Program Files\Java\jdk1.6.0_45\jre\lib;C:\oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\lib;f:\projects\GeoRaptor\trunk32

del build.log
rem ant -verbose -lib f:\Projects\GeoRaptor\trunk32 -DSQLDeveloper.version="" -l build.log DevBuild 
rem ant -verbose -lib f:\Projects\GeoRaptor\trunk -DSQLDeveloper.version="" -l build.log DevBuild 
    ant          -lib f:\Projects\GeoRaptor\trunk -DSQLDeveloper.version="" -l build.log DevBuild 
pause
