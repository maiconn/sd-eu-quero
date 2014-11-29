cd %homedrive%%homepath%
cd workspace_distribuido\EuQuero\bin\
set path=%path%;"C:\Arquivos de programas\Java\jdk1.7.0_25\bin"
set classpath=.;..\bin;..\lib\mongo-java-driver-2.6.5.jar
start orbd
start java br.org.furb.corba.anuncio.AnuncioServer
start java br.org.furb.corba.notificacao.NotificacaoServer