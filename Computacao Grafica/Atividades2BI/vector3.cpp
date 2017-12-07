#include "vector3.h"
#include <Math.h>

Vector3::Vector3(void) {
	this->x = 0;
	this->y = 0;
	this->z = 0;
}

Vector3::Vector3(float x, float y, float z) {
	this->x = x;
	this->y = y;
	this->z = z;
}

void Vector3::set(float x, float y, float z) {
	this->x = x;
	this->y = y;
	this->z = z;
}

void Vector3::set(Vector3 eye) {
	this->x = eye.x;
	this->y = eye.y;
	this->z = eye.z;
}

Vector3* Vector3::get(void) {
	return this;
}

Vector3 Vector3::cross(Vector3 rhs) {
	Vector3 aux;
	aux.x = y * rhs.z - z * rhs.y;
	aux.y = z * rhs.x - x * rhs.z;
	aux.z = x * rhs.y - y * rhs.x;
	return aux;
}

float Vector3::dot(Vector3 rhs) {
	return (x * rhs.x + y * rhs.y + z * rhs.z);
}

float Vector3::Length() {
	return sqrt(x * x + y * y + z * z);
}

Vector3 Vector3::normalize() {
	Vector3 vector;
	float length = this->Length();
	if (length != 0) {
		vector.x = x / length;
		vector.y = y / length;
		vector.z = z / length;
	}
	return vector;
}
