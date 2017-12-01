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
void myInit (void);

list<ponto>::iterator menor(GLint x, GLint y);
GLdouble distancia(ponto p, GLint x, GLint y);

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
	glutCreateWindow("ComputacaoGrafica - Atividade031");
	glutDisplayFunc(display);
	glutMouseFunc(myMouse);
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
