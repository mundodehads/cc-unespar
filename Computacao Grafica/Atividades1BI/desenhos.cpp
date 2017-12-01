/*
 * desenhos.cpp
 *
 *  Created on: 5 de out de 2017
 *      Author: henrique.silva
 */

#include <gl/glut.h>
#include <stdio.h>
#include <math.h>

#include "desenhos.h"

void desenhar_aresta(int *p1, int *p2);
inline float get_distancia(int *p1, int *p2);
void ponto_medio(int *pd, int *p1, int *p2);
void desenhar_circulo(int *pcentro, float raio, int nlinhas);

void Desenhos::helice (int x, int y, float windowWidth, float windowHeight){
	teardrop(x, y, windowHeight);
	glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
	glRotatef(-45, 0.0f, 0.0f, 1.0f);
	glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
	teardrop(x, y, windowHeight);
	glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
	glRotatef(-45, 0.0f, 0.0f, 1.0f);
	glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
	teardrop(x, y, windowHeight);
	glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
	glRotatef(-45, 0.0f, 0.0f, 1.0f);
	glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
	teardrop(x, y, windowHeight);
	glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
	glRotatef(-45, 0.0f, 0.0f, 1.0f);
	glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
	teardrop(x, y, windowHeight);
    glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
    glRotatef(-45, 0.0f, 0.0f, 1.0f);
    glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
    teardrop(x, y, windowHeight);
    glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
    glRotatef(-45, 0.0f, 0.0f, 1.0f);
    glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
    teardrop(x, y, windowHeight);
    glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
    glRotatef(-45, 0.0f, 0.0f, 1.0f);
    glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
    teardrop(x, y, windowHeight);
    glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
    glRotatef(-45, 0.0f, 0.0f, 1.0f);
    glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );
}

void Desenhos::teardrop(int x, int y, float windowHeight){
	int hipotenusa = 150;
	float angulo = 2.5*M_PI/3;
	int p1[2] = {x, windowHeight - y};
	int p2[2];
	int p3[2];
	int praio[2];
	float raio;
	int ny = windowHeight - y +  hipotenusa * sin(angulo/2.0);
	int x2, x3;
	x2 = x + hipotenusa * cos(angulo/2.0);
	x3 = x - hipotenusa * cos(angulo/2.0);
	p2[0]= x2;
	p2[1] = ny;
	p3[0] = x3;
	p3[1] = ny;
	desenhar_aresta(p2, p1);
	desenhar_aresta(p3, p1);
	raio = get_distancia(p2, p3) / 2;
	ponto_medio(praio, p2, p3);
	desenhar_circulo(praio, raio, 20);
}

void desenhar_aresta(int *p1, int *p2){
    glBegin(GL_LINES);
        glVertex2i(p1[0], p1[1]);
        glVertex2i(p2[0], p2[1]);
    glEnd();
}

inline float get_distancia(int *p1, int *p2){
	return sqrt(pow(p1[0] - p2[0], 2) + pow(p1[1] - p2[1], 2));
}

void ponto_medio(int *pd, int *p1, int *p2){
    pd[0] = (int) (p1[0] + p2[0]) / 2;
    pd[1] = (int) (p1[1] + p2[1]) / 2;
}

void desenhar_circulo(int *pcentro, float raio, int nlinhas){
    float angulo;
    glBegin(GL_LINE_STRIP);
        for(int i=0; i<=nlinhas; i++){
            angulo = i * M_PI / nlinhas;
            glVertex2f(pcentro[0] + (cos(angulo) * raio), pcentro[1] + (sin(angulo)*raio));
        }
    glEnd();
}

