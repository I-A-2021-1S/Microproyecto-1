


/*
---------------------------------------------------------------------------------
El siguiente sistema experto toma la altitud de un terreno (msnm),
su clima promedio (°C) y el rendimiento esperdo de producción (T/ha) 
para recomendarle al usuario que tipo de papa le dará el mejor rendimiento, 
tendrá mejor sostenibilidad y afectará menos negativamente al medio.
---------------------------------------------------------------------------------
*/
sugerir(Papa) :- write('Ingresa la altitud del terreno:'), read(A),
    write('Ingresa el rendimiento esperado en toneladas por hectareas: '), read(R),
    write('Ingresa clima:'),read(C),
    recomendar(Papa,A,R,C).


recomendar(pastusa_suprema,A,R,C):-(A>=2000,A=<3500),(R>=15,R=<20),(C>=12,C=<18),!.
recomendar(diacol_capiro,A,R,C):-(A>=2300,A=<3200), (R>=25,R=<30),(C>=14,C=<17),!.
recomendar(parda_pastua,A,R,C):-(A>=2000,A=<3500), (R>=28,R=<33),(C>=10,C=<17),!.
recomendar(tocarreña,A,R,C):-(A>=2600,A=<3200), (R>=18,R=<23),(C>=15,C=<20),!.
recomendar(criolla,A,R,C):-(A>=1800,A=<3200), (R>=7,R=<12),(C>=10,C=<20),!.
recomendar(ica_unica,A,R,C):-(A>=2600,A=<3200), (R>=30,R=<45),(C>=13,C=<24),!.
recomendar(perla_negra,A,R,C):-(A>=2500,A=<2700), (R>=27,R=<37),(C>=10,C=<17),!.
recomendar(rubi,A,R,C):-(A>=2750,A=<3200), (R>=40,R=<47),(C>=10,C=<23),!.
recomendar(ica_purace,A,R,C):-(A>=2200,A=<3000), (R>=30,R=<37),(C>=11,C=<18),!.
