cd %homepath%
cd workspace\EuQuero\bin\
set path=%path%;"C:\Arquivos de programas\Java\jdk1.7.0_25\bin"
set classpath=.
rmic -keep br.org.furb.rmi.oferta.OfertaServer
rmic -keep br.org.furb.rmi.desejo.DesejoServer
rmiregistry
pause