class Nodo:
def __init__(self, info):
    if info is None:
        self.__info = int()
    else:
        self.__info = info
    self.__nSiguiente = None


def getInfo(self):
    return self.__info


def setSet(self, info):
    self.__info = info


def getnSiguiente(self):
    return self.__nSiguiente


def setnSiguiente(self, nSiguiente):
    self.__nSiguiente = nSiguiente


def __str__(self):
    return ("Nodo [Información=" + str( self.getInfo() ) + ", nodoSiguiente=" + str( self.getnSiguiente() ) + "]")


class ListaEnlazada:
    def __init__(self):
        self.nodoInicio = None
        self.nodoFin = None

    def vacia(self):
        return self.nodoInicio == None

    def agregarElementoAlInicio(self, info):
        nuevoNodo = Nodo( info )
        if (self.vacia()):
            self.nodoInicio = nuevoNodo
            self.nodoFin = nuevoNodo
        else:
            nuevoNodo.setNodoSiguiente( self.nodoInicio )
            self.nodoInicio = nuevoNodo

    def agregarElementoAlFinal(self, info):
        nuevoNodo = Nodo( info )
        if self.vacia():
            self.nodoInicio = nuevoNodo
            self.nodoFin = nuevoNodo
        else:
            nodoActual = self.nodoInicio
            while (nodoActual.getnSiguiente() != None):
                nodoActual = nodoActual.getnSiguiente()
            nodoActual.setnSiguiente( nuevoNodo )

    def eliminarElementoAlInicio(self):
        if (self.vacia()):
            print( "La lista está vacía" )
        elif (self.nodoInicio == self.nodoFin):
            self.nodoInicio = None
            self.nodoFin = None
        else:
            nodoActual = self.nodoInicio
            self.nodoInicio = nodoActual.getnSiguiente()

    def eliminarElementoAlFinal(self):
        if (self.vacia()):
            print( "La lista está vacía" )

        elif (self.nodoInicio == self.nodoFin):
            self.nodoInicio = None
            self.nodoFin = None
        else:
            self.nodoAnterior = self.nodoInicio
            self.nodoSiguiente = self.nodoInicio.getnSiguiente()
            if (self.nodoSiguiente == None):
                self.nodoInicio = None
                self.nodoFin = None
            else:
                while (self.nodoSiguiente.getnSiguiente() != None):
                    self.nodoAnterior = self.nodoAnterior.getNodoSiguiente()
                    self.nodoSiguiente = self.nodoSiguiente.getNodoSiguiente()
                self.nodoAnterior.setnSiguiente( None )

    def eliminarDatoEspecifico(self, info):
        if (self.vacia()):
            return (-1)
        elif ((self.nodoInicio == self.nodoFin) and (self.nodoInicio.getInfo() == info)):
            print( "Encontrado en el primer nodo" )
            n = self.nodoInicio.getInfo()
            self.nodoInicio = self.nodoInicio.getnSiguiente()
            self.nodoFin = self.nodoInicio
            return n
        else:
            nodoAnterior = self.nodoInicio
            nodoSiguiente = self.nodoInicio.getnSiguiente()

            if ((nodoAnterior != None) and (nodoAnterior.getInfo() == info)):
                n = nodoAnterior.getInfo()
                self.nodoInicio = nodoAnterior.getnSiguiente();
                return n

            else:
                while ((nodoSiguiente != None) and (nodoSiguiente.getInfo() != info)):
                    nodoAnterior = nodoAnterior.getnoSiguiente()
                    nodoSiguiente = nodoSiguiente.getnSiguiente()

                if ((nodoSiguiente != None) and (nodoSiguiente.getInfo() == info)):
                    n = nodoSiguiente.getInfo()
                    nodoSiguiente = nodoSiguiente.getnSiguiente()
                    nodoAnterior.setnSiguiente( nodoSiguiente )
                    return n
                else:
                    return (-2)

    def mostrarElementos(self):
        nodoActual = self.nodoInicio
        while (nodoActual != None):
            print( "[" + str( nodoActual.getInfo() ) + "]-->", end="" )
            nodoActual = nodoActual.getnSiguiente()
        print()


num = 0
le = ListaEnlazada()
opcion = 0
info = 0

while True:
    print(
        "1)Crear Lista\n2)Verificar Lista vacia\n3)Insertar elemento\n4)Eliminar elemento\n5)Mostrar cantidad de elementos\n6)Salir" )

    print( "1. Insertar elemento" )
    print( "2. Eliminar elemento" )
    print( "3. Mostrar elementos" )
    print( "4. Salir " );
    opcion = int( input( "Escribe una opción" ) )

    if (opcion == 1):
        while True:
            print( "1)Inicio\n2)Final\n3)En posicion especifica\n4)Salir" )
            print( "1. Insertar elemento al inicio" )
            print( "2. Insertar elemento al final" )
            print( "3. Salir " );
            opcion = int( input( "Escribe una opción" ) )
            if (opcion == 1):
                info = int( input( print( "Escribe el dato a ingresar" ) )
                le.agregarElementoAlInicio( info )
                elif (opcion == 2):
                info = int( input( print( "Escribe el dato a ingresar" ) )
                le.agregarElementoAlFinal( info )
                elif (opcion == 3):
                break
            else:
                print( "Debes ingresar números entre 1 y 3" )
    elif (opcion == 2):
        while True:
            print( "1)Inicio\n2)Final\n3)Elemento especifico\n4)Salir" )
            print( "1. Eliminar elemento al inicio" )
            print( "2. Eliminar elemento al final" )
            print( "3. Eliminar dato específico" )
            print( "4. Salir" )
            opcion = int( input( "Escribe una opción" ) )
            if (opcion == 1):
                le.eliminarElementoAlInicio()
            if (opcion == 2):
                le.eliminarElementoAlFinal()
            elif (opcion == 3):
                info = int( input( print( "Ingresa el dato a eliminar: " ) )
                num = le.eliminarDatoEspecifico( info )
                if (num == (-1)):
                    print( "Lista Vacía" )
                elif (num == (-2)):
                    print( "No se encontró el dato" )
                else:
                    print( "Se eliminó correctamente" )
                elif (opcion == 4):
                break
            else:
                print( "Debes ingresar números entre 1 y 4" )
    elif (opcion == 3):
        le.mostrarCantidadElementos()
    elif (opcion == 4):
        break
    else:
        print( "Debes ingresar números entre 1 y 4" )
