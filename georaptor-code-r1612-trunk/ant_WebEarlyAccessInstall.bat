echo on
SET PATH=C:\Program Files\Java\jdk1.6.0_45\jre\bin;C:\oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\bin;f:\projects\GeoRaptor\trunk32
SET CLASSPATH=C:\Program Files\Java\jdk1.6.0_45\jre\lib;C:\oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\lib;f:\projects\GeoRaptor\trunk32

del build.log
ant -verbose -debug -lib F:\oracle\sqldeveloper32\sqldeveloper\lib -lib C:\Oracle\Middleware\Oracle_Home\oracle_common\modules\org.apache.ant_1.9.2\bin\..\lib -lib f:\Projects\GeoRaptor\trunk -DSQLDeveloper.version="" -l build.log WebEarlyAccessInstall
 
pause
