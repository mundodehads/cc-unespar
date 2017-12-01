/*
#include <windows.h>
#include <math.h>
#include <gl/glut.h>
#include <list>

GLint pontos[2][100];
GLfloat windowWidth;
GLfloat windowHeight;
GLint indice;
GLint corrente;
GLint doteSize;

void display (void);
void myMouse(GLint button, GLint state, GLint x, GLint y);
void myInit (void);
void myKeyboard (GLint key, GLint x, GLint y);
void menor(GLint x, GLint y);
GLdouble distancia(GLint i, GLint x, GLint y);

int main (void){
	windowWidth = 400;
	windowHeight = 350;
	doteSize = 10;
	indice = 0;
	corrente = 0;

	//glutInit(&argc, argv)

	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(windowWidth,windowHeight);
	glutInitWindowPosition(683-(windowWidth/2),384-(windowHeight/2));
	glutCreateWindow("Teste");
	glutDisplayFunc(display);
	glutMouseFunc(myMouse);
	glutSpecialUpFunc(myKeyboard);
	myInit();
	glutMainLoop();
}

void myInit (void){
	glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
	gluOrtho2D(0.0f, windowWidth, 0.0f, windowHeight);
}

void display (void){
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0f, 0.0f, 0.0f);
	glPointSize(doteSize);
	glBegin(GL_POINTS);
	for(int x=0;x<indice;x++){
		glVertex2i(pontos[0][x], windowHeight-pontos[1][x]);
	}
	glEnd();
	glFlush();
}

void myMouse (GLint button, GLint state, GLint x, GLint y){
	if(button == GLUT_LEFT_BUTTON){
		if(state == GLUT_DOWN){
			pontos[0][indice] = x;
			pontos[1][indice] = y;
			indice++;
		}
	}else {
		if(state == GLUT_DOWN){
			if(indice>0) {
				menor(x, y);
			}
		}
	}
	display();
	glFlush();
}

void myKeyboard (GLint key, GLint x, GLint y){
	switch(key){
	case GLUT_KEY_RIGHT : pontos[0][corrente] += doteSize; break;
	case GLUT_KEY_LEFT : pontos[0][corrente] -= doteSize; break;
	case GLUT_KEY_UP : pontos[1][corrente]-= doteSize; break;
	case GLUT_KEY_DOWN : pontos[1][corrente] += doteSize; break;
	}
	display();
	glFlush();
}

void menor(GLint x, GLint y){
	GLdouble menor = distancia(0, x, y);
	for(int k=0;k<indice;k++){
		GLdouble d = distancia(k, x, y);
		if(menor > d){
			menor = d;
			corrente = k;
		}
	}
}

GLdouble distancia (GLint i, GLint x, GLint y){
	return sqrt(pow(pontos[0][i] - x, 2) + pow(pontos[1][i] - y, 2));
}
*/
