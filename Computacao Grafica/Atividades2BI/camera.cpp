#include <gl/glut.h>
#include <math.h>
#include <stdio.h>

#include "camera.h"

static float pi = 3.14;

Camera::Camera(void) {
	this->angle = 45;
	this->aspect = 1200 / 720;
	this->N = 0.5;
	this->F = 500;
	this->eye.set(0, 80, 200);
	this->look.set(0, 0, 0);
	this->up.set(0, 1, 0);
	//?!
	this->u.set(0, 0, 0);
	this->v.set(0, 0, 0);
	this->n.set(0, 0, 0);
}

void Camera::setShape(float vAngle, float asp, float nr, float fr) {
	this->angle = vAngle;
	this->aspect = asp;
	this->N = nr;
	this->F = fr;
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(this->angle, this->aspect, this->N, this->F);
	//glMatrixMode(GL_MODELVIEW);
}

void Camera::setModelViewMatrix(void) {
	float m[16];
	Vector3 eVec(this->eye.x, this->eye.y, this->eye.z);
	m[0] = this->u.x;
	m[4] = this->u.y;
	m[8] = this->u.z;
	m[12] = -eVec.dot(this->u);
	m[1] = this->v.x;
	m[5] = this->v.y;
	m[9] = this->v.z;
	m[13] = -eVec.dot(this->v);
	m[2] = this->n.x;
	m[6] = this->n.y;
	m[10] = this->n.z;
	m[14] = -eVec.dot(this->n);
	m[3] = 0;
	m[7] = 0;
	m[11] = 0;
	m[15] = 0;
	glMatrixMode(GL_MODELVIEW);
	glLoadMatrixf(m);
	glLoadIdentity();
	gluLookAt(this->eye.x, this->eye.y, this->eye.z, this->look.x, this->look.y,
			this->look.z, this->up.x, this->up.y, this->up.z);
}

void Camera::set(Vector3 eye, Vector3 look, Vector3 up) {
	this->eye.set(eye);
	this->n.set(eye.x - look.x, eye.y - look.y, eye.z - look.z);
	this->u.set(up.cross(n).x, up.cross(n).y, up.cross(n).z);
	this->v.set(n.cross(u).x, n.cross(u).y, n.cross(u).z);
	this->setModelViewMatrix();
}

void Camera::update(void) {

	/*glMatrixMode(GL_PROJECTION);
	 glLoadIdentity();
	 gluPerspective(this->angle, this->aspect, this->N, this->F);
	 glMatrixMode(GL_MODELVIEW);
	 glLoadIdentity();
	 gluLookAt(this->eye.x, this->eye.y, this->eye.z, this->look.x, this->look.y,
	 this->look.z, this->up.x, this->up.y, this->up.z);*/
	this->setShape(this->angle, this->aspect, this->N, this->F);
	this->set(this->eye, this->look, this->up);
}

void Camera::roll(float angle) {
	float cs = cos(pi / 180.0 * angle);
	float sn = sin(pi / 180.0 * angle);
	Vector3 t = u;
	u.set(cs * t.x - sn * v.x, cs * t.y - sn * v.y, cs * t.z - sn * v.z);
	v.set(sn * t.x + cs * v.x, sn * t.y + cs * v.y, sn * t.z + cs * v.z);
	this->setModelViewMatrix();
}

void Camera::pitch(float angle) {
	float cs = cos(pi / 180.0 * angle);
	float sn = sin(pi / 180.0 * angle);
	Vector3 t = v;
	v.set(cs * t.x - sn * n.x, cs * t.y - sn * n.y, cs * t.z - sn * n.z);
	n.set(sn * t.x + cs * n.x, sn * t.y + cs * n.y, sn * t.z + cs * n.z);
	this->setModelViewMatrix();
}

void Camera::yaw(float angle) {
	float cs = cos(pi / 180.0 * angle);
	float sn = sin(pi / 180.0 * angle);
	Vector3 t = n;
	n.set(cs * t.x - sn * u.x, cs * t.y - sn * u.y, cs * t.z - sn * u.z);
	u.set(sn * t.x + cs * u.x, sn * t.y + cs * u.y, sn * t.z + cs * u.z);
	this->setModelViewMatrix();
}

void Camera::zoomIN(float angle) {
	this->angle -= angle;
	this->update();
}

void Camera::zoomOUT(float angle) {
	this->angle += angle;
	this->update();
}

void Camera::setAngle(float angle) {
	this->angle = angle;
}

void Camera::setAspect(float aspect) {
	this->aspect = aspect;
}
