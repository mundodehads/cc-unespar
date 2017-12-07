#include <gl/glut.h>

#include "mesh.h"
#include "camera.h"

GLfloat resolutionWidth;
GLfloat resolutionHeight;
GLfloat windowWidth;
GLfloat windowHeight;
Mesh m;
Camera c;

//Variaveis extras
int cont;
float cx, cy;
GLfloat posicaoLuz[4] = { 0.0, 5.0, 40.0, 1.0 };

void display(void);
void myInit(void);
void myReshape(GLsizei w, GLsizei h);
void myKeyboard(unsigned char key, GLint x, GLint y);
void myMouse(int button, int state, int x, int y);

void Awake() {
	resolutionWidth = 1366;
	resolutionHeight = 768;
	windowWidth = 800;
	windowHeight = 600;
	cont = 0;
	cx = 0.0f;
	cy = -90.0f;

	m = Mesh();
	c = Camera();
	m.read("Navio.obj");
}

int main(int argc, char **argv) {
	Awake();
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(windowWidth, windowHeight);
	glutInitWindowPosition((resolutionWidth / 2) - (windowWidth / 2),
			(resolutionHeight / 2) - (windowHeight / 2));
	//glViewport(0, 0, 200, 150);
	glutCreateWindow("ComputacaoGrafica - ProvaB2");
	glutDisplayFunc(display);
	glutReshapeFunc(myReshape);
	glutKeyboardFunc(myKeyboard);
	glutMouseFunc(myMouse);
	myInit();
	glutMainLoop();
	return 0;
}


void display(void) {
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	//glClear(GL_COLOR_BUFFER_BIT);
	m.write();
	glLightfv(GL_LIGHT0, GL_POSITION, posicaoLuz);

	//glFlush();
	glutSwapBuffers();
}

void myMouse(int button, int state, int x, int y) {
	if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN) {
		cx = x;
		cy = y;
	}
	glutPostRedisplay();
}

void myReshape(GLsizei w, GLsizei h) {
	if (h == 0)
		h = 1;
	glViewport(0, 0, w, h);
	c.setAspect((GLfloat) w / (GLfloat) h);
	c.update();
}

void myKeyboard(unsigned char key, GLint x, GLint y) {
	switch (key) {
	case 'd': {
		posicaoLuz[0] += 10.0f;
		glutPostRedisplay();
		break;
	}
	case 'a': {
		posicaoLuz[0] -= 10.0f;
		glutPostRedisplay();
		break;
	}
	case 'j': {
		m.rotx();
		display();
		break;
	}
	case 'J': {
		m.rotX();
		display();
		break;
	}
	case 'k': {
		m.roty();
		display();
		break;
	}
	case 'K': {
		m.rotY();
		display();
		break;
	}
	case 'l': {
		m.rotz();
		display();
		break;
	}
	case 'L': {
		m.rotZ();
		display();
		break;
	}
	case 'p': {
		c.pitch(10);
		glutPostRedisplay();
		break;
	}
	case 'P': {
		c.pitch(-10);
		glutPostRedisplay();
		break;
	}
	case 'r': {
		c.roll(10);
		glutPostRedisplay();
		break;
	}
	case 'R': {
		c.roll(-10);
		glutPostRedisplay();
		break;
	}
	case 'y': {
		c.yaw(10);
		glutPostRedisplay();
		break;
	}
	case 'Y': {
		c.yaw(-10);
		glutPostRedisplay();
		break;
	}
	case 'z': {
		c.zoomIN(10);
		glutPostRedisplay();
		break;
	}
	case 'Z': {
		c.zoomOUT(10);
		glutPostRedisplay();
		break;
	}
	}
	//glutPostRedisplay();
}

void myInit(void) {
	c.zoomOUT(70);

	glShadeModel(GL_SMOOTH);

	glEnable(GL_COLOR_MATERIAL);
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);

	GLfloat luzAmbiente[4] = { 0.1, 0.1, 0.1, 1.0 };
	GLfloat luzDifusa[4] = { 1.0, 1.0, 1.0, 1.0 };
	GLfloat luzEspecular[4] = { 1.0, 1.0, 1.0, 1.0 };
	glLightfv(GL_LIGHT0, GL_AMBIENT, luzAmbiente);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, luzDifusa);
	glLightfv(GL_LIGHT0, GL_SPECULAR, luzEspecular);
	glLightfv(GL_LIGHT0, GL_POSITION, posicaoLuz);

	GLfloat vetorDir[] = {0.0, 1.0, 0.0};

	glLightf(GL_LIGHT0, GL_SPOT_CUTOFF, 80.0);
	glLightfv(GL_LIGHT0, GL_SPOT_DIRECTION, vetorDir);
	glLightf(GL_LIGHT0, GL_SPOT_EXPONENT, 2.0);
}
