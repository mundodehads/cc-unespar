#include <string>
#include "vector3.h"

#ifndef MESH_H
#define MESH_H

using namespace std;

class Mesh {

struct Face {
	int x, y, z;
};

private:
	Vector3 vertice[5000];
	Face face[5000];
	int num_face;
public:
	Mesh(void);
	void read(string path);
	void write(void);
	Vector3 getVertice(int index);
	void setVertice(float x, float y, float z, int index);
	void rotx(void);
	void rotX(void);
	void roty(void);
	void rotY(void);
	void rotz(void);
	void rotZ(void);
};

#endif
