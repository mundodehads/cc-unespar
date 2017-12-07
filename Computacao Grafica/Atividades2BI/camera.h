#include "vector3.h"

#ifndef CAMERA_H
#define CAMERA_H

class Camera {

private:
	float angle, aspect, N, F;
	Vector3 eye, look, up;
	Vector3 u, v, n;
	void setModelViewMatrix(void);
public:
	Camera(void);
	void update(void);
	void setAngle(float);
	void setAspect(float);

	void set(Vector3, Vector3, Vector3);
	void setShape(float, float, float, float);

	void roll(float);
	void pitch(float);
	void yaw(float);
	void zoomIN(float);
	void zoomOUT(float);
};

#endif
