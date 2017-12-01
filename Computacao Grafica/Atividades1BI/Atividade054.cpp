/*
 * Atividade054.cpp
 *
 *  Created on: 5 de out de 2017
 *      Author: henrique.silva
 *
 */

/*
#include <iostream>
#include <fstream>
#include <string>
#include <windows.h>
#include <stdio.h>
#include <gl/glut.h>

class GLintPoint{
public:
GLint x, y;
};

using namespace std;
int windowHeight = 600;
int windowWidth = 800;

void readFile () {
  string linha;
  ifstream myfile ("dino.dat");
  glColor3f(1.0f, 0.0f, 0.0f);
  if (!myfile){
  	cout<<"O arquivo nao está aberto"<<endl;
  }else{
  	int x, y, qtPolig, qtLinhas;
  	myfile >> qtPolig;
  	for(int i = 0; i < qtPolig; i++){
  		myfile >> qtLinhas;
  		for(int j = 0; j < qtLinhas; j++){
  			glBegin(GL_LINE_STRIP);
  			myfile>> x >> y;
  			glVertex2i(x,y);
  		}
  		glEnd();
  	}
  }
    myfile.close();
}

void setWindow(float left, float right, float bottom, float top)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(left, right, bottom, top);
}

void inicia (void){
	glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
	setWindow(0.0f, windowWidth, 0.0f, windowHeight);
}

void display (void){
	glClear(GL_COLOR_BUFFER_BIT);
	int tam = 2;
	for(int i = 0; i < tam; i++){
		for(int j = 0; j < tam; j++){
			glViewport( i*(windowWidth/tam), j*(windowHeight/tam), (windowWidth/tam), (windowHeight/tam));
			setWindow(windowWidth, 0.5f, windowHeight, 0.0f);
			readFile();
			setWindow(0.0f, windowWidth, 0.0f, windowHeight);
			readFile();
		}
	}
	glFlush();
}

int main (void){
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(windowWidth,windowHeight);
	glutInitWindowPosition(10, 10);
	glutCreateWindow("TesteDino");
	glutDisplayFunc(display);
	inicia();
	glutMainLoop();
}

*/


