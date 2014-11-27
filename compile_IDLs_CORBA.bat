cd %homedrive%%homepath%
cd workspace_distribuido\EuQuero\src
set path=%path%;"C:\Program Files (x86)\Java\jdk1.7.0_71\bin"
idlj -fall .\br\org\furb\corba\anuncio\AnuncioCORBA.idl
idlj -fall .\br\org\furb\corba\notificacao\NotificacaoCORBA.idl
pause	