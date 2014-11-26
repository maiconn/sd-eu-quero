cd %homepath%
cd workspace_distribuido\EuQuero\bin\
set path=%path%;"C:\Program Files (x86)\Java\jre7\bin"
set classpath=.
rmic -keep br.org.furb.rmi.oferta.OfertaServer
rmic -keep br.org.furb.rmi.oferta.DesejoServer
rmiregistry
pause