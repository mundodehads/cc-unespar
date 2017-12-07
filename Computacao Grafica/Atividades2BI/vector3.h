#ifndef VECTOR3_H
#define VECTOR3_H

class Vector3 {
public:
	Vector3(void);
	Vector3(float, float, float);
	void set(float, float, float);
	void set(Vector3);
	Vector3* get(void);
	float x, y, z;

	Vector3 cross(Vector3 rhs);
	float dot(Vector3 rhs);
	float Length();
	Vector3 normalize(void);
};

#endif
