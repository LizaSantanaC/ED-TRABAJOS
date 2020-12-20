from pip._vendor.distlib.compat import raw_input
class CadenaCaracteres:
    def __init__(self, cadena):
        self.__cadena = cadena

    def getCadena(self):
        return self.__cadena

    def setCadena(self, cadena):
        self.__cadena = cadena

    def cadenaInvertida(self):
        temporal = reversed( self.getCadena() )
        print( "[", end="" )
        for e in temporal:
            for i in range( len( e ) - 1, -1, -1 ):
                print( e[i], end="" )
            print( "    ", end="" )
        print( "]", end="" )
        print()

    def eliminarCaracterPosicion(self, x, z):
        x = x - 1
        z = z - 1
        cadena = self.getCadena()
        while (x >= len( cadena )):
            print( "No existe esta posiciòn, ingresa nuevamente: " )
            x = (self.validacion() - 1)

        fragme = cadena[x]
        while (z > len( fragme )):
            print( "No existe esta posiciòn, ingresa nuevamente:" )
            z = (self.validacion() - 1)

        if (z == 0):
            fragme = fragme[1:]
        elif (z == len( fragme ) - 1):
            fragme = fragme[:-2]
        else:
            fragme = fragme[0:z] + fragme[z + 1:]

        cadena[x] = fragme
        self.setCadena( cadena )

    def eliminarfragmentoPosiscion(self, y):
        y = y - 1
        cadena = self.getCadena()
        while (y >= len( cadena )):
            print( "No existe esta posiciòn, ingresa nuevamente:" )
            sub = self.validacion() - 1

        if (sub == 0):
            for i in range( len( cadena ) - 1 ):
                cadena[i] = cadena[i + 1]

        elif (sub == len( cadena ) - 1):
            pass
        else:
            for i in range( len( cadena ) - 1 ):
                if (i >= y):
                    cadena[i] = cadena[i + 1]
        cadena.pop()
        self.setCadena( cadena )

    def mayusYMinus(self):
        s = ""
        cadena = self.getCadena()
        for i in range( len( cadena ) ):
            s = s + cadena[i] + " "

        cadMa = s.upper()
        cadMi = s.lower()
        m = 0

        for i in range( len( s ) ):
            if (s[i] != ' '):
                m += 1
            if (m % 2 != 0):
                print( cadMa[i], end="" )
            else:
                print( cadMi[i], end="" )
        print()

    def primeraMayuscula(self):
        cadena = self.getCadena()
        for i in range( len( cadena ) ):
            print( cadena[i].capitalize(), end="    " )
        print()

    def validacion(self):
        feil = 1
        while feil == 1:
            try:
                re = int( input() )
            except:
                print( "Ingresa un nùmero valido, que no sea negativo" )
                feil = 1
            else:
                if re > 0:
                    feil = 0
                else:
                    print( "Ingresa un nùmero valido, que no sea negativo" )
                    feil = 1
        return re


cdc = CadenaCaracteres( [""] )
opcion = 0

print( "Tamaño del vector: " )
tam = cdc.validacion()

print( "Palabra: " )
cad = []
for i in range( tam ):
    cad.append( str( input( f"Ingresa la palabra {i + 1}: " ) ) )

cdc1 = CadenaCaracteres( cad )

while opcion != 6:
    print( "1. INvertir cadena" )
    print( "2 Eliminar caracter en posicion especifica " )
    print( "3 Eliminar posicion especifica" )
    print( "4 Camel Case" )
    print( "5 Primera letra mayuscula" )
    print( "6 Salir" )

    opcion = cdc.validacion()

    if opcion < 1 or opcion > 6:
        print( "Opcion invalida" )
    elif opcion == 1:
        cdc1.cadenaInvertida()
    elif opcion == 2:
        print( "ingresa la posicion: " )
        x = cdc.validacion()
        print( "Ingresa la posicion: " )
        z = cdc.validacion()
        cdc1.eliminarCaracterPosicion( x, z )
    elif opcion == 3:
        print( "Ingresa la posicion: " )
        y = cdc.validacion()
        cdc.eliminarfragmentoPosiscion( y )
    elif opcion == 4:
        cdc1.mayusYMinus()
    elif opcion == 5:
        cdc1.primeraMayuscula()
print( "El programa ah finalizado" )
