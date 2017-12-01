/*
#include <math.h>
#include <GL/glut.h>
#include <stdio.h>


inline int f(int *lst){ return lst[0]; }

inline int s(int *lst){ return lst[1]; }

// sin
// cos

int largura =  640;
int hipotenusa = 150;
float angulo = 2*M_PI/3;
float angulo_circulo = 2*M_PI/180;// 2
int altura = 480;

void myInit(void)
{
    glClearColor(1.0, 1.0, 1.0, 0.0);
    glColor3f(0.0f, 0.0f, 0.0f);
    glPointSize(4.0);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0.0, largura, 0.0, altura);

}

inline float get_distancia(int *p1, int *p2)
{ return sqrt(pow(p1[0] - p2[0], 2) + pow(p1[1] - p2[1], 2)); }


desenhar_circulo(int *pcentro, float raio, int nlinhas)
{
    float angulo;
    glBegin(GL_LINE_STRIP);// desenhar um semi circulo muda esse LINE_LOOP
        int i = 0;
        for(i=0; i<=nlinhas; i++){
            angulo = i * M_PI / nlinhas;// apenas troquei o angulo para desenhar
                                        // um semi circulo, 2pi para pi
            glVertex2f(pcentro[0] + (cos(angulo) * raio), pcentro[1] + (sin(angulo)*raio));
        }
    glEnd();
}

void ponto_medio(int *pd, int *p1, int *p2)
{
    pd[0] = (int) (p1[0] + p2[0]) / 2;
    pd[1] = (int) (p1[1] + p2[1]) / 2;
}

void desenhar_ponto(int *ponto)
{
    glBegin(GL_POINTS);
       glVertex2i(ponto[0], ponto[1]);
    glEnd();
}

void desenhar_aresta(int *p1, int *p2)
{
    glBegin(GL_LINES);
        glVertex2i(p1[0], p1[1]);
        glVertex2i(p2[0], p2[1]);
    glEnd();
}


void desenha_sorvete(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glFlush();
}

void interacao_mause(int button, int state, int x, int y)
{
    int p1[2] = {x, altura - y};
    int p2[2];
    int p3[2];
    int praio[2];
    float raio;

    if(button == GLUT_LEFT_BUTTON && state == GLUT_DOWN){
        int ny = altura - y +  hipotenusa * sin(angulo/2.0);
        int x2, x3;
        x2 = x + hipotenusa * cos(angulo/2.0);
        x3 = x - hipotenusa * cos(angulo/2.0);


        p2[0]= x2;
        p2[1] = ny;

        // p3 vai ser onde vai iniciar a fazer o semi circulo
        p3[0] = x3;
        p3[1] = ny;

        desenhar_aresta(p2, p1);
        desenhar_aresta(p3, p1);

        //
        raio = get_distancia(p2, p3) / 2;

        ponto_medio(praio, p2, p3);

        desenhar_circulo(praio, raio, 20);


    }




    glFlush();
}


int main(int argc, char *argv[])
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize(largura, altura);
    //                 largura, altura
    glutInitWindowPosition(100, 150);
    glutCreateWindow("Desenha sorvetao");
    glutDisplayFunc(desenha_sorvete);
    glutMouseFunc(interacao_mause);

    myInit();
    glutMainLoop();


    return 0;
}
*/
