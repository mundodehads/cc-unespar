
/*
 * Atividade041.cpp
 *
 *  Created on: 5 de out de 2017
 *      Author: henrique.silva
 *
 *  Obs: faltou o abrir com a tecla 'o'
 */

/*
#include <windows.h>
#include <math.h>
#include <gl/glut.h>
#include <list>
#include <fstream>
#include <stdio.h>
using namespace std;

typedef struct pontos{
	GLint x;
	GLint y;
} ponto;

list<ponto> lista;
GLfloat windowWidth;
GLfloat windowHeight;

void display (void);
void myMouse(GLint button, GLint state, GLint x, GLint y);
void myKeyboard(unsigned char key, int x, int y);
void myInit (void);
list<ponto>::iterator menor(GLint x, GLint y);
GLdouble distancia(ponto p, GLint x, GLint y);

int main (void){
	windowWidth = 400;
	windowHeight = 350;

	//glutInit(&argc, argv)

	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(windowWidth,windowHeight);
	glutInitWindowPosition(683-(windowWidth/2),384-(windowHeight/2));
	glutCreateWindow("Poliedricos");
	glutDisplayFunc(display);
	glutMouseFunc(myMouse);
	glutKeyboardFunc(myKeyboard);
	myInit();
	glutMainLoop();
}

void myInit (void){
	glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
	gluOrtho2D(0.0f, windowWidth, 0.0f, windowHeight);
}

void display (void){
	if(lista.size() > 1){
		glClear(GL_COLOR_BUFFER_BIT);
		glLineWidth(3);
		glColor3f(0.0f, 0.0f, 0.0f);
		int i = 0;
		ponto aux;
			for(ponto p : lista){
				if(i > 0){
					glBegin(GL_LINES);
						glVertex2i(aux.x, windowHeight-aux.y);
						glVertex2i(p.x, windowHeight-p.y);
					glEnd();
					i=0;
				}
				aux = p;
				i++;
			}
	}
	glFlush();
}

void myKeyboard(unsigned char key, int x, int y) {
	if(key == 's'){
		ofstream arquivo("pontos.txt");
		if (arquivo.is_open())
		  {
		  	ponto aux;
		  	bool primeiro = false;
		    for(ponto p : lista){
		    	if(primeiro){
		    		arquivo<<aux.x<<" "<<aux.y<<" "<<p.x<<" "<<p.y<<endl;
		    		aux = p;
		    	}else {
		    		primeiro = true;
		    		aux = p;
		    	}
		    }
		    printf("deu bom\n");
		  }else printf("deu ruim\n");
		arquivo.close();
	}
}

void myMouse (GLint button, GLint state, GLint x, GLint y){
	if(button == GLUT_LEFT_BUTTON){
		if(state == GLUT_DOWN){
			ponto aux;
			aux.x = x;
			aux.y = y;
			lista.push_back(aux);
		}
	}else {
		if(state == GLUT_DOWN){
			if(!lista.empty()) lista.erase(menor(x, y));
		}
	}
	display();
}

list<ponto>::iterator menor(GLint x, GLint y){
	list<ponto>::iterator i = lista.begin();
	list<ponto>::iterator aux = i;
	GLdouble menor = distancia(lista.front(), x, y);
	for(ponto p : lista){
		GLdouble d = distancia(p, x, y);
		if(menor > d){
			menor = d;
			aux = i;
		}
		i++;
	}
	return aux;
}

GLdouble distancia (ponto p, GLint x, GLint y){
	return sqrt(pow(p.x - x, 2) + pow(p.y - y, 2));
}

*/



