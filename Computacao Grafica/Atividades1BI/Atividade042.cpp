/*
 * Atividade042.cpp
 *
 *  Created on: 5 de out de 2017
 *      Author: henrique.silva
 */

/*
#include <windows.h>
#include <gl/glut.h>
#include <fstream>
#include <stdio.h>
using namespace std;

GLfloat windowWidth;
GLfloat windowHeight;

void display (void);
void myInit (void);
void desenharDino (void);

int main (void){
	windowWidth = 800;
	windowHeight = 600;

	//glutInit(&argc, argv)

	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(windowWidth,windowHeight);
	glutInitWindowPosition(683-(windowWidth/2),384-(windowHeight/2));
	glViewport(0,0,200,150);
	glutCreateWindow("Dino");
	glutDisplayFunc(display);
	myInit();
	glutMainLoop();
}

void myInit (void){
	glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
	gluOrtho2D(0.0f, windowWidth, 0.0f, windowHeight);
	//gluOrtho2D(windowWidth, 0.0f, windowHeight, 0.0f);
}

void display (void){
	desenharDino();

	glFlush();
}

void desenharDino(void){
	ifstream arquivo ("dino.dat");
	if (arquivo.is_open()) {
		GLint poligonos, linhas, x, y;
		arquivo >> poligonos;
		glClear(GL_COLOR_BUFFER_BIT);
		glLineWidth(1);
		glColor3f(0.0f, 0.0f, 0.0f);
		for(int j = 0; j < poligonos; j++) {
			arquivo>>linhas;
			glBegin(GL_LINE_STRIP);
			for (int i = 0; i < linhas; i++) {
				arquivo >> x >> y;
				glVertex2i(x,y);
			}
			glEnd();
		}
	}
}

*/

