/*
#include <windows.h>
#include <math.h>
#include <gl/glut.h>
#include <list>
#include <fstream>
#include <stdio.h>

#include "desenhos.h"

using namespace std;

GLfloat windowWidth;
GLfloat windowHeight;

void display (void);
void myInit (void);

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
	glutCreateWindow("ComputacaoGrafica - Atividade011");
	glutDisplayFunc(display);
	myInit();
	glutMainLoop();
}

void myInit (void){
	glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
	gluOrtho2D(0.0f, windowWidth, 0.0f, windowHeight);
}

void display (void){
	Desenhos d;
	d.bulbasaurPixel();
	glFlush();
}

*/

