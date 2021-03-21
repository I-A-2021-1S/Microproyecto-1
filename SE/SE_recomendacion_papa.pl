/*
---------------------------------------------------------------------------------
El siguiente sistema experto toma la altitud de un terreno (msnm),
su clima promedio (°C) y el rendimiento esperdo de producción (T/ha) 
para recomendarle al usuario que tipo de papa le dará el mejor rendimiento, 
tendrá mejor sostenibilidad y afectará menos negativamente al medio.
---------------------------------------------------------------------------------
*/
sugerir(X) :- write('Ingresa la altitud del terreno (msnm): '), read(AL),
    write('Ingresa el rendimiento esperado en toneladas por hectareas: '), read(R),
    write('Ingresa la temperatura media del ambiente del lugar: (°C) '),read(C),
    write('Ingresa las horas de exposición a luz:'),read(L),
    write('Ingresa el PH del terreno: '),read(PH),
    write('El nivel de agua a regar: (L/m^2) '),read(AG),
    verificar_agua(AG2,AG),
    verificar_luz(L2,L),
    verificar_ph(PH2,PH),
    write('El tipo de papa recomendado según las condiciones ingresadas es: '), 	
    recomendar(X,AL,R,C,AG2,L2,PH2).

/*Reglas de verificacion agua*/
verificar_agua(baja,AG):- AG<370.
verificar_agua(alta,AG):- AG>650.
verificar_agua(optima,AG):- AG=<650, AG>=370.

/*Reglas de verificacion luz */
verificar_luz(baja,L):-L<7.
verificar_luz(alta,L):-L>13.
verificar_luz(optima,L):-L=<13, L>=7.

/*Reglas de verificacion PH */
verificar_ph(acido,PH):-PH<6.5.
verificar_ph(basico,PH):-PH>7.5.
verificar_ph(neutro,PH):-PH=<7.5, PH>=6.5.



recomendar(mucha_agua,_,_,_,AG,_,_):-AG=alta,!.
recomendar(poca_agua,_,_,_,AG,_,_):-AG=baja,!.
recomendar(poca_luz,_,_,_,_,L,_):-L=baja,!.
recomendar(mucha_luz,_,_,_,_,L,_):-L=alta,!.
recomendar(ph_acido,_,_,_,_,_,PH):-PH=acido,!.
recomendar(ph_basico,_,_,_,_,_,PH):-PH=basico,!.

recomendar(pastusa_suprema,A,R,C,_,_,_):-(A>=2000,A=<3500),(R>=15,R=<20),(C>=12,C=<18).
recomendar(diacol_capiro,A,R,C,_,_,_):-(A>=2300,A=<3200), (R>=25,R=<30),(C>=14,C=<17).
recomendar(parda_pastua,A,R,C,_,_,_):-(A>=2000,A=<3500), (R>=28,R=<33),(C>=10,C=<17).
recomendar(tocarreña,A,R,C,_,_,_):-(A>=2600,A=<3200), (R>=18,R=<23),(C>=15,C=<20).
recomendar(criolla,A,R,C,_,_,_):-(A>=1800,A=<3200), (R>=7,R=<12),(C>=10,C=<20).
recomendar(ica_unica,A,R,C,_,_,_):-(A>=2600,A=<3200), (R>=30,R=<45),(C>=13,C=<24).
recomendar(perla_negra,A,R,C,_,_,_):-(A>=2500,A=<2700), (R>=27,R=<37),(C>=10,C=<17).
recomendar(rubi,A,R,C,_,_,_):-(A>=2750,A=<3200), (R>=40,R=<47),(C>=10,C=<23).
recomendar(ica_purace,A,R,C,_,_,_):-(A>=2200,A=<3000), (R>=30,R=<37),(C>=11,C=<18).