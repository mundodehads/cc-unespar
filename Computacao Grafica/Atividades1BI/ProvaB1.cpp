/*
 * ProvaB1.cpp
 *
 *  Created on: 5 de out de 2017
 *      Author: henrique.silva
 *
 *  Tips:
 *  	A altura e largura são relevantes para os desenhos de teardrop e helice,
 *  	ambos são desenhados no centro por implementação.
 */

#include <gl/glut.h>
#include <stdio.h>
#include <math.h>

#include "desenhos.h"


GLfloat windowWidth;
GLfloat windowHeight;
Desenhos d;

void display (void);
void myMouse(GLint button, GLint state, GLint x, GLint y);
void myInit (void);

void girarHelice (void);

void Awake () {
	windowWidth = 800;
	windowHeight = 600;
}

int main(int argc, char **argv){
	Awake();
	glutInit(&argc,argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(windowWidth,windowHeight);
	glutInitWindowPosition(300,100);
	glutCreateWindow("ComputacaoGrafica - ProvaB1");
	glutDisplayFunc(display);
	glutMouseFunc(myMouse);
	myInit();
	glutMainLoop();
}

void myInit (void){
	glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
	glColor3f(0.0f, 0.0f, 0.0f);
	glPointSize(4.0);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0.0f, windowWidth, 0.0f, windowHeight);
}

void display (void){
	glClear(GL_COLOR_BUFFER_BIT);
	d.helice((windowWidth/2), (windowHeight/2), windowWidth, windowHeight);
	glFlush();
}

void myMouse (GLint button, GLint state, GLint x, GLint y){
	if(button == GLUT_LEFT_BUTTON){
		if(state == GLUT_DOWN){
			glutIdleFunc(girarHelice);
		}else {
			glutIdleFunc(display);
		}
	}
	glFlush();
}

void girarHelice (void){
	glTranslatef((windowWidth/2), (windowHeight-(windowHeight/2)), 0 );
	glRotatef(-0.1f, 0.0f, 0.0f, 1.0f);
	glTranslatef( -(windowWidth/2), -(windowHeight-(windowHeight/2)), 0 );

	glutPostRedisplay();
}
