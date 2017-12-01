berilo(X,Y) :-
	X=duro,Y=oxido;
	X=oxido,Y=duro;
	X=duro,Y=_;
	X=_,Y=duro.

rubi(X,Y) :-
	X=oxido,Y=vermelho;
	X=vermelho,Y=oxido.

esmeralda(X,Y) :-
	X=oxido,Y=verde;
	X=verde,Y=oxido.

safira(X,Y) :-
	X=oxido,dif(Y,verde),dif(Y,vermelho);
	Y=oxido,dif(X,verde),dif(X,vermelho).

mineral(X,Y,Z) :-
	berilo(X,Y) -> Z=berilo;
	rubi(X,Y) -> Z=rubi;
	esmeralda(X,Y) -> Z=esmeralda;
	safira(X,Y) -> Z=safira.
