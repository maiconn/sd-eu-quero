cd %homepath%
cd workspace_distribuido\EuQuero\bin\
set path=%path%;"C:\Program Files (x86)\Java\jdk1.7.0_71\bin"
set classpath=.;..\bin;..\lib\mongo-java-driver-2.6.5.jar
rmic -keep br.org.furb.rmi.oferta.OfertaServer
rmic -keep br.org.furb.rmi.desejo.DesejoServer
start rmiregistry
timeout /t 5
start java br.org.furb.rmi.oferta.OfertaServer
start java br.org.furb.rmi.desejo.DesejoServer