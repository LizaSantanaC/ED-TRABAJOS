from array import array

class OrdenamientoMezclaNatural:
    def ordenamientoMezclaDirecta1(self, array):
        mitad = len(array) // 2
        if len(array) >= 2:
            arregloIz = array[mitad:]
            arregloDer = array[:mitad]
            array.clear()
            self.ordenamientoMezclaDirecta1(arregloIz)
            self.ordenamientoMezclaDirecta1(arregloDer)
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

    def ordenamientoMezclaDirecta2(self, array):
        mitad = len(array) // 2
        if len(array) >= 2:
            arregloIz = array[mitad:]
            arregloDer = array[:mitad]
            array.clear()
            self.ordenamientoMezclaDirecta1(arregloIz)
            self.ordenamientoMezclaDirecta1(arregloDer)
            while (len(arregloDer) > 0 and len(arregloIz) > 0):
                if (arregloIz[0] < arregloDer[0]):
                    array.append(arregloIz.pop(0))
                else:
                    array.append(arregloDer.pop(0))
                    while len(arregloIz) > 0:
                        array.append(arregloIz.pop(0))
                        while len(arregloDer) > 0:
                            array.append(arregloDer.pop(0))

    def ordenamientoMezclaNatural(self, numeros):
        izquerdo = 0
        izq = 0
        derecho = len(numeros) - 1
        der = derecho
        ordenado = False
        while (not ordenado):
            ordenado = True
            izquierdo = 0
            while (izquierdo < derecho):
                izq = izquerdo
                while (izq < derecho and numeros[izq] <= numeros[izq + 1]):
                    izq = izq + 1
                    der = izq + 1
                    while (der == derecho - 1 or der < derecho and numeros[der] <= numeros[der + 1]):
                        der = der + 1
                        if (der <= derecho):
                            self.ordenamientoMezclaDirecta2(numeros)
                            ordenado = False
                            izquierdo = izq

numeros = [40, 52, 6, 78, 63, 12, 13, 10, 47, 68, 40, 2, 1, 3, 64]
mezclaNatural = OrdenamientoMezclaNatural()
print(f"Desordenado: {numeros}")
mezclaNatural.ordenamientoMezclaNatural(numeros)
print(f"Ordenados: {numeros}")