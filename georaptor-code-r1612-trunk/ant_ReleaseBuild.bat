echo on
SET      PATH=C:\Program Files\Java\jdk1.6.0_45\jre\bin;C:\oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\bin;C:\oracle\Middleware\Oracle_Home\jdeveloper\sqldeveloper\bin;f:\projects\GeoRaptor\trunk
SET CLASSPATH=C:\Program Files\Java\jdk1.6.0_45\jre\lib;C:\oracle\Middleware\Oracle_Home\jdeveloper\sqldeveloper\lib;C:\oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\lib;f:\projects\GeoRaptor\trunk

del build.log
ant -verbose -debug -lib C:\oracle\Middleware\Oracle_Home\jdeveloper\sqldeveloper\lib -lib f:\Projects\GeoRaptor\trunk -DSQLDeveloper.version="" -l build.log ReleaseBuild
