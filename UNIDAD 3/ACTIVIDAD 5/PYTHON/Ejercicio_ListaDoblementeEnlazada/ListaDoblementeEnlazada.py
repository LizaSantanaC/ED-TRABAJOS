class Nodo:
    def __init__(self, info):
        if info is None:
            self.__info = int()
        else:
            self.__info = info
        self.__nodoSiguiente = None
        self.__nodoAnterior = None

    def getInfo(self):
        return self.__info

    def setInfo(self, info):
        self.__info = info

    def getNodoSiguiente(self):
        return self.__nodoSiguiente

    def setNodoSiguiente(self, nodoSiguiente):
        self.__nodoSiguiente = nodoSiguiente

    def getNodoAnterior(self):
        return self.__nodoAnterior

    def setNodoAnterior(self, nodoAnterior):
        self.__nodoAnterior = nodoAnterior

    def __str__(self):
        return ("Nodo [Información=" + str( self.getInfo() ) + ", nodoSiguiente=" + str(
            self.getNodoSiguiente() ) + ", nodoAnterior=" + str( self.getNodoAnterior() ) + "]")


class ListaDoblementeEnlazada:
    def __init__(self):
        self.nodoInicio = None
        self.nodoFin = None

    def vacia(self):
        return self.nodoInicio == None

    def agregarAlInicio(self, info):
        nuevoNodo = Nodo( info )
        if (self.vacia()):
            self.nodoInicio = nuevoNodo
            self.nodoFin = nuevoNodo
        else:
            nuevoNodo.setNodoSiguiente( self.nodoInicio )
            self.nodoInicio.setNodoAnterior( nuevoNodo )
            self.nodoInicio = nuevoNodo

    def agregarAlFinal(self, info):
        nuevoNodo = Nodo( info )
        if self.vacia():
            self.nodoInicio = nuevoNodo
            self.nodoFin = nuevoNodo
        else:
            nodoActual = self.nodoInicio
            while (nodoActual.getNodoSiguiente() != None):
                nodoActual = nodoActual.getNodoSiguiente()
            nodoActual.setNodoSiguiente( nuevoNodo )
            nuevoNodo.setNodoAnterior( nodoActual )

    def eliminarAlInicio(self):
        if (self.vacia()):
            print( "La lista está vacía" )
        elif (self.nodoInicio == self.nodoFin):
            self.nodoInicio = None
            self.nodoFin = None
        else:
            nodoActual = self.nodoInicio
            self.nodoInicio = nodoActual.getNodoSiguiente()
            self.nodoInicio.setNodoAnterior( None )

    def eliminarAlFinal(self):
        if (self.vacia()):
            print( "La lista está vacía" )

        elif (self.nodoInicio == self.nodoFin):
            self.nodoInicio = None
            self.nodoFin = None
        else:
            self.nodoAnterior = self.nodoInicio
            self.nodoSiguiente = self.nodoInicio.getNodoSiguiente()
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
            self.nodoInicio = self.nodoInicio.getNodoSiguiente()
            if (self.nodoInicio != None):
                self.nodoInicio.setNodoAnterior( None )
            self.nodoFin = self.nodoInicio
            return n
        else:
            nodoAnterior = self.nodoInicio
            nodoSiguiente = self.nodoInicio.getNodoSiguiente()

            if ((nodoAnterior != None) and (nodoAnterior.getInfo() == info)):
                n = nodoAnterior.getInfo()
                self.nodoInicio = nodoAnterior.getNodoSiguiente();
                self.nodoInicio.setNodoAnterior( None )
                return n

            else:
                while ((nodoSiguiente != None) and (nodoSiguiente.getInfo() != info)):
                    nodoAnterior = nodoAnterior.getNodoSiguiente()
                    nodoSiguiente = nodoSiguiente.getNodoSiguiente()

                if ((nodoSiguiente != None) and (nodoSiguiente.getInfo() == info)):
                    n = nodoSiguiente.getInfo()
                    nodoSiguiente = nodoSiguiente.getNodoSiguiente()
                    if (nodoSiguiente != None):
                        nodoSiguiente.setNodoAnterior( nodoAnterior )
                    nodoAnterior.setNodoSiguiente( nodoSiguiente )
                    return n
                else:
                    return (-2)

    def mostrarElementos(self):
        nodoActual = self.nodoInicio
        while (nodoActual != None):
            print( "<--[" + str( nodoActual.getInfo() ) + "]-->", end="" )
            nodoActual = nodoActual.getNodoSiguiente()
        print()


lde = ListaDoblementeEnlazada()
opcion = 0
info = 0

while True:

    print( "1. Insertar elemento" )
    print( "2. Eliminar elemento" )
    print( "3. Mostrar elementos" )
    print( "4. Salir " );
    opcion = int( input( "Escribe una opción" ) )

    if (opcion == 1):
        while True:
            print( "1. Insertar elemento al inicio" )
            print( "2. Insertar elemento al final" )
            print( "3. Salir " );
            opcion = int( input( "Escribe una opción" ) )
            if (opcion == 1):
                info1 = int( input( "Escribe el dato a ingresar" ) )
                lde.agregarAlInicio( info )
            elif (opcion == 2):
                info = int( input( "Escribe el dato a ingresar" ) )
                lde.agregarAlFinal( info )
            elif (opcion == 3):
                break
            else:
                print( "Elige una opciòn valida" )

    elif (opcion == 2):
        while True:
            print( "1. Eliminar elemento al inicio" )
            print( "2. Eliminar elemento al final" )
            print( "3. Eliminar dato específico" )
            print( "4. Salir" )
            opcion = int( input( "Escribe una opción" ) )
            if (opcion == 1):
                lde.eliminarAlInicio()
            elif (opcion == 2):
                lde.eliminarAlFinal()
            elif (opcion == 3):
                info = int( input( "Ingresa el dato a eliminar: " ) )
                num = lde.eliminarDatoEspecifico( info )
                lde.eliminarDatoEspecifico( info )
                if (num == (-1)):
                    print( "La lista esta vacía" )
                elif (num == (-2)):
                    print( "No se encontró el dato" )
                else:
                    print( "Se eliminó correctamente" )
            elif (opcion == 4):
                break
            else:
                print( "Elige una opciòn valida" )

    elif (opcion == 3):
        lde.mostrarElementos()
    elif (opcion == 4):
        break
    else:
        print( "Elige una opciòn valida" )
