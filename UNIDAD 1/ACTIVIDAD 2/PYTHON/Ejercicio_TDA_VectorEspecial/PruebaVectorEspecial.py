from builtins import input, len
from numba.tests.cache_usecases import self_test

class PruebaVectorEspecial:
    def __init__(self, tamaño):
        self.edades = []
        self.tamaño = tamaño

    def llenarVector(self):
        print("Ingresa las edades")
        for i in range( self.tamaño ):
            self.edades.append(int(input("Ingresar edad: ")))

    def mostarVector(self):
        for e in self.edades:
            print(e, end=" ")
            print()

    def obtenerPosicionInicio(self):
        return 0;

    def obtenerPosicionFinal(self):
        return len(self.edades) - 1

    def obtenerCantidadElementos(self):
        return len(self.edades)

    def __str__(self):
        return str(self.edades)

    def mostrarPrimerElemento(self):
        return self.edades[0]

    def mostrarUltimoElemento(self):
        return self.edades[len(self.edades) - 1]

    def incrementarTamaño(self, nuevoTamaño):
        self.tamaño = nuevoTamaño
        aux = self.edades.copy()
        aux.append(0)
        aux.append(0)
        aux.append( 0 )
        self.edades= aux

print("¿Que tamaño deseas para el vector?")
t= int(input())
vector1 = PruebaVectorEspecial(t)

vector1.llenarVector()
vector1.mostarVector()
print("Las edades son: ")
print(vector1)

print("")
print("El primer elemento del vector es: ")
print(vector1.mostrarPrimerElemento())

print("")
print("El ultimo elemento del vector es: ")
print(vector1.mostrarUltimoElemento())

print("")
print("Nuevas posiciones del vector: ")
vector1.incrementarTamaño(3)
print(vector1)