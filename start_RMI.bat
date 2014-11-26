cd %homepath%
cd workspace_distribuido\EuQuero\bin\
set path=%path%;"C:\Program Files (x86)\Java\jdk1.7.0_71\bin"
set classpath=.
rmic -keep br.org.furb.rmi.oferta.OfertaServer
rmic -keep br.org.furb.rmi.desejo.DesejoServer
rmiregistry
pause