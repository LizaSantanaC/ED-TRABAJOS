class NodoArbol:
    def __init__(self, dato):
        if dato is None:
            self.__dato = (-1)
        else:
            self.__dato = dato
        self.__nodoIzq = None
        self.__nodoDer = None

    def getDato(self):
        return self.__dato

    def setDato(self, dato):
        self.__dato = dato

    def getNodoIzq(self):
        return self.__nodoIzq

    def setNodoIzq(self, nodoIzq):
        self.__nodoIzq = nodoIzq

    def getNodoDer(self):
        return self.__nodoDer

    def setNodoDer(self, nodoDer):
        self.__nodoDer = nodoDer

    def __str__(self):
        return ("Nodo [nodoIzq=" + str( self.getNodoIzq() ) + ", dato=" + str(
            self.getDato() ) + ", nodoSiguiente=" + str( self.getNodoDer() ) + "]")


class ArbolBinario:
    def __init__(self):
        self.nodoRaiz = None

    def agregarElemento(self, dato):
        nuevoNodo = NodoArbol( dato )
        if (self.nodoRaiz == None):
            self.nodoRaiz = nuevoNodo
        else:
            aux = self.nodoRaiz
            nodoAnterior = None

            while (aux != None):
                nodoAnterior = aux

                if (dato >= aux.getDato()):
                    aux = aux.getNodoIzq()
                    if (aux == None):
                        nodoAnterior.setNodoIzq( nuevoNodo )
                else:
                    aux = aux.getNodoDer()
                    if (aux == None):
                        nodoAnterior.setNodoDer( nuevoNodo )

    def desplazar(self, nodo):
        anterior = nodo
        ret = nodo
        aux = nodo.getNodoDer()
        while (aux != None):
            anterior = ret
            ret = aux
            aux = aux.getNodoIzq()
        if (ret != nodo.getNodoDer()):
            anterior.setNodoIzq( ret.getNodoDer() )
            ret.setNodoIzq( nodo.getNodoDer() )
        return ret

    def eliminarElemento(self, dato):

        if (self.nodoRaiz != None):

            nodoAnterior = self.nodoRaiz
            aux = self.nodoRaiz

            while ((aux.getDato() != dato)):
                nodoAnterior = aux

                if (aux.getDato() <= dato):
                    esIzq = 1
                    aux = aux.getNodoIzq()
                else:
                    esIzq = 0
                    aux = aux.getNodoDer()

            if (aux == None):
                print( "No se encontro el dato" )
                return False
            else:
                print( "Se encontro el dato" )

            if (aux.getNodoIzq() == None and aux.getNodoDer() == None):
                if (aux == self.nodoRaiz):
                    self.nodoRaiz = None
                elif (esIzq == 1):
                    nodoAnterior.setNodoIzq( None )
                else:
                    nodoAnterior.setNodoDer( None )
            elif (aux.getNodoIzq() == None):
                if (aux == self.nodoRaiz):
                    self.nodoRaiz = aux.getNodoDer()
                elif (esIzq == 1):
                    nodoAnterior.setNodoIzq( aux.getNodoDer() )
                else:
                    nodoAnterior.setNodoDer( aux.getNodoDer() )

            elif (aux.getNodoDer() == None):
                if (aux == self.nodoRaiz):
                    self.nodoRaiz = aux.getNodoIzq()
                elif (esIzq == 1):
                    nodoAnterior.setNodoIzq( aux.getNodoIzq() )
                else:
                    nodoAnterior.setNodoDer( aux.getNodoIzq() )

            else:
                desp = self.desplazar( aux )
                if (aux == self.nodoRaiz):
                    self.nodoRaiz = desp
                elif (esIzq == 1):
                    nodoAnterior.setNodoIzq( desp )
                else:
                    nodoAnterior.setNodoDer( desp )

                desp.setNodoIzq( aux.getNodoIzq() )

            return True
        else:
            print( "El arbol esta vacio" )
            return False

    def recorridoPreorden(self, nodoRaiz):
        if (nodoRaiz != None):
            print( str( nodoRaiz.getDato() ), end=" => " )
            self.recorridoPreorden( nodoRaiz.getNodoIzq() )
            self.recorridoPreorden( nodoRaiz.getNodoDer() )

    def recorridoEnorden(self, nodoRaiz):
        if (nodoRaiz != None):
            self.recorridoEnorden( nodoRaiz.getNodoIzq() )
            print( str( nodoRaiz.getDato() ), end=" => " )
            self.recorridoEnorden( nodoRaiz.getNodoDer() )

    def recorridoPostorden(self, nodoRaiz):
        if (nodoRaiz != None):
            self.recorridoPostorden( nodoRaiz.getNodoIzq() )
            self.recorridoPostorden( nodoRaiz.getNodoDer() )
            print( str( nodoRaiz.getDato() ), end=" => " )

    def mostrarDatoMayor(self):
        if (self.nodoRaiz == None):
            print( "El arbol esta vacio" )
        else:
            aux = self.nodoRaiz
            nodoAnterior = None

            while (aux != None):
                nodoAnterior = aux
                aux = aux.getNodoIzq()
                if (aux == None):
                    print( "Numero mayor: " + str( nodoAnterior.getDato() ) )

    def mostrarDatoMenor(self):
        if (self.nodoRaiz == None):
            print( "El arbol esta vacio" )
        else:
            aux = self.nodoRaiz
            nodoAnterior = None

            while (aux != None):
                nodoAnterior = aux
                aux = aux.getNodoDer()
                if (aux == None):
                    print( "Numero menor: " + str( nodoAnterior.getDato() ) )

    def buscarDato(self, nodo, dato, encontrado):
        if (nodo != None):
            if (dato == nodo.getDato()):
                encontrado += 1
            encontrado += self.buscarDato( nodo.getNodoIzq(), dato, encontrado )
            encontrado += self.buscarDato( nodo.getNodoDer(), dato, encontrado )

        return encontrado


