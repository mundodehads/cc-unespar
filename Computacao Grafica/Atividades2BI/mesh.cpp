#include <gl/glut.h>
#include <string.h>
#include <iostream>
#include <fstream>
#include <math.h>

#include "mesh.h"
#include "vector3.h"

using namespace std;

static float pi = 3.14;

Mesh::Mesh(void) {
	this->num_face = 0;
}

void Mesh::read(string path) {
	string linha;
	ifstream myfile(path);
	int i = 1, j = 0;
	if (myfile.is_open()) {
		while (getline(myfile, linha)) {
			if (linha.c_str()[0] == 'v') {
				linha[0] = ' ';
				sscanf(linha.c_str(), "%f %f %f ", &this->vertice[i].x,
						&this->vertice[i].y, &this->vertice[i].z);
				i++;
			} else if (linha.c_str()[0] == 'f') {
				linha[0] = ' ';
				sscanf(linha.c_str(), "%i%i%i", &this->face[j].x,
						&this->face[j].y, &this->face[j].z);
				j++;
				this->num_face++;
			}
		}
	}
	myfile.close();
}

void Mesh::write(void) {
	glColor3f(0.0f, 1.0f, 0.0f);
	for (int i = 0; i<this->num_face; i++) {
		glBegin(GL_TRIANGLES);
		glVertex3f(this->vertice[this->face[i].x].x,
				this->vertice[this->face[i].x].y,
				this->vertice[this->face[i].x].z);
		glVertex3f(this->vertice[this->face[i].y].x,
				this->vertice[this->face[i].y].y,
				this->vertice[this->face[i].y].z);
		glVertex3f(this->vertice[this->face[i].z].x,
				this->vertice[this->face[i].z].y,
				this->vertice[this->face[i].z].z);
		glEnd();
		glFlush();
	}
	glFlush();
}

Vector3 Mesh::getVertice(int index) {
	return this->vertice[index];
}

void Mesh::setVertice(float x, float y, float z, int index) {
	this->vertice[index].set(x, y, z);
}


void Mesh::rotx(void){
	for(int i=0; i<this->num_face; i++){
		float y = this->vertice[i].y*cos(pi/4)-this->vertice[i].z*sin(pi/4);
		float z = this->vertice[i].y*sin(pi/4)+this->vertice[i].z*cos(pi/4);
		this->vertice[i].y = y;
		this->vertice[i].z = z;
	}
}

void Mesh::rotX(void){
	for(int i=0; i<this->num_face; i++){
		float y = this->vertice[i].y*cos(-pi/4)-this->vertice[i].z*sin(-pi/4);
		float z = this->vertice[i].y*sin(-pi/4)+this->vertice[i].z*cos(-pi/4);
		this->vertice[i].y = y;
		this->vertice[i].z = z;
	}
}

void Mesh::roty(void){
	for(int i=0; i<this->num_face; i++){
		float x = this->vertice[i].z*sin(pi/4)+this->vertice[i].x*cos(pi/4);
		float z = this->vertice[i].z*cos(pi/4)-this->vertice[i].x*sin(pi/4);
		this->vertice[i].x = x;
		this->vertice[i].z = z;
	}
}

void Mesh::rotY(void){
	for(int i=0; i<this->num_face; i++){
		float x = this->vertice[i].z*sin(-pi/4)+this->vertice[i].x*cos(-pi/4);
		float z = this->vertice[i].z*cos(-pi/4)-this->vertice[i].x*sin(-pi/4);
		this->vertice[i].x = x;
		this->vertice[i].z = z;
	}
}

void Mesh::rotz(void){
	for(int i=0; i<this->num_face; i++){
		float x = this->vertice[i].x*cos(pi/4)-this->vertice[i].y*sin(pi/4);
		float y = this->vertice[i].x*sin(pi/4)+this->vertice[i].y*cos(pi/4);
		this->vertice[i].x = x;
		this->vertice[i].y = y;
	}
}

void Mesh::rotZ(void){
	for(int i=0; i<this->num_face; i++){
		float x = this->vertice[i].x*cos(-pi/4)-this->vertice[i].y*sin(-pi/4);
		float y = this->vertice[i].x*sin(-pi/4)+this->vertice[i].y*cos(-pi/4);
		this->vertice[i].x = x;
		this->vertice[i].y = y;
	}
}
