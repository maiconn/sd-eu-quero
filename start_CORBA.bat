cd %homedrive%%homepath%
cd workspace\EuQuero\src\
set path=%path%;"C:\Arquivos de programas\Java\jdk1.7.0_25\bin"
idlj -fall br\org\furb\corba\notificacao\NotificacaoBoasVindas.idl
javac br\org\furb\corba\notificacao\*.java
set classpath=.
javac *.java
start orbd
start java br.org.furb.corba.notificacao.notificacaoServer
java cliente -ORBInitialHost localhost
pause