op = 0
dato = 0
num = 0
ab = ArbolBinario()

while True:
    print( "1)Crear arbol" )
    print( "2)Insertar nodo" )
    print( "3)Eliminar nodo" )
    print( "4)Mostrar nodos" )
    print( "5)Mostrar dato mayor" )
    print( "6)Mostrar dato menor" )
    print( "7)Buscar dato" )
    print( "8)Salir" )
    op = int( input( "Escribe una opcion" ) )
    if (op == 1):
        ab = ArbolBinario()
        print( "Se creo el arbol" )
    elif (op == 2):
        dato = int( input( "Ingresa el elemento a insertar:" ) )
        ab.agregarElemento( dato )
    elif (op == 3):
        dato = int( input( "Ingresa el elemento a eliminar:" ) )
        ab.eliminarElemento( dato )
    elif (op == 4):
        while True:
            print( "1)Preorden" )
            print( "2)Inorden" )
            print( "3)Postorden" )
            print( "4)Salir" )
            opc = int( input( "Escribe una opcion" ) )
            if (opc == 1):
                ab.recorridoPreorden( ab.nodoRaiz )
            elif (opc == 2):
                ab.recorridoEnorden( ab.nodoRaiz )
            elif (opc == 3):
                ab.recorridoPostorden( ab.nodoRaiz )
            elif (opc == 4):
                break
            else:
                print( "Opcion invalida" )
        print()
    elif (op == 5):
        ab.mostrarDatoMayor()
    elif (op == 6):
        ab.mostrarDatoMenor()
    elif (op == 7):
        dato = int( input( "Ingresa el dato a buscar: " ) )
        encontrado = ab.buscarDato( ab.nodoRaiz, dato, 0 )
        if (encontrado > 0):
            print( "Se encontro el dato" )
        else:
            print( "No se encontro el dato" )
    elif (op == 8):
        break
    else:
        print( "Opcion invalida" )
