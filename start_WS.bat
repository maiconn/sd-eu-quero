cd %homepath%
cd workspace_distribuido\EuQUero\src\
set path=%path%;"C:\Program Files (x86)\Java\jdk1.7.0_71\bin"
set classpath=.;..\bin;..\lib\mongo-java-driver-2.6.5.jar
apt br\org\furb\ws\usuario\UsuarioWS.java
cd ..\bin
start java br.org.furb.ws.usuario.UsuarioPublicaService
cd ..\src
wsimport -keep -p br.org.furb.ws.usuario.cliente http://localhost/usuario?wsdl
pause
