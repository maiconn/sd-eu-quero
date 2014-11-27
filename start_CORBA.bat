cd %homedrive%%homepath%
cd workspace_distribuido\EuQuero\bin\
set path=%path%;"C:\Arquivos de programas\Java\jdk1.7.0_25\bin"
start orbd
start java br.org.furb.corba.anuncio.AnuncioServer
start java br.org.furb.corba.notificacao.NotificacaoServer
pause