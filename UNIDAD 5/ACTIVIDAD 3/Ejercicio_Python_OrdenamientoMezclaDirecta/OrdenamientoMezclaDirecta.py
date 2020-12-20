from random import randint


class OrdenamientoMezclaDirecta:
    def ordenamientoMezclaDirecta(self, array):
        mitad = len(array) // 2
        if len(array) >= 2:
            arregloIz = array[mitad:]
            arregloDer = array[:mitad]
            array.clear()
            self.ordenamientoMezclaDirecta(arregloIz)
            self.ordenamientoMezclaDirecta(arregloDer)
            while (len(arregloDer) > 0 and len(arregloIz) > 0):
                if (arregloIz[0] < arregloDer[0]):
                    array.append(arregloIz.pop(0))
                else:
                    array.append(arregloDer.pop(0))
            while len(arregloIz) > 0:
                array.append(arregloIz.pop(0))
            while len(arregloDer) > 0:
                array.append(arregloDer.pop(0))
        return array

    def sacarInfoArchivo(self):
        archivo = open("archivo.txt", "r")
        palabrasArchivo = archivo.read()
        archivo.close()
        arrayCad = palabrasArchivo.split(",")
        arrayInt = []
        for i in range(0, len(arrayCad) - 1):
            # print(arrayCad[i])
            arrayInt.append(int(arrayCad[i]))
        return arrayInt
        pass

    def metoreInfo(self, vector):
        copiaString = ""
        for i in range(0, len(vector)):
            copiaString = copiaString + str(vector[i]) + ","
        ruta = "archivo.txt"
        archivo = open(ruta, "w")
        archivo.write(copiaString)
        archivo.close()
        pass


o1 = OrdenamientoMezclaDirecta()
vector1 = [randint(-50, 50) for i in range(20)]
o1.metoreInfo(vector1)
print(f"Arreglo sin ordenar: {vector1}")
vector2 = o1.ordenamientoMezclaDirecta(vector1)
print(f"Arreglo ordenado: {vector2}")

numerosArchivo = o1.sacarInfoArchivo()
print(f"Numeros del archivo desordenados: {numerosArchivo}")
o1.ordenamientoMezclaDirecta(numerosArchivo)
print(f"Numeros del archivo ordenados: {numerosArchivo}")
o1.metoreInfo(numerosArchivo)