void Desenhos::bulbasaurPixel(){
	glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(0.0f, 0.0f, 0.0f);
		glPointSize(10);
		glBegin(GL_POINTS);
			glVertex2i(200,170);
			glVertex2i(200,160);
			glVertex2i(190,170);
			glVertex2i(210,150);
			glVertex2i(220,150);
			glVertex2i(230,150);
			glVertex2i(240,160);
			glVertex2i(250,160);
			glVertex2i(260,160);
			glVertex2i(270,160);
			glVertex2i(270,170);
			glVertex2i(270,150);
			glVertex2i(270,140);
			glVertex2i(280,180);
			glVertex2i(280,190);
			glVertex2i(280,200);
			glVertex2i(270,210);
			glVertex2i(260,220);
			glVertex2i(250,220);
			glVertex2i(240,230);
			glVertex2i(240,240);
			glVertex2i(230,250);
			glVertex2i(220,250);
			glVertex2i(210,240);
			glVertex2i(210,230);
			glVertex2i(200,230);
			glVertex2i(190,230);
			glVertex2i(180,220);
			glVertex2i(170,220);
			glVertex2i(160,210);
			glVertex2i(160,200);
			glVertex2i(160,190);
			glVertex2i(170,190);
			glVertex2i(180,180);
			glVertex2i(150,200);
			glVertex2i(140,200);
			glVertex2i(130,210);
			glVertex2i(120,200);
			glVertex2i(120,190);
			glVertex2i(120,180);
			glVertex2i(110,170);
			glVertex2i(110,160);
			glVertex2i(110,150);
			glVertex2i(100,160);
			glVertex2i(100,150);
			glVertex2i(100,140);
			glVertex2i(100,130);
			glVertex2i(110,120);
			glVertex2i(120,110);
			glVertex2i(130,110);
			glVertex2i(140,100);
			glVertex2i(150,100);
			glVertex2i(160,100);
			glVertex2i(170,100);
			glVertex2i(180,100);
			glVertex2i(190,100);
			glVertex2i(200,100);
			glVertex2i(200,110);
			glVertex2i(210,120);
			glVertex2i(220,130);
			glVertex2i(210,90);
			glVertex2i(220,90);
			glVertex2i(230,90);
			glVertex2i(240,100);
			glVertex2i(240,110);
			glVertex2i(240,120);
			glVertex2i(240,140);
			glVertex2i(250,130);
			glVertex2i(260,130);
			glVertex2i(160,120);
			glVertex2i(160,130);
			glVertex2i(170,140);
			glVertex2i(180,140);

			glColor3f(1.0f, 0.0f, 0.0f);
			glVertex2i(170,130);
			glVertex2i(170,120);

			glColor3f(0.0f, 0.8f, 0.0f);
			glVertex2i(200,180);
			glVertex2i(200,190);
			glVertex2i(200,200);
			glVertex2i(200,210);
			glVertex2i(200,220);
			glVertex2i(190,180);
			glVertex2i(190,190);
			glVertex2i(190,200);
			glVertex2i(190,210);
			glVertex2i(190,220);
			glVertex2i(180,190);
			glVertex2i(180,200);
			glVertex2i(180,210);
			glVertex2i(170,200);
			glVertex2i(170,210);
			glVertex2i(210,160);
			glVertex2i(210,170);
			glVertex2i(210,180);
			glVertex2i(210,190);
			glVertex2i(210,200);
			glVertex2i(210,210);
			glVertex2i(210,220);
			glVertex2i(220,160);
			glVertex2i(220,170);
			glVertex2i(220,180);
			glVertex2i(220,190);
			glVertex2i(220,200);
			glVertex2i(220,210);
			glVertex2i(220,220);
			glVertex2i(220,230);
			glVertex2i(220,240);
			glVertex2i(230,160);
			glVertex2i(230,170);
			glVertex2i(230,180);
			glVertex2i(230,190);
			glVertex2i(230,200);
			glVertex2i(230,210);
			glVertex2i(230,220);
			glVertex2i(230,230);
			glVertex2i(230,240);
			glVertex2i(240,170);
			glVertex2i(240,180);
			glVertex2i(240,190);
			glVertex2i(240,200);
			glVertex2i(240,210);
			glVertex2i(240,220);
			glVertex2i(250,170);
			glVertex2i(250,180);
			glVertex2i(250,190);
			glVertex2i(250,200);
			glVertex2i(250,210);
			glVertex2i(260,170);
			glVertex2i(260,180);
			glVertex2i(260,190);
			glVertex2i(260,200);
			glVertex2i(260,210);
			glVertex2i(270,180);
			glVertex2i(270,190);
			glVertex2i(270,200);

			glColor3f(0.3f, 0.3f, 1.0f);
			glVertex2i(190,160);
			glVertex2i(190,150);
			glVertex2i(190,140);
			glVertex2i(190,130);
			glVertex2i(190,120);
			glVertex2i(190,110);
			glVertex2i(200,150);
			glVertex2i(200,140);
			glVertex2i(200,130);
			glVertex2i(200,120);
			glVertex2i(210,140);
			glVertex2i(210,130);
			glVertex2i(220,130);
			glVertex2i(230,130);
			glVertex2i(230,120);
			glVertex2i(230,110);
			glVertex2i(230,100);
			glVertex2i(210,120);
			glVertex2i(220,120);
			glVertex2i(220,110);
			glVertex2i(220,100);
			glVertex2i(210,110);
			glVertex2i(210,100);
			glVertex2i(220,140);
			glVertex2i(230,140);
			glVertex2i(240,130);
			glVertex2i(240,150);
			glVertex2i(250,150);
			glVertex2i(250,140);
			glVertex2i(260,150);
			glVertex2i(260,140);
			glVertex2i(180,170);
			glVertex2i(180,160);
			glVertex2i(180,150);
			glVertex2i(170,150);
			glVertex2i(160,140);
			glVertex2i(160,150);
			glVertex2i(160,160);
			glVertex2i(160,170);
			glVertex2i(160,180);
			glVertex2i(160,190);
			glVertex2i(170,160);
			glVertex2i(170,170);
			glVertex2i(170,180);
			glVertex2i(180,130);
			glVertex2i(180,120);
			glVertex2i(180,110);
			glVertex2i(170,110);
			glVertex2i(160,110);
			glVertex2i(150,110);
			glVertex2i(150,120);
			glVertex2i(150,130);
			glVertex2i(150,140);
			glVertex2i(150,150);
			glVertex2i(150,160);
			glVertex2i(150,170);
			glVertex2i(150,180);
			glVertex2i(150,190);
			glVertex2i(140,190);
			glVertex2i(140,180);
			glVertex2i(140,170);
			glVertex2i(140,160);
			glVertex2i(140,150);
			glVertex2i(140,140);
			glVertex2i(140,130);
			glVertex2i(140,120);
			glVertex2i(140,110);
			glVertex2i(130,120);
			glVertex2i(130,130);
			glVertex2i(130,140);
			glVertex2i(130,150);
			glVertex2i(130,160);
			glVertex2i(130,170);
			glVertex2i(130,180);
			glVertex2i(130,190);
			glVertex2i(130,200);
			glVertex2i(120,120);
			glVertex2i(120,130);
			glVertex2i(120,140);
			glVertex2i(120,150);
			glVertex2i(120,160);
			glVertex2i(120,170);
			glVertex2i(110,130);
			glVertex2i(110,140);


		glEnd();
}